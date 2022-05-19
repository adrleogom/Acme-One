package acme.features.inventor.item;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.helper.toolkit.ItemAndToolkitCodeGenerator;
import acme.roles.Inventor;

@Service
public class InventorItemCreateService implements AbstractCreateService<Inventor, Item> {

	@Autowired
	protected InventorItemRepository repository;
	
	@Autowired
	protected ItemAndToolkitCodeGenerator codeGenerator;
	
	final Random random = new Random();
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		return true;		
	}
	
	@Override
	public Item instantiate(final Request<Item> request) {
		assert request != null;
 
		final Item result;
		final Inventor inventor;
		
		inventor= this.repository.findInventorById(request.getPrincipal().getAccountId());
		result = new Item();
		
		String code;
		final String setOfChars = "ABCDEFGHIJLMNOPQRSTUVWXYZ";
        final StringBuilder  string1 = new StringBuilder();;
        char char2;
        int int1;
      
     
        for(int i=0 ; i<=2; i++) {
            final int randomInt = this.random.nextInt(setOfChars.length());
            string1.append(setOfChars.charAt(randomInt));
        }
        char2 = setOfChars.charAt(this.random.nextInt(setOfChars.length()));
        
        int1 = this.random.nextInt(899)    + 100;
        
        code = string1 + "-" + int1 + "-" + char2;
        

	
        result.setCode(code);
        result.setPublished(false);
		result.setInventor(inventor);
		
		return result;
	
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {

		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "name", "itemType", "technology", "description", "retailPrice", "furtherInfo");
	}
	
	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		
		
		 if(!errors.hasErrors("retailPrice")) {
			 errors.state(request, entity.getRetailPrice().getAmount()>0, "retailPrice", "inventor.item.form.error.negative-retailPrice");
			 
		 }
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "name", "itemType", "technology", "description", "retailPrice", "furtherInfo");
	}


	@Override
	public void create(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}

}
