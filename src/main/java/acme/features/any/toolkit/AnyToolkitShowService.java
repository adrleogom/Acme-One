
package acme.features.any.toolkit;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkit.Toolkit;
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

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {

		assert request != null;
		assert entity != null;
		assert model != null;

		int id;
		id = request.getModel().getInteger("id");
		Collection<String> currencies;
		final Money retailPrice= new Money();
		
		currencies=this.repository.findCurenciesOfAToolkit(id);
		final Set<String> currency = currencies.stream().collect(Collectors.toSet());
		
		if(currency.size()==1) {
		
			final Double amount = this.repository.findToolkitRetailPrice(id);
			final String moneda = currency.stream().findFirst().get();
			
			retailPrice.setAmount(amount);
			retailPrice.setCurrency(moneda);
			model.setAttribute("retailPrice", retailPrice);
		}else {
			model.setAttribute("retailPrice", "");
		}
		
		model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
		request.unbind(entity, model, "code", "title", "description", "assemblyNotes", "furtherInfo");
	}

}
