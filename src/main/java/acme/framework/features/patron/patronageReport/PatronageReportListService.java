package acme.framework.features.patron.patronageReport;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractListService;
import acme.roles.Patron;

@Service
public class PatronageReportListService implements AbstractListService<Patron, PatronageReport> {

	@Autowired 
	protected PatronageReportRepository repository; 
 
	@Override 
	public boolean authorise(final Request<PatronageReport> request) { 
		assert request != null; 
		return true; 
	} 
 
	@Override 
	public Collection<PatronageReport> findMany(final Request<PatronageReport> request) { 
		assert request != null; 
		 
		final Collection<PatronageReport> result; 
		final int UAId = request.getPrincipal().getAccountId();
		final int PatronId = this.repository.findPatronByUserAccountId(UAId).getId();
		result=this.repository.findPatronageReportsByPatronId(PatronId); 
		
		return result;
	} 
 
	@Override 
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) { 
		assert request != null; 
		assert entity != null; 
		assert model != null; 
		request.unbind(entity, model, "creationMoment","sequenceNumber", "link");		 
	} 
}
