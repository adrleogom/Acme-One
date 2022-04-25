package acme.features.any.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.item.Item;
import acme.framework.controllers.AbstractController;
import acme.framework.roles.Any;

@Controller
public class AnyItemController extends AbstractController<Any, Item>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	protected AnyItemListPublishedService				listPublishedService;
	
	@Autowired
	protected AnyItemListPublishedToolkitsService		listPublishedToolkitsService;

	@Autowired
	protected AnyItemShowService		showService;
	
	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("list-published", "list", this.listPublishedToolkitsService);
		super.addCommand("list", "list", this.listPublishedService);
		super.addCommand("show", this.showService);
	}
	
}
