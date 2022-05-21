package acme.features.any.chirp;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SpamDetector;
import acme.entities.chirp.Chirp;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.features.administrator.systemConfiguration.AdministratorSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractCreateService;

@Service
public class AnyChirpCreateService implements AbstractCreateService<Any, Chirp>{
	
	@Autowired
	protected AdministratorSystemConfigurationRepository systemRepository;
	
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
		final SystemConfiguration sc;
		final Optional<SystemConfiguration> scAux = this.systemRepository.systemConfiguration().stream().findFirst();
		if (scAux.isPresent()) {
			sc = scAux.get();
			
			final double spamT = sc.getStrongSpamThreshold();
			final double spamW = sc.getWeakSpamThreshold();
			final String strongSpam = sc.getStrongSpamWords();
			final String weakSpam = sc.getWeakSpamWords();
			
			if (!errors.hasErrors("title")) {
				errors.state(request, SpamDetector.spamDetect(entity.getTitle(), weakSpam, strongSpam, spamT, spamW), "title", "form.error.spam");
			}
			if (!errors.hasErrors("body")) {
				errors.state(request, SpamDetector.spamDetect(entity.getBody(), weakSpam, strongSpam, spamT, spamW), "body", "form.error.spam");
			}
		}
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
		model.setAttribute("readonly", false);
		model.setAttribute("confirmation", false);
		
	}
	
	@Override
	public void create(final Request<Chirp> request, final Chirp entity) {
		assert request != null;
		assert entity != null;
		
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		
		this.repository.save(entity);
	}


}
