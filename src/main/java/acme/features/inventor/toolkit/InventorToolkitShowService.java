package acme.features.inventor.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit>{

	@Autowired
	protected InventorToolkitRepository repository;

	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request !=null;
		
		
		return true;
	}

	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request !=null;
		
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
		
		Collection<Item> items;
		int id;
		double amount = 0;
		String currency = "";
		
		id = request.getModel().getInteger("id");
		items = this.repository.findManyItemsByToolkitId(id);
	
		
		final Money retailPrice;
		for(final Item i : items) {
		
			amount= amount + i.getRetailPrice().getAmount();
			
			currency = i.getRetailPrice().getCurrency();
			
		}
		
		
		request.unbind(entity, model, "code", "title", "descripction", "assemblyNotes", "furtherInfo");
		
	}
	


}
