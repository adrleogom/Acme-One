package acme.forms;


import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronage.Status;
import acme.entities.stat.Stat;
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
	
	Map<Status,Integer> totalNumberOfPatronages;
	
	Map<Pair<String,String>,Stat> retailPriceOfComponents;
	
	Map<String,Stat> retailPriceOfTools;
	
	Map<Status,Stat> budgetOfPatronages;
	
	

}
