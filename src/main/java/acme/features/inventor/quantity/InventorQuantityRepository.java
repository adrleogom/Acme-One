package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.item.Item;
import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorQuantityRepository extends AbstractRepository{

	@Query("select t from Toolkit t where t.id =:id")
	Toolkit findOneToolkitById(int id);
	
	@Query("select i from Item i where i.id =:id")
	Item findOneItemById(int id);
	
	@Query("select i from Inventor i where i.userAccount.id = :id")
	Inventor findOneInventorByUserAccountId(int id);
	
	@Query("select q.item from Quantity q where q.toolkit.id= :id")
	Collection<Item> findManyItemsByToolkitId(int id);
	
	@Query("select i from Item i where i.inventor.userAccount.id = :inventorId")
	Collection<Item> findItemsByAccountId (int inventorId);
}
