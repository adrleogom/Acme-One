
package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.item.Item;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractListService;

@Service
public class AnyToolkitPublishedListService implements AbstractListService<Any, Toolkit> {

	//Internal State ---------------------------------------------------------------------------

	@Autowired
	protected AnyToolkitRepository repository;


	// AbstractListService<Any, Toolkit> interface --------------
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Toolkit> findMany(final Request<Toolkit> request) {
		assert request != null;

		Collection<Toolkit> result;

		result = this.repository.findPublishedToolkit(true);

		return result;
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		final String payload;
		
		request.unbind(entity, model, "code", "title");
		final Collection<Item> items = this.repository.findManyItemsByToolkitId(entity.getId());
		
		payload = String.format("%s", items);
		model.setAttribute("payload", payload);
	}
}
