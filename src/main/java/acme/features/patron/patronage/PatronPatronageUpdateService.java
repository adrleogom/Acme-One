package acme.features.patron.patronage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.HttpMethod;
import acme.framework.controllers.Request;
import acme.framework.controllers.Response;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Patron;

@Service
public class PatronPatronageUpdateService implements AbstractUpdateService<Patron,Patronage> {
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;
	
	// AbstractUpdateService<Inventor, Toolkit> interface ---------------
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request !=null;
		
		final boolean result;
		int masterId;
		Patronage patronage;
		int userAccountId;
		Principal principal;
		Patron patron;

		
		masterId = request.getModel().getInteger("id");
		patronage = this.repository.findOnePatronageById(masterId);
		
		principal = request.getPrincipal();
		userAccountId = principal.getAccountId();
		patron = this.repository.findOnePatronByUserAccountId(userAccountId);
		
		result = patronage.getPatron().getId() == patron.getId();
		
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "legalStuff", "budget", "initialDate", "finalDate", "furtherInfo", "inventorId");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "legalStuff", "budget", "initialDate", "finalDate", "furtherInfo", "published");
		
	}

	@Override
	public Patronage findOne(final Request<Patronage> request) {
		assert request != null;
		
		Patronage result;
		int masterId;

		masterId = request.getModel().getInteger("id");
		result = this.repository.findOnePatronageById(masterId);
		
		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}
	
	@Override
	public void onSuccess(final Request<Patronage> request, final Response<Patronage> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
