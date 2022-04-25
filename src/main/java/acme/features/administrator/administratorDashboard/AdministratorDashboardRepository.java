
package acme.features.administrator.administratorDashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;

public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(i) from Item i where i.itemType = acme.entities.item.ItemType.COMPONENT")
	int totalNumberOfComponents();

	@Query("select count(i) from Item i where i.itemType = acme.entities.item.ItemType.TOOL")
	int totalNumberOfTools();

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

	@Query("select p.retailPrice.amount, p.retailPrice.currency, avg(p.retailPrice.amount) from Item p where p.itemType=acme.entities.item.ItemType.TOOL group by p.retailPrice.currency")
	List<String> averageMoney();

	@Query("select p.retailPrice.amount, p.retailPrice.currency, stddev(p.retailPrice.amount) from Item p where p.itemType=acme.entities.item.ItemType.TOOL group by p.retailPrice.currency")
	List<String> deviationMoney();

	@Query("select p.retailPrice.amount, p.retailPrice.currency, min(p.retailPrice.amount) from Item p where p.itemType=acme.entities.item.ItemType.TOOL group by p.retailPrice.currency")
	List<String> minMoney();

	@Query("select p.retailPrice.amount, p.retailPrice.currency, max(p.retailPrice.amount) from Item p where p.itemType=acme.entities.item.ItemType.TOOL group by p.retailPrice.currency")
	List<String> maxMoney();
	
	@Query("select p.retailPrice.amount, p.retailPrice.currency, avg(p.retailPrice.amount), p.technology from Item p where p.itemType=acme.entities.item.ItemType.COMPONENT group by p.retailPrice.currency, p.technology")
	List<String> averageMoneyComponent();

	@Query("select p.retailPrice.amount, p.retailPrice.currency, stddev(p.retailPrice.amount), p.technology from Item p where p.itemType=acme.entities.item.ItemType.COMPONENT group by p.retailPrice.currency, p.technology")
	List<String> deviationMoneyComponent();

	@Query("select p.retailPrice.amount, p.retailPrice.currency, min(p.retailPrice.amount), p.technology from Item p where p.itemType=acme.entities.item.ItemType.COMPONENT group by p.retailPrice.currency, p.technology")
	List<String> minMoneyComponent();

	@Query("select p.retailPrice.amount, p.retailPrice.currency, max(p.retailPrice.amount), p.technology from Item p where p.itemType=acme.entities.item.ItemType.COMPONENT group by p.retailPrice.currency, p.technology")
	List<String> maxMoneyComponent();

}
