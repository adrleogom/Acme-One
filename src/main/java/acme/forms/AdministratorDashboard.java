package acme.forms;


import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entitites.stat.Stat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable{
	

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int totalNumberComponents;
	Map<Pair<String,String>,Stat>retailPriceOfComponents;
	
	int totalNumberTools;
	Map<Pair<String,String>,Stat>retailPriceOfTools;

	
	int totalNumberOfPatronages;
	Map<Pair<String,String>,Stat>budgetOfPatronages;
	
	

}
