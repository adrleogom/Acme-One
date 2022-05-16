package acme.features.any.chirp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chirp.Chirp;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractCreateService;

@Service
public class AnyChirpCreateService implements AbstractCreateService<Any, Chirp>{
	
	@Autowired 
	protected AnyChirpRepository repository; 

	@Override 
	public boolean authorise(final Request<Chirp> request) { 
		assert request != null; 
		return true; 
	} 
	
	@Override
	public Chirp instantiate(final Request<Chirp> request) {
		assert request != null;

		final Chirp result;
		Date moment;

		result = new Chirp();
		moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);

		return result;
	}
	
	@Override
	public void bind(final Request<Chirp> request, final Chirp entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "title", "author", "body", "email");
		
		
	}
	
	@Override
	public void validate(final Request<Chirp> request, final Chirp entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation;
		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "any.chirp.form.label.confirmation");

	}
	
	@Override
	public void unbind(final Request<Chirp> request, final Chirp entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "author", "email");
		model.setAttribute("confirmation", false);
		
	}
	
	@Override
	public void create(final Request<Chirp> request, final Chirp entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}


}
