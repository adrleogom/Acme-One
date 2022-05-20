package acme.features.inventor.toolkit;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class InventorToolkitCreateService implements AbstractCreateService<Inventor, Toolkit> {
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected InventorToolkitRepository repository;
	
	private final Random random = new Random();
	
	// AbstractCreateService<Authenticated, Toolkit> interface ---------------
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request !=null;
		
		return true;
	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "description", "assemblyNotes", "furtherInfo");
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "assemblyNotes", "furtherInfo");
		
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		assert request != null;
		
		Toolkit result;
		Principal principal;
		int userAccountId;
		Inventor inventor;
		String code;
		final String setOfChars = "ABCDEFGHIJLMNOPQRSTUVWXYZ";
		final StringBuilder  string1 = new StringBuilder();
		char char2;
		int int1;
		
		//GENERAR CÓDIGO

		
		for(int i=0 ; i<=2; i++) {
			final int randomInt = this.random.nextInt(setOfChars.length());
			string1.append(setOfChars.charAt(randomInt));
		}
		char2 = setOfChars.charAt(this.random.nextInt(setOfChars.length()));
		
		int1 = this.random.nextInt(899)	+ 100;
		
		code = string1 + "-" + int1 + "-" + char2;
		
		while(this.repository.findOneToolkitByCode(code)!=null) {
			for(int i=0 ; i<=2; i++) {
				final int randomInt = this.random.nextInt(setOfChars.length());
				string1.append(setOfChars.charAt(randomInt));
			}
			char2 = setOfChars.charAt(this.random.nextInt(setOfChars.length()));
			
			int1 = this.random.nextInt(899)	+ 100;
			
			code = string1 + "-" + int1 + "-" + char2;
		}
		//FINALIZA GENERAR CÓDIGO
		
		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		inventor = this.repository.findOneInventorByUserAccountId(userAccountId);
		
		result = new Toolkit();
		result.setInventor(inventor);
		result.setPublished(false);
		result.setCode(code);
		return result;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
	}
	
	@Override
	public void onSuccess(final Request<Toolkit> request, final Response<Toolkit> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
