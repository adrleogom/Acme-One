package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.entities.quantity.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.HttpMethod;
import acme.framework.controllers.Request;
import acme.framework.controllers.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorQuantityCreateService implements AbstractCreateService<Inventor, Quantity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;
	
	// AbstractUpdateService<Inventor, Quantity> interface ---------------

	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request !=null;
		
		final boolean result;
		int masterId;
		Toolkit toolkit;
		int userAccountId;
		Principal principal;
		Inventor inventor;
		Collection<Item> items;

		
		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneToolkitById(masterId);
		
		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		
		inventor = this.repository.findOneInventorByUserAccountId(userAccountId);
		items = this.repository.findManyPublishedItemsByAccountId(userAccountId);

		items.removeAll(this.repository.findManyItemsByToolkitId(masterId));
		result = toolkit.getInventor().getId() == inventor.getId() && !items.isEmpty() && !toolkit.isPublished();
			
		return result;
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		entity.setItem(this.repository.findOneItemById(Integer.valueOf(request.getModel().getAttribute("item").toString())));
		request.bind(entity, errors, "number");
		
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Principal principal;
		int masterId;
		Collection<Item> items;
		
		masterId = request.getModel().getInteger("masterId");
		model.setAttribute("masterId", masterId);
		principal = request.getPrincipal();
		items = this.repository.findManyPublishedItemsByAccountId(principal.getAccountId());
		items.removeAll(this.repository.findManyItemsByToolkitId(masterId));
		model.setAttribute("items", items);
		
		request.unbind(entity, model, "number");
		
	}

	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request !=null;
		
		final Quantity result;
		int masterId;
		Toolkit toolkit;
		
		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneToolkitById(masterId);		
		
		result = new Quantity();
		result.setToolkit(toolkit);
		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Integer itemId = Integer.valueOf(request.getModel().getAttribute("item").toString()) ;
		if (this.repository.findOneItemById(itemId).getItemType().toString().equals("TOOL") && !errors.hasErrors("number")) {
			errors.state(request, entity.getNumber()==1 , "number", "inventor.quantity.form.error.more-than-one");
		}	
	}

	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
		
	}
	
	@Override
	public void onSuccess(final Request<Quantity> request, final Response<Quantity> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}


}
