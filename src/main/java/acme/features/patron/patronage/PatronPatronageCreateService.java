package acme.features.patron.patronage;

import java.util.Date;
import java.util.Random;

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
	
	private final Random random = new Random();

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
		request.bind(entity, errors, "legalStuff", "budget", "initialDate", "finalDate", "furtherInfo", "inventorId");
		
	}

	@Override
	public void unbind(final Request<Patronage> request, final Patronage entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "legalStuff", "budget", "initialDate", "finalDate", "furtherInfo", "published");
		model.setAttribute("inventors", this.repository.findAllInventors());
		model.setAttribute("readonly", false);
		
	}

	@Override
	public Patronage instantiate(final Request<Patronage> request) {
		assert request != null;

		final Patronage result;
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
		
		while(this.repository.findOnePatronageByCode(code)!=null) {
			for(int i=0 ; i<=2; i++) {
				final int randomInt = this.random.nextInt(setOfChars.length());
				string1.append(setOfChars.charAt(randomInt));
			}
			char2 = setOfChars.charAt(this.random.nextInt(setOfChars.length()));

			int1 = this.random.nextInt(899)	+ 100;

			code = string1 + "-" + int1 + "-" + char2;
		}
		
		result = new Patronage();
		result.setInitialDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),2));
		result.setFinalDate(DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),4));
		result.setCode(code);
		result.setStatus(Status.PROPOSED);
		result.setPatron(this.repository.findPatronByUserId(request.getPrincipal().getAccountId()));
		
		return result;
	}

	@Override
	public void validate(final Request<Patronage> request, final Patronage entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(!errors.hasErrors("initialDate")) {
			final Date minInitialDate= DateUtils.addMonths( new Date(System.currentTimeMillis() - 1),1);
			errors.state(request,entity.getInitialDate().after(minInitialDate), "initialDate", "patron.patronage.form.error.distance.current.initial");
		}
		
		if(!errors.hasErrors("finalDate")) {
			final Date minFinalDate=DateUtils.addMonths(entity.getInitialDate(), 1);
			errors.state(request,entity.getFinalDate().after(minFinalDate), "finalDate", "patron.patronage.form.error.distance.initial.final");
		}
		
		
	}

	@Override
	public void create(final Request<Patronage> request, final Patronage entity) {
		
		assert request != null;
		assert entity != null;
		this.repository.save(entity);
		
	}

}