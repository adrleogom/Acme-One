
package acme.features.any.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyItemListService implements AbstractListService<Any, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyItemRepository anyItemRepository;


	// AbstractListService<Any, Item> interface --------------
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Item> findMany(final Request<Item> request) {
		assert request != null;

		Collection<Item> result;
		int masterId;

		masterId = request.getModel().getInteger("masterId");
		result = this.anyItemRepository.findManyPublishedItemsByMasterId(masterId);

		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "itemType", "name", "code");

	}

}
