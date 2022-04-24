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
			//final Map<Pair<String,String>,Stat> retailPriceOfComponents;
			//final Map<Money,Stat> retailPriceOfTools;
			final Map<Pair<Status, String>, Stat> budgetOfPatronages = new HashMap<Pair<Status, String>, Stat>();
			
			final AdministratorDashboard result = new AdministratorDashboard();
			
						
			totalNumberOfComponents = this.administratorDashboardRepository.totalNumberOfComponents();
			totalNumberOfTools = this.administratorDashboardRepository.totalNumberOfTools();

			
			int i = 0;

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
						
			return result;
		}
		
		@Override
		public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "totalNumberOfComponents", "totalNumberOfTools", "totalNumberOfPatronages"
				//,"retailPriceOfComponents", "retailPriceOfTools"
				, "budgetOfPatronages");


		}

	

}
