package acme.features.inventor.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorItemShowService implements AbstractShowService<Inventor, Item>{
	

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorItemRepository repository;
	
	
	@Override
	public boolean authorise (final Request<Item> request) {
		
		assert request != null;
	
		 boolean result;
		 int masterId;
		 Item item;
		 Inventor inventor;
		 Principal principal;
		 
		 masterId = request.getModel().getInteger("id");
		 item = this.repository.findOneItemById(masterId);
		 inventor= item.getInventor();
		 principal = request.getPrincipal();
		 
		 result= (item.isPublished() || inventor.getUserAccount().getId() == principal.getAccountId());
		 
		

		return result;
		
	}
	
	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		
		Item result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneItemById(id);
		
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "itemType", "name", "code", "technology", "published","description", "retailPrice", "furtherInfo");
		model.setAttribute("readonly", true);
	}
}
