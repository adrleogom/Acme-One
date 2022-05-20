package acme.features.inventor.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.item.Item;
import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorItemRepository extends AbstractRepository{

	@Query("select i from Item i where i.id =:id")
	Item findOneItemById(int id);
	
	
	@Query("select i from Item i where i.inventor.userAccount.id = :inventorId")
	Collection<Item> findItemsByInventorId (int inventorId);
	
	@Query("select t from Toolkit t where t.id = :masterId")
	Toolkit findOneToolkitById(int masterId);
	
	@Query("select q.item from Quantity q where q.toolkit.id = :masterId and q.item.published = true")
	Collection<Item> findManyPublishedItemsByMasterId(int masterId);
	
	@Query("select i from Inventor i where i.userAccount.id = :id")
	Inventor findInventorById(int id);
	
	@Query("select i from Item i where i.code =:code")
	Item findItemByCode(String code);
	
	
}
