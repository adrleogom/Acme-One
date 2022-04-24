package acme.forms;


import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import acme.entities.stat.Stat;
import acme.framework.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable{
	

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int totalNumberOfComponents;
	
	int totalNumberOfTools;
	
	protected Map<Status, Integer>					totalNumberOfPatronages;
	
	protected Map<Pair<String,String>,Stat> retailPriceOfComponents;
	
	protected Map<Money,Stat> retailPriceOfTools;
	
	protected Map<Pair<Status, String>, Stat>	budgetOfPatronages;
	
	

}
