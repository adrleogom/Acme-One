
package acme.features.any.toolkit;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantity.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangeRepository;
import acme.forms.MoneyExchange;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyToolkitShowService implements AbstractShowService<Any, Toolkit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyToolkitRepository repository;
	
	@Autowired
	protected AuthenticatedMoneyExchangeRepository moneyExchangeRepository;

	// AbstractShowService<Any, Toolkit> interface --------------


	@Override
	public boolean authorise(final Request<Toolkit> request) {
		boolean result;
		int id;
		final Toolkit toolkit;

		id = request.getModel().getInteger("id");
		toolkit = this.repository.findOneToolkitById(id);
		result = toolkit.isPublished();

		return result;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneToolkitById(id);

		return result;
	}

	public MoneyExchange conversion(final Money money) {
		
		final AuthenticatedMoneyExchangePerformService moneyExchange = new AuthenticatedMoneyExchangePerformService();
		
		MoneyExchange conversion = new MoneyExchange();
		
		final String systemCurrency = this.moneyExchangeRepository.findSystemCurrency();

		if(!money.getCurrency().equals(systemCurrency)) {
			
			conversion = moneyExchange.computeMoneyExchange(money, systemCurrency);
			
		}else {
			conversion.setSource(money);
			conversion.setTarget(money);
			conversion.setTargetCurrency(systemCurrency);
			conversion.setDate(new Date(System.currentTimeMillis()));
			
		}
		
		return conversion;
		
	}
	
	
	private Money retailPriceOfToolkit(final int toolkitid) {
		final Money result = new Money();
		Money retailPrice= new Money();
		
		final String systemCurrency = this.moneyExchangeRepository.findSystemCurrency();
		Double amount = 0.0;
		result.setCurrency(systemCurrency);
		
		final Collection<Quantity> quantities = this.repository.findQuantitiesByToolkitId(toolkitid);
		
		for(final Quantity quantity:quantities) {
			retailPrice= quantity.getItem().getRetailPrice();
			
			if(!Objects.equals(retailPrice.getCurrency(), systemCurrency)) {
				
				final MoneyExchange conversion= this.conversion(retailPrice);
				
				amount= amount+conversion.getTarget().getAmount();
			}else {
				amount += amount+retailPrice.getAmount();
			}
			
			result.setAmount(amount);
		}
		return result;
	}
	
	
	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Money retailPrice = this.retailPriceOfToolkit(entity.getId());
		
		model.setAttribute("retailPrice", retailPrice);
		model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
		
		model.setAttribute("retailPrice", this.retailPriceOfToolkit(entity.getId()));
		
		model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "furtherInfo","retailPrice");
	}

}
