package acme.features.any.item;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.item.Item;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyItemRepository extends AbstractRepository{
	@Query("select it from Item it where it.published=:published")
	Collection<Item> findPublishedItems(boolean published);

	@Query("select it from Item it where it.id = :id")
	Item findItemById(int id);
	
	@Query("select q.item from Quantity q where q.toolkit.id = :masterId and q.item.published = true")
	Collection<Item> findManyPublishedItemsByMasterId(int masterId);
}