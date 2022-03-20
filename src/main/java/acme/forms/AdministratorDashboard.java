package acme.forms;


import java.io.Serializable;
import java.util.Map;

import org.springframework.data.util.Pair;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable{
	

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int totalNumberComponents;
	int totalNumberTools;
	
	Map<Pair<String,String>,Double>averageRetailPriceComponents;
	Map<Pair<String,String>,Double>deviationRetailPriceComponents;
	Map<Pair<String,String>,Double>minRetailPriceComponents;
	Map<Pair<String,String>,Double>maxRetailPriceComponents;
	
	Map<String,Double> averageRetailPriceTools;
	Map<String,Double> deviationRetailPriceTools;
	Map<String,Double> maxRetailPriceTools;
	Map<String,Double> minRetailPriceTools;
	
	int totalNumberProposedPatronages;
	int totalNumberAcceptedPatronages;
	int totalNumberDeniedPatronages;
	
	Map<String,Double> averageBudgetByCurrency;
	Map<String,Double> deviationBudgetByCurrency;
	Map<String,Double> minBudgetByCurrency;
	Map<String,Double> maxBudgetByCurrency;
	

}
