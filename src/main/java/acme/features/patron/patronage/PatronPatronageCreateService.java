package acme.features.patron.patronage;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.Status;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Patron;

@Service
public class PatronPatronageCreateService implements AbstractCreateService<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageRepository repository;

	// AbstractCreateService<Inventor, PatronageReport> interface --------------
	
	@Override
	public boolean authorise(final Request<Patronage> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		entity.setInventor(this.repository.findOneInventorById(Integer.valueOf(request.getModel().getAttribute("inventorId").toString())));
		entity.setPublished(false);
		request.bind(entity, errors, "legalStuff", "budget", "initialDate", "finalDate", "furtherInfo", "inventorId", "code");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "legalStuff", "budget", "initialDate", "finalDate", "furtherInfo", "published", "code");
		model.setAttribute("inventors", this.repository.findAllInventors());
		model.setAttribute("readonly", false);
		
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;

		final Patronage result;
		result = new Patronage();
		result.setInitialDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),2));
		result.setFinalDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),4));
		result.setStatus(Status.PROPOSED);
		result.setPatron(this.repository.findPatronByUserId(request.getPrincipal().getAccountId()));
		
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
			
			errors.state(request, patronage == null, "code", "patron.patronage.form.error.existent");
		}
		
		if(!errors.hasErrors("initialDate")) {
			final Date minInitialDate= DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),1);
			errors.state(request,entity.getInitialDate().after(minInitialDate)
				|| entity.getInitialDate().equals(minInitialDate), "initialDate", "patron.patronage.form.error.distance.current.initial");
		}
		
		if(!errors.hasErrors("finalDate") && !errors.hasErrors("initialDate")) {
			final Date minFinalDate=DateUtils.addMonths(entity.getInitialDate(), 1);
			errors.state(request,entity.getFinalDate().after(minFinalDate)
				|| entity.getFinalDate().equals(minFinalDate), "finalDate", "patron.patronage.form.error.distance.initial.final");
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
	public void create(final Request<Patronage> request, final Patronage entity) {
		
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
		
	}

}