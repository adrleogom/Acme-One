package acme.features.inventor.item;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.item.Item;
import acme.framework.controllers.AbstractController;
import acme.roles.Inventor;

@Controller
public class InventorItemController extends AbstractController<Inventor, Item>{

	//Internal State ------------------------------------------------------------------------
	
	@Autowired
	protected InventorItemListService listService;
	
	@Autowired
	protected InventorItemListMineService listMineService;
	
	@Autowired
	protected InventorItemShowService showService;
	
	@Autowired
	protected InventorItemCreateService createService;
	
	@Autowired
	protected InventorItemPublishService publishService;
	
	@Autowired
	protected InventorItemDeleteService deleteService;
	
	@Autowired
	protected InventorItemUpdateService updateService;
	
	
	
	
	
	//Constructors---------------------------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		
		super.addCommand("list-mine","list", this.listMineService);
		super.addCommand("list", this.listService);
		super.addCommand("show", this.showService);
		
		super.addCommand("create", this.createService);
		super.addCommand("publish", "update", this.publishService);
		super.addCommand("delete", this.deleteService);
		super.addCommand("update", this.updateService);

	}
	
}
