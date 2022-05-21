package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.entities.quantity.Quantity;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorQuantityShowService implements AbstractShowService<Inventor, Quantity> {

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
	public Quantity findOne(final Request<Quantity> request) {
		assert request !=null;
		
		Quantity result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneQuantityById(id);
		
		
		return result;
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Principal principal;
		Collection<Item> items;
		final Collection<Item> items2;

		
		principal = request.getPrincipal();
		items = this.repository.findManyPublishedItemsByAccountId(principal.getAccountId());
		items2 = this.repository.findManyItemsByToolkitId(entity.getToolkit().getId());
		items2.remove(entity.getItem());
		items.removeAll(items2);
		model.setAttribute("items", items);
		
		request.unbind(entity, model, "number", "item");
		
	}

}
