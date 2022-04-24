
package acme.features.patron.patronageReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.PatronageReport;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronPatronageReportShowService implements AbstractShowService<Patron, PatronageReport> {

	@Autowired
	protected PatronPatronageReportRepository repository;


	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		final boolean res;
		Patron patron;
		int idPatronageReport;
		idPatronageReport = request.getModel().getInteger("id");
		final PatronageReport patronageReport = this.repository.findOnePatronageReportById(idPatronageReport);
		patron = this.repository.findPatronByUserId(request.getPrincipal().getAccountId());
		res = patronageReport.getPatronage().getPatron().equals(patron);
		return res;
	}

	@Override
	public PatronageReport findOne(final Request<PatronageReport> request) {
		assert request != null;

		PatronageReport result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOnePatronageReportById(id);

		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationMoment", "memorandum", "furtherInfo");
		model.setAttribute("readonly", true);
	}
}
