/*
 * AuthenticatedAnnouncementController.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.patron.patronage;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import acme.entities.patronage.Patronage;
import acme.framework.controllers.AbstractController;
import acme.roles.Patron;

@Controller
public class PatronPatronageController extends AbstractController<Patron, Patronage> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected PatronPatronageListService		listAllService;

	@Autowired
	protected PatronPatronageShowService			showService;
	
//	@Autowired
//	protected InventorPatronageShowPatronService			showPatronService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
		super.addCommand("show", this.showService);
		super.addCommand("list", this.listAllService);
//		super.addCommand("patron", this.showPatronService);
	}

}
