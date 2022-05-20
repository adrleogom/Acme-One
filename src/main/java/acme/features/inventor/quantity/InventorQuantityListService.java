package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.quantity.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.Principal;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorQuantityListService implements AbstractListService<Inventor, Quantity> {
	
	@Autowired
	InventorQuantityRepository repository;

	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request !=null;
		
		final boolean result;
		int masterId;
		Toolkit toolkit;
		int userAccountId;
		Principal principal;
		Inventor inventor;

		
		masterId = request.getModel().getInteger("masterId");
		toolkit = this.repository.findOneToolkitById(masterId);
		
		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		inventor = this.repository.findOneInventorByUserAccountId(userAccountId);
		
		result = toolkit.getInventor().getId() == inventor.getId() && !toolkit.isPublished();
		
		return result;
	}

	@Override
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		assert request !=null;
		
		final Collection<Quantity> result;
				
		result = this.repository.findManyQuantitiesByToolkitId(request.getModel().getInteger("masterId"));
		
		return result;
	}
	
	@Override
	public void unbind (final Request<Quantity> request, final Collection<Quantity> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;
		
		int masterId;
		
		
		masterId = request.getModel().getInteger("masterId");
		
		
		model.setAttribute("masterId", masterId);
		
		
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "item.name", "item.itemType", "number");

	}


}
