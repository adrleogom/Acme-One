package acme.features.inventor.item;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.components.SpamDetector;
import acme.entities.item.Item;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.features.administrator.systemConfiguration.AdministratorSystemConfigurationRepository;
import acme.features.authenticated.systemConfiguration.AuthenticatedSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorItemUpdateService implements AbstractUpdateService<Inventor,Item> {

	@Autowired
	protected InventorItemRepository repository;
	
	@Autowired
	protected AdministratorSystemConfigurationRepository systemRepository;
	
	@Autowired
	protected AuthenticatedSystemConfigurationRepository helperRepository;
	
	@Override
	public boolean authorise(final Request<Item> request) {
		final boolean result;
		int itemId;
		final Item item;
		final Inventor inventor;
		
		itemId= request.getModel().getInteger("id");
		item = this.repository.findOneItemById(itemId);
		inventor= item.getInventor();
		result = !item.isPublished() && request.isPrincipal(inventor);
		
		return result;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		request.bind(entity, errors, "code", "name", "itemType", "technology", "description", "retailPrice", "furtherInfo");
		
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "name", "itemType", "technology", "description", "retailPrice", "furtherInfo");

	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		
		Item result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneItemById(id);
		
		return result;
	}

	
	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
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
			
			if (!errors.hasErrors("name")) {
				errors.state(request, SpamDetector.spamDetect(entity.getName(), weakSpam, strongSpam, spamT, spamW), "name", "form.error.spam");
			}
			if (!errors.hasErrors("description")) {
				errors.state(request, SpamDetector.spamDetect(entity.getDescription(), weakSpam, strongSpam, spamT, spamW), "description", "form.error.spam");
			}
			if (!errors.hasErrors("technology")) {
				errors.state(request, SpamDetector.spamDetect(entity.getTechnology(), weakSpam, strongSpam, spamT, spamW), "technology", "form.error.spam");
			}
			if (!errors.hasErrors("furtherInfo") && !entity.getFurtherInfo().isEmpty()) {
				errors.state(request, SpamDetector.spamDetect(entity.getFurtherInfo(), weakSpam, strongSpam, spamT, spamW), "furtherInfo", "form.error.spam");
			}
		}
		if(!errors.hasErrors("code")) {
			 
			Item existing;
			
			existing = this.repository.findItemByCode(entity.getCode());
			final String actualCode = entity.getCode();
			
			errors.state(request, existing == null || Objects.equals(existing.getCode(), actualCode), "code", "inventor.item.form.error.duplicated");
		}
		
		 if(!errors.hasErrors("retailPrice")) {
			 errors.state(request, entity.getRetailPrice().getAmount()>0, "retailPrice", "inventor.item.form.error.negative-retailPrice");
			  
			final String [] currencies = this.helperRepository.findAllSystemConfiguration().getAcceptedCurrencies().split(",");
			  
			List<String> acceptedCurrencies;
			
			acceptedCurrencies=Arrays.asList(currencies);
			
			 
		    errors.state(request, acceptedCurrencies.contains(entity.getRetailPrice().getCurrency()), "retailPrice", "inventor.item.form.error.invalid-currency");
			 
		 }
		
	}

	@Override
	public void update(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}

}
