
package acme.framework.features.patron.patronageReport;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronage.PatronageReport;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronageReportController extends AbstractController<Patron, PatronageReport> {

	//Internal State 

	@Autowired
	protected PatronageReportListService	listRecentService;
	@Autowired
	protected PatronageReportShowService	showService;


	//Constructors 
	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listRecentService);
	}

}
