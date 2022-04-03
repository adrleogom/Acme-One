package acme.features.administrator.dashboard;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronage.Status;
import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard>{
	
	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected AdministratorDashboardRepository repository;

	@Override
	public boolean authorise(final Request<AdministratorDashboard> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
		assert request != null;

		AdministratorDashboard result;
		int totalNumberOfComponents;
		int totalNumberOfTools;
		Map<Status,Integer> totalNumberOfPatronages;
		//final Map<Pair<String,String>,Stat> retailPriceOfComponents;
		//final Map<String,Stat> retailPriceOfTools;
		//final Map<Status,Stat> budgetOfPatronages;
		
		totalNumberOfComponents = this.repository.totalNumberOfComponents();
		totalNumberOfTools = this.repository.totalNumberOfTools();
		totalNumberOfPatronages = this.repository.totalNumberOfPatronages();

		
		result = new AdministratorDashboard();
		result.setTotalNumberOfComponents(totalNumberOfComponents);
		result.setTotalNumberOfTools(totalNumberOfTools);
		result.setTotalNumberOfPatronages(totalNumberOfPatronages);
		
		return result;
	}
	
	@Override
	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfComponents", "totalNumberOfTools", "totalNumberOfPatronages"
			//,"retailPriceOfComponents", "retailPriceOfTools", "budgetOfPatronages"
			);


	}


}
