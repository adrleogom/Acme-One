package acme.features.patron.patronage;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
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
public class PatronPatronagePublishService implements AbstractUpdateService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;
	
	// AbstractUpdateService<Patron, Patronage> interface ---------------
	
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
		
		result = patronage != null && patronage.getPatron().getId() == patron.getId() && !patronage.isPublished();
		
		return result;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "legalStuff", "budget", "initialDate", "finalDate", "furtherInfo");
		
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		model.setAttribute("inventors", this.repository.findAllInventors());
		model.setAttribute("inventorId", entity.getInventor().getId());
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
		
		if (!errors.hasErrors("code")) {
			Patronage patronage;
			
			patronage = this.repository.findOnePatronageByCode(entity.getCode());
			if(patronage!=null) {
				errors.state(request, patronage.getId()==entity.getId() , "code", "patron.patronage.form.error.existent");
				}
		}
		
		if(!errors.hasErrors("initialDate")) {
			final Date minInitialDate= DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),1);
			errors.state(request,entity.getInitialDate().after(minInitialDate), "initialDate", "patron.patronage.form.error.distance.current.initial");
		}
		
		if(!errors.hasErrors("finalDate")) {
			final Date minFinalDate=DateUtils.addWeeks(entity.getInitialDate(), 1);
			errors.state(request,entity.getFinalDate().after(minFinalDate), "finalDate", "patron.patronage.form.error.distance.initial.final");
		}
		
		if (entity.getBudget()!=null && !errors.hasErrors("budget")) {
				final String[] currencies=this.repository.getSystemConfiguration().getAcceptedCurrencies().split(",");
	
	            Boolean acceptedCurrency=false;
	            for(int i=0;i<currencies.length;i++) {
		                if(entity.getBudget().getCurrency().equals(currencies[i].trim())) {
	                    acceptedCurrency=true;
	                }
	            }
				
				errors.state(request, entity.getBudget().getAmount() > 0, "budget", "patron.patronage.form.error.negative-budget");
				errors.state(request, acceptedCurrency, "budget", "patron.patronage.form.error.non-accepted-currency");
			}
	}

	@Override
	public void update(final Request<Patronage> request, final Patronage entity) {
		assert request != null;
		assert entity != null;
		
		entity.setPublished(true);
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
