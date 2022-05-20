package acme.features.inventor.quantity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.quantity.Quantity;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorQuantityController extends AbstractController<Inventor, Quantity>{
	
	@Autowired
	InventorQuantityCreateService createService;
	
	@Autowired
	InventorQuantityListService listService;
	
	@Autowired
	InventorQuantityShowService showService;
	
	@Autowired
	InventorQuantityUpdateService updateService;
	
	@Autowired
	InventorQuantityDeleteService deleteService;
	
	@PostConstruct
	protected void initialise() {
		
		super.addCommand("list", this.listService);
		super.addCommand("create", this.createService);
		super.addCommand("show", this.showService);
		super.addCommand("update", this.updateService);
		super.addCommand("delete", this.deleteService);




	}
}
