/*
 * AuthenticatedAnnouncementRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.inventor.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorPatronageReportRepository extends AbstractRepository {


	@Query("select a from PatronageReport a where a.id =:idPatronageReport")
	PatronageReport findOnePatronageReportById(int idPatronageReport);

	@Query("select a from Inventor a where a.userAccount.id = :id")
	Inventor findInventorByUserId(int id);
	
	@Query("select a from PatronageReport a where a.patronage.id = :masterId")
	Collection<PatronageReport> findAllPatronageReportsByPatronageMasterId(int masterId);

	@Query("select a from Patronage a where a.id = :masterId")
	Patronage findOnePatronageById(int masterId);

}
