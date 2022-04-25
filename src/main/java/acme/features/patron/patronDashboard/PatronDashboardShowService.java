package acme.features.patron.patronDashboard;

import java.util.EnumMap;
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

	@Autowired
	protected PatronDashboardRepository patronDashboardRepository;


	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		assert request != null;
		final EnumMap<Status, Integer> totalNumberOfPatronages = new EnumMap<>(Status.class);
		final Map<Pair<Status, String>, Stat> budgetOfPatronages = new HashMap<Pair<Status, String>, Stat>();
		final PatronDashboard result = new PatronDashboard();

		int i = 0;

		while (i < this.patronDashboardRepository.averageBudgetByCurrency().size()) {
			final Stat stat = new Stat();
			final String linea = this.patronDashboardRepository.averageBudgetByCurrency().get(i);
			final String linea2 = this.patronDashboardRepository.deviationBudgetByCurrency().get(i);
			final String linea3 = this.patronDashboardRepository.minBudgetByCurrency().get(i);
			final String linea4 = this.patronDashboardRepository.maxBudgetByCurrency().get(i);
			final String[] sub = linea.split(",");
			final String[] sub2 = linea2.split(",");
			final String[] sub3 = linea3.split(",");
			final String[] sub4 = linea4.split(",");
			final String divisa = sub[0];
			final Double average = Double.parseDouble(sub[1]);
			final Double deviation = Double.parseDouble(sub2[1]);
			final Double min = Double.parseDouble(sub3[1]);
			final Double max = Double.parseDouble(sub4[1]);
			final String estado = sub[2];
			final Status estado2;
			if ("ACCEPTED".equals(estado)) {
				estado2 = Status.ACCEPTED;
			} else if ("DENIED".equals(estado)) {
				estado2 = Status.DENIED;
			} else {
				estado2 = Status.PROPOSED;
			}
			final Pair<Status, String> res = Pair.of(estado2, divisa);
			stat.setAverage(average);
			stat.setDeviation(deviation);
			stat.setMinimum(min);
			stat.setMaximum(max);
			budgetOfPatronages.put(res, stat);
			i++;
		}

		totalNumberOfPatronages.put(Status.ACCEPTED, this.patronDashboardRepository.totalNumberOfAcceptedPatronages());
		totalNumberOfPatronages.put(Status.DENIED, this.patronDashboardRepository.totalNumberOfDeniedPatronages());
		totalNumberOfPatronages.put(Status.PROPOSED, this.patronDashboardRepository.totalNumberOfProposedPatronages());
		result.setTotalNumberOfPatronages(totalNumberOfPatronages);
		result.setBudgetOfPatronages(budgetOfPatronages);
		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfPatronages", "budgetOfPatronages");
	}
}
