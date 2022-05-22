
package acme.features.administrator.announcement;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SpamDetector;
import acme.entities.announcement.Announcement;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.features.administrator.systemConfiguration.AdministratorSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorAnnouncementCreateService implements AbstractCreateService<Administrator, Announcement> {

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected AdministratorSystemConfigurationRepository systemRepository;
	
	@Autowired
	protected AdministratorAnnouncementRepository repository;

	// AbstractCreateService<Administrator, Announcement> interface --------------


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "body", "furtherInfo", "flag");
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "body", "furtherInfo", "flag");
		model.setAttribute("confirmation", false);
		model.setAttribute("readonly", false);
	}

	@Override
	public Announcement instantiate(final Request<Announcement> request) {
		assert request != null;

		final Announcement result;
		Date moment;
		Administrator admin;
		final int masterId;
		
		masterId = request.getPrincipal().getAccountId();
		
		admin = this.repository.findOneAdministratorById(masterId);
		
		result = new Announcement();
		moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);
		result.setAdministrator(admin);
		return result;
	}

	@Override
	public void validate(final Request<Announcement> request, final Announcement entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		final SystemConfiguration sc;
		final Optional<SystemConfiguration> scAux = this.systemRepository.systemConfiguration().stream().findFirst();
		if (scAux.isPresent()) {
			sc = scAux.get();
			
			final double spamT = sc.getStrongSpamThreshold();
			final double spamW = sc.getWeakSpamThreshold();
			final String strongSpam = sc.getStrongSpamWords();
			final String weakSpam = sc.getWeakSpamWords();
			
			if (!errors.hasErrors("title")) {
				errors.state(request, SpamDetector.spamDetect(entity.getTitle(), weakSpam, strongSpam, spamT, spamW), "title", "form.error.spam");
			}
			if (!errors.hasErrors("body")) {
				errors.state(request, SpamDetector.spamDetect(entity.getBody(), weakSpam, strongSpam, spamT, spamW), "body", "form.error.spam");
			}
			if (!errors.hasErrors("furtherInfo") && !entity.getFurtherInfo().isEmpty()) {
				errors.state(request, SpamDetector.spamDetect(entity.getFurtherInfo(), weakSpam, strongSpam, spamT, spamW), "furtherInfo", "form.error.spam");
			}
		}
		boolean confirmation;

		confirmation = request.getModel().getBoolean("confirmation");
		errors.state(request, confirmation, "confirmation", "administrator.announcement.form.label.confirmation");
	}

	@Override
	public void create(final Request<Announcement> request, final Announcement entity) {
		assert request != null;
		assert entity != null;


		this.repository.save(entity);

	}
}
