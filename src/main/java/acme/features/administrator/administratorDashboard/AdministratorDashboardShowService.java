
package acme.features.administrator.administratorDashboard;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Status;
import acme.entities.stat.Stat;
import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorDashboardRepository administratorDashboardRepository;


	@Override
	public boolean authorise(final Request<AdministratorDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
		assert request != null;

		int totalNumberOfComponents;
		int totalNumberOfTools;
		final Map<Status, Integer> totalNumberOfPatronages = new HashMap<Status, Integer>();
		final Map<Pair<String, String>, Stat> retailPriceOfComponents = new HashMap<Pair<String, String>, Stat>();
		final Map<Money, Stat> retailPriceOfTools = new HashMap<Money, Stat>();
		final Map<Pair<Status, String>, Stat> budgetOfPatronages = new HashMap<Pair<Status, String>, Stat>();

		final AdministratorDashboard result = new AdministratorDashboard();

		totalNumberOfComponents = this.administratorDashboardRepository.totalNumberOfComponents();
		totalNumberOfTools = this.administratorDashboardRepository.totalNumberOfTools();

		int i = 0;

		while (i < this.administratorDashboardRepository.averageMoneyComponent().size()) {
			final Stat stat = new Stat();
			final String linea = this.administratorDashboardRepository.averageMoneyComponent().get(i);
			final String linea2 = this.administratorDashboardRepository.deviationMoneyComponent().get(i);
			final String linea3 = this.administratorDashboardRepository.minMoneyComponent().get(i);
			final String linea4 = this.administratorDashboardRepository.maxMoneyComponent().get(i);
			final String[] sub = linea.split(",");
			final String[] sub2 = linea2.split(",");
			final String[] sub3 = linea3.split(",");
			final String[] sub4 = linea4.split(",");
			final String divisa = sub[1];
			final String tecnologia = sub[3];
			final Double average = Double.parseDouble(sub[2]);
			final Double deviation = Double.parseDouble(sub2[2]);
			final Double min = Double.parseDouble(sub3[2]);
			final Double max = Double.parseDouble(sub4[2]);
			stat.setAverage(average);
			stat.setDeviation(deviation);
			stat.setMaximum(max);
			stat.setMinimum(min);
			final Pair<String, String> par = Pair.of(divisa, tecnologia);
			retailPriceOfComponents.put(par, stat);
			i++;
		}

		i = 0;

		while (i < this.administratorDashboardRepository.averageMoney().size()) {
			final Stat stat = new Stat();
			final Money dinero = new Money();
			final String linea = this.administratorDashboardRepository.averageMoney().get(i);
			final String linea2 = this.administratorDashboardRepository.deviationMoney().get(i);
			final String linea3 = this.administratorDashboardRepository.minMoney().get(i);
			final String linea4 = this.administratorDashboardRepository.maxMoney().get(i);
			final String[] sub = linea.split(",");
			final String[] sub2 = linea2.split(",");
			final String[] sub3 = linea3.split(",");
			final String[] sub4 = linea4.split(",");
			final String divisa = sub[1];
			final Double cantidad = Double.parseDouble(sub[0]);
			final Double average = Double.parseDouble(sub[2]);
			final Double deviation = Double.parseDouble(sub2[2]);
			final Double min = Double.parseDouble(sub3[2]);
			final Double max = Double.parseDouble(sub4[2]);
			stat.setAverage(average);
			stat.setDeviation(deviation);
			stat.setMaximum(max);
			stat.setMinimum(min);
			dinero.setAmount(cantidad);
			dinero.setCurrency(divisa);
			retailPriceOfTools.put(dinero, stat);
			i++;
		}

		i = 0;

		while (i < this.administratorDashboardRepository.averageBudgetByCurrency().size()) {
			final Stat stat = new Stat();
			final String linea = this.administratorDashboardRepository.averageBudgetByCurrency().get(i);
			final String linea2 = this.administratorDashboardRepository.deviationBudgetByCurrency().get(i);
			final String linea3 = this.administratorDashboardRepository.minBudgetByCurrency().get(i);
			final String linea4 = this.administratorDashboardRepository.maxBudgetByCurrency().get(i);
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

		result.setTotalNumberOfComponents(totalNumberOfComponents);
		result.setTotalNumberOfTools(totalNumberOfTools);
		totalNumberOfPatronages.put(Status.ACCEPTED, this.administratorDashboardRepository.totalNumberOfAcceptedPatronages());
		totalNumberOfPatronages.put(Status.DENIED, this.administratorDashboardRepository.totalNumberOfDeniedPatronages());
		totalNumberOfPatronages.put(Status.PROPOSED, this.administratorDashboardRepository.totalNumberOfProposedPatronages());
		result.setTotalNumberOfPatronages(totalNumberOfPatronages);
		result.setBudgetOfPatronages(budgetOfPatronages);
		result.setRetailPriceOfTools(retailPriceOfTools);
		result.setRetailPriceOfComponents(retailPriceOfComponents);
		return result;
	}

	@Override
	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfComponents", "totalNumberOfTools", "totalNumberOfPatronages", "budgetOfPatronages", "retailPriceOfTools", "retailPriceOfComponents");

	}

}
