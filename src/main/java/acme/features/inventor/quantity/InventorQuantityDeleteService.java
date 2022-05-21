package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.entities.quantity.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorQuantityDeleteService implements AbstractDeleteService<Inventor, Quantity>  {

	@Autowired
	InventorQuantityRepository repository;
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request !=null;
		
		final boolean result;
		int masterId;
		int userAccountId;
		Principal principal;
		Inventor inventor;
		final Quantity quantity;

		
		masterId = request.getModel().getInteger("id");
		quantity = this.repository.findOneQuantityById(masterId);
		
		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		inventor = this.repository.findOneInventorByUserAccountId(userAccountId);
		
		result = quantity.getToolkit().getInventor().getId() == inventor.getId() && !quantity.getToolkit().isPublished();
		
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
		Collection<Item> items;
		Collection<Item> items2;

		principal = request.getPrincipal();
		items = this.repository.findManyPublishedItemsByAccountId(principal.getAccountId());
		items2 = this.repository.findManyItemsByToolkitId(entity.getToolkit().getId());
		items2.remove(this.repository.findOneQuantityById(entity.getId()).getItem());
		items.removeAll(items2);
		model.setAttribute("items", items);
		
		request.unbind(entity, model, "number");
		
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request !=null;
		
		Quantity result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneQuantityById(id);
		
		
		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		final Integer itemId = Integer.valueOf(request.getModel().getAttribute("item").toString()) ;
		if (this.repository.findOneItemById(itemId).getItemType().toString().equals("TOOL") && errors.hasErrors("number")) {
			errors.state(request, entity.getNumber()==1 , "number", "inventor.quantity.form.error.more-than-one");
		}	
	}

	@Override
	public void delete(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.delete(entity);
		
	}

}
