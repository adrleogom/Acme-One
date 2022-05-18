package acme.features.inventor.toolkit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.toolkit.Toolkit;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorToolkitController extends AbstractController<Inventor, Toolkit>{

	@Autowired
	InventorToolkitListMineService listMineService;
	
	@Autowired
	InventorToolkitShowService showService;
	
	@Autowired
	InventorToolkitCreateService createService;
	
	@Autowired
	InventorToolkitUpdateService updateService;
	
	@Autowired
	InventorToolkitDeleteService deleteService;
	
	@Autowired
	InventorToolkitPublishService publishService;
	
	
	@PostConstruct
	protected void initialise() {
		
		super.addCommand("create", this.createService);
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listMineService);
		super.addCommand("publish","update", this.publishService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);

	}
}
