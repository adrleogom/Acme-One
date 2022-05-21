package acme.features.any.toolkit;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.item.Item;
import acme.entities.quantity.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.forms.MoneyExchange;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository extends AbstractRepository{

	@Query("select t from Toolkit t where t.id =:id")
	Toolkit findOneToolkitById(int id);

	@Query("select tk from Toolkit tk where tk.published=:published")
	Collection<Toolkit> findPublishedToolkit(boolean published);
	
	@Query("select q.item.retailPrice.currency from Quantity q where q.toolkit.id=:id")
	Collection<String> findCurenciesOfAToolkit(int id);
	
	@Query("select sum(q.number * q.item.retailPrice.amount) from Quantity q where q.toolkit.id=:id ")
	Double findToolkitRetailPrice(int id);
	
	@Query("select q from Quantity q where q.toolkit.id = :id")
	Collection<Quantity> findQuantityByToolkitId(int id);
	
	@Query("select q.item from Quantity q where q.toolkit.id= :id")
	Collection<Item> findManyItemsByToolkitId(int id);
	
	@Query("select sc.systemCurrency from SystemConfiguration sc")
	String findSystemCurrency();
	
	@Query("select moneyExchange from MoneyExchange moneyExchange where moneyExchange.source.currency = :currency and moneyExchange.source.amount = :amount")
	MoneyExchange findMoneyExchangeByCurrencyAndAmount(String currency, Double amount);

	
	void save(MoneyExchange conversion);
	
}