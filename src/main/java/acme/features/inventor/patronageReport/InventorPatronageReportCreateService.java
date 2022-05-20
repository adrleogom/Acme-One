package acme.features.inventor.patronageReport;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportCreateService implements AbstractCreateService<Inventor, PatronageReport> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorPatronageReportRepository repository;

	// AbstractCreateService<Inventor, PatronageReport> interface --------------
	
	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "memorandum", "furtherInfo");
		
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "memorandum", "furtherInfo");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", false);
		model.setAttribute("masterId", entity.getPatronage().getId());
		
	}

	@Override
	public PatronageReport instantiate(final Request<PatronageReport> request) {
		assert request != null;

		final PatronageReport result;
		Date creationMoment;
		final Patronage patronage;
		final int masterId;
		
		masterId = request.getModel().getInteger("masterId");
		
		patronage =this.repository.findOnePatronageById(masterId);

		creationMoment = new Date(System.currentTimeMillis() - 1);
		
		Integer sum = 1;

		final List<PatronageReport> patronages = this.repository.findAllPatronageReports();
		
		Integer i = 0;
		
		while(i<patronages.size()) {
			
			if(patronages.get(i).getSNumber() - (patronages.size()+sum) == 0) {
				sum +=1;
				i = 0;
			}
			i++;
		}

		final Integer sNumber = patronages.size() + sum;
		
		result = new PatronageReport();
		result.setCreationMoment(creationMoment);
		result.setSNumber(sNumber);
		result.setPatronage(patronage);
		

		return result;
	}

	@Override
	public void validate(final Request<PatronageReport> request, final PatronageReport entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		boolean confirmation;
		
		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "inventor.patronage-report.form.label.confirmation");
		
	}

	@Override
	public void create(final Request<PatronageReport> request, final PatronageReport entity) {
		
		assert request != null;
		assert entity != null;

//		Date moment;
//
//		moment = new Date(System.currentTimeMillis() - 1);
//		entity.setCreationMoment(moment);
		this.repository.save(entity);
		
	}

}
