
package acme.features.patron.patronageReport;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Patronage;
import acme.entities.patronage.PatronageReport;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Patron;

@Repository
public interface PatronPatronageReportRepository extends AbstractRepository {


	@Query("select a from PatronageReport a where a.id =:idPatronageReport")
	PatronageReport findOnePatronageReportById(int idPatronageReport);

	@Query("select a from Patron a where a.userAccount.id = :id")
	Patron findPatronByUserId(int id);
	
	@Query("select a from PatronageReport a where a.patronage.id = :masterId")
	Collection<PatronageReport> findAllPatronageReportsByPatronageMasterId(int masterId);

	@Query("select a from Patronage a where a.id = :masterId")
	Patronage findOnePatronageById(int masterId);
}
