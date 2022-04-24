package acme.features.inventor.toolkit;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.helper.toolkit.ToolkitHelperRepository;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit>{

	@Autowired
	protected InventorToolkitRepository toolkitRepository;
	
	@Autowired
	protected ToolkitHelperRepository helperRepository;
	

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request !=null;
		
		boolean result;
		int masterId;
		Toolkit toolkit;
		Inventor inventor;
		Principal principal;
		
		masterId = request.getModel().getInteger("id");
		toolkit=this.toolkitRepository.findOneToolkitById(masterId);
		inventor = toolkit.getInventor();
		principal = request.getPrincipal();
		
		result= (toolkit.isPublished() || inventor.getUserAccount().getId() == principal.getAccountId());
		
		return result;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request !=null;
		
		Toolkit result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.toolkitRepository.findOneToolkitById(id);
		
		
		return result;
	}

	
	
	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		int id;
		
		id = request.getModel().getInteger("id");
		Collection<String> currencies;
		final Money retailPrice= new Money();
		
		currencies=this.helperRepository.findAllCurenciesOfAToolkit(id);
		final Set<String> currency = currencies.stream().collect(Collectors.toSet());
		
		
		if(currency.size()==1) {
		
			final Double amount = this.helperRepository.amountOfToolkitRetailPrice(id);
			final String moneda = currency.stream().findFirst().get();
			
			retailPrice.setAmount(amount);
			retailPrice.setCurrency(moneda);
			model.setAttribute("retailPrice", retailPrice);
		}else {
			model.setAttribute("retailPrice", "");
		}
		
		
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "furtherInfo");
		
	}
	


}
