package acme.features.administrator.systemConfiguration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;


@Service
public class AdministratorSystemConfigurationShowService implements AbstractShowService<Administrator, SystemConfiguration>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected AdministratorSystemConfigurationRepository repository;

		@Override
		public boolean authorise(final Request<SystemConfiguration> request) {
			assert request != null;

			return true;
		}

		@Override
		public SystemConfiguration findOne(final Request<SystemConfiguration> request) {
			assert request != null;
			SystemConfiguration result = null;
			
			final Optional<SystemConfiguration> value = this.repository.systemConfiguration().stream().findFirst();
			 
			if(value.isPresent()) {
				result = value.get();
			}else {
				result = null;
			}
			return result;
		}

		@Override
		public void unbind(final Request<SystemConfiguration> request, final SystemConfiguration entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "acceptedCurrencies", "systemCurrency", "strongSpamWords", 
				"strongSpamThreshold", "weakSpamWords", "weakSpamThreshold");

		}

}
