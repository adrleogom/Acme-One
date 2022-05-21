package acme.features.authenticated.moneyExchange;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.forms.MoneyExchange;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMoneyExchangeRepository extends AbstractRepository{

	@Query("select sc.systemCurrency from SystemConfiguration sc")
	String findSystemCurrency();
	
	@Query("select moneyExchange from MoneyExchange moneyExchange where moneyExchange.source.currency = :currency and moneyExchange.source.amount = :amount")
	MoneyExchange findMoneyExchangeByCurrencyAndAmount(String currency, Double amount);
	
}
