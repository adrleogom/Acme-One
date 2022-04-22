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
	protected InventorItemListMineService listMineService;
	
	@Autowired
	protected InventorItemShowService showService;
	
	
	
	
	//Constructors---------------------------------------------------------------------------
	
	@PostConstruct
	protected void initialise() {
		
		super.addCommand("list", this.listMineService);
		super.addCommand("show", this.showService);
	}
	
}
