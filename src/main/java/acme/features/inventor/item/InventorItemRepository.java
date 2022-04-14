package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.item.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorItemRepository extends AbstractRepository{

	@Query("select i from Item i where i.id =:id")
	Item findOneComponentById(int id);
	
	@Query("select i from Item i")
	Collection<Item> findAllItems();
	
	@Query("select i from Item i where i.inventor.userAccount.id = :inventorId")
	Collection<Item> findItemsByInventorId (int inventorId);
}
