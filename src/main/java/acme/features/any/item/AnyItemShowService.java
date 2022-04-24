package acme.features.any.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyItemShowService implements AbstractShowService<Any, Item>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyItemRepository anyItemRepository;
		
		
	// AbstractShowService<Any, Item> interface --------------

	@Override
	public boolean authorise(final Request<Item> request) {
		boolean result;
		int id;
		final Item item;

		id = request.getModel().getInteger("id");
		item = this.anyItemRepository.findItemById(id);
		result = item.isPublished();

		return result;
	}


	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;

		Item result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.anyItemRepository.findItemById(id);

		return result;
		
	}


	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("inventor", entity.getInventor().getUserAccount().getUsername());
		request.unbind(entity, model, "itemType", "name", "code", "technology", "description", "retailPrice", "furtherInfo");
		
	}
}
