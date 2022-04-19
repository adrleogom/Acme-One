package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository extends AbstractRepository{

	@Query("select t from Toolkit t where t.id =:id")
	Toolkit findOneToolkitById(int id);

	@Query("select tk from Toolkit tk")
	Collection<Toolkit> findToolkit();
	
//	@Query("select q.item from Quantity q where q.toolkit.id= :id")
//	Collection<Toolkit> findToolkitById2(int id);
}