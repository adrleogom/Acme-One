package acme.helper.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.framework.repositories.AbstractRepository;

public interface ToolkitHelperRepository extends AbstractRepository{

	@Query("select q.item.retailPrice.currency from Quantity q where q.toolkit.id=:id")
	Collection<String> findAllCurenciesOfAToolkit(int id);
	
	@Query("select sum(q.number * q.item.retailPrice.amount) from Quantity q where q.toolkit.id=:id ")
	Double amountOfToolkitRetailPrice(int id);
	
}
