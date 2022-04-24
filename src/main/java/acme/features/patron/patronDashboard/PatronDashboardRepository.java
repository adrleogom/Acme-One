package acme.features.patron.patronDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;

public interface PatronDashboardRepository extends AbstractRepository {

	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.PROPOSED")
	int totalNumberOfProposedPatronages();
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.ACCEPTED")
	int totalNumberOfAcceptedPatronages();
	@Query("select count(p) from Patronage p where p.status = acme.entities.patronage.Status.DENIED")
	int totalNumberOfDeniedPatronages();
	@Query("select p.budget.currency, avg(p.budget.amount), p.status from Patronage p group by p.budget.currency, p.status")
	List<String> averageBudgetByCurrency();
	@Query("select p.budget.currency, stddev(p), p.status from Patronage p group by p.budget.currency, p.status")
	List<String> deviationBudgetByCurrency();
	@Query("select p.budget.currency, min(p.budget.amount), p.status from Patronage p group by p.budget.currency, p.status")
	List<String> minBudgetByCurrency();
	@Query("select p.budget.currency, max(p.budget.amount), p.status from Patronage p group by p.budget.currency, p.status")
	List<String> maxBudgetByCurrency();
}
