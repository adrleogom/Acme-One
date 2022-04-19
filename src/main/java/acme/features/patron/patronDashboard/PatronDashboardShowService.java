
package acme.features.patron.patronDashboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Status;
import acme.entities.stat.Stat;
import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard> {

	protected Stat						stat	= new Stat();

	@Autowired
	protected PatronDashboardRepository	patronDashboardRepository;


	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;
		final Map<Status, Integer> numberOfPatronages = new HashMap<Status, Integer>();
		final Map<Pair<Status, String>, Stat> budgetOfPatronages = new HashMap<Pair<Status, String>, Stat>();
		final PatronDashboard result = new PatronDashboard();

		int i = 0;

		while (i < this.patronDashboardRepository.averageBudgetByCurrency().size()) {
			final String linea = this.patronDashboardRepository.averageBudgetByCurrency().get(i);
			final String[] sub = linea.split(",");
			final Double key = Double.parseDouble(sub[1]);
			final String divisa = sub[0];
			final String estado = sub[2];
			final Status estado2;
			if (estado == "ACCEPTED") {
				estado2 = Status.ACCEPTED;
			} else if (estado == "DENIED") {
				estado2 = Status.DENIED;
			} else {
				estado2 = Status.PROPOSED;
			}
			final Pair<Status, String> res = Pair.of(estado2, divisa);
			this.stat.setAverage(key);
			budgetOfPatronages.put(res, this.stat);
			i++;
		}

		i = 0;

		while (i < this.patronDashboardRepository.deviationBudgetByCurrency().size()) {
			final String linea = this.patronDashboardRepository.deviationBudgetByCurrency().get(i);
			final String[] sub = linea.split(",");
			final Double key = Double.parseDouble(sub[1]);
			final String divisa = sub[0];
			final String estado = sub[2];
			final Status estado2;
			if (estado == "ACCEPTED") {
				estado2 = Status.ACCEPTED;
			} else if (estado == "DENIED") {
				estado2 = Status.DENIED;
			} else {
				estado2 = Status.PROPOSED;
			}
			final Pair<Status, String> res = Pair.of(estado2, divisa);
			this.stat.setDeviation(key);
			budgetOfPatronages.put(res, this.stat);
			i++;
		}

		i = 0;

		while (i < this.patronDashboardRepository.minBudgetByCurrency().size()) {
			final String linea = this.patronDashboardRepository.minBudgetByCurrency().get(i);
			final String[] sub = linea.split(",");
			final Double key = Double.parseDouble(sub[1]);
			final String divisa = sub[0];
			final String estado = sub[2];
			final Status estado2;
			if (estado == "ACCEPTED") {
				estado2 = Status.ACCEPTED;
			} else if (estado == "DENIED") {
				estado2 = Status.DENIED;
			} else {
				estado2 = Status.PROPOSED;
			}
			final Pair<Status, String> res = Pair.of(estado2, divisa);
			this.stat.setMinimum(key);
			budgetOfPatronages.put(res, this.stat);
			i++;
		}

		i = 0;

		while (i < this.patronDashboardRepository.maxBudgetByCurrency().size()) {
			final String linea = this.patronDashboardRepository.maxBudgetByCurrency().get(i);
			final String[] sub = linea.split(",");
			final Double key = Double.parseDouble(sub[1]);
			final String divisa = sub[0];
			final String estado = sub[2];
			final Status estado2;
			if (estado == "ACCEPTED") {
				estado2 = Status.ACCEPTED;
			} else if (estado == "DENIED") {
				estado2 = Status.DENIED;
			} else {
				estado2 = Status.PROPOSED;
			}
			final Pair<Status, String> res = Pair.of(estado2, divisa);
			this.stat.setMaximum(key);
			budgetOfPatronages.put(res, this.stat);
			i++;
		}

		numberOfPatronages.put(Status.ACCEPTED, this.patronDashboardRepository.totalNumberOfAcceptedPatronages());
		numberOfPatronages.put(Status.DENIED, this.patronDashboardRepository.totalNumberOfDeniedPatronages());
		numberOfPatronages.put(Status.PROPOSED, this.patronDashboardRepository.totalNumberOfProposedPatronages());
		result.setTotalNumberOfPatronages(numberOfPatronages);
		result.setBudgetOfPatronages(budgetOfPatronages);
		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberOfPatronages", "budgetOfPatronages");
	}
}
