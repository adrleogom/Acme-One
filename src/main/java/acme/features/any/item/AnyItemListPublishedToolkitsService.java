
package acme.features.any.item;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyItemListPublishedToolkitsService implements AbstractListService<Any, Item> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyItemRepository anyItemRepository;


	// AbstractListService<Any, Item> interface --------------
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		boolean result;
		int masterId;
		Toolkit toolkit;

		masterId = request.getModel().getInteger("masterId");
		toolkit = this.anyItemRepository.findOneToolkitById(masterId);
		result = toolkit.isPublished();
		return result;
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
	public void unbind (final Request<Item> request, final Collection<Item> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;
		
		int masterId;
		
		
		masterId = request.getModel().getInteger("masterId");
		
		
		model.setAttribute("masterId", masterId);
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "itemType", "name", "code");

	}

}
