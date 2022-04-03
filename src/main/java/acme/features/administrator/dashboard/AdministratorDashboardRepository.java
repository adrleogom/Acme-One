package acme.features.administrator.dashboard;

import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.patronage.Status;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository{
	
	@Query("select count(i) from Item i where i.itemType = COMPONENT")	
	int totalNumberOfComponents();
	
	@Query("select count(i) from Item i where i.itemType = TOOL")	
	int totalNumberOfTools();
	
	@Query("select count(i) from Item i where i.itemType = PATRONAGE")	
	Map<Status,Integer> totalNumberOfPatronages();

}
