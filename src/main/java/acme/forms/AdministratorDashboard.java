package acme.forms;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard implements Serializable{
	

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	
	//Components
	 Integer totalNumberOfComponents;
	 Integer averageComponentsRetailPriceEUR;
	 Integer averageComponentsRetailPriceGBP;
	 Integer averageComponentsRetailPriceUSD;
	 Integer deviationComponentsRetailPriceEUR;
	 Integer deviationComponentsRetailPriceGBP;
	 Integer deviationComponentsRetailPriceUSD;
	 Integer minComponentsRetailPriceEUR;
	 Integer minComponentsRetailPriceGBP;
	 Integer minComponentsRetailPriceUSD;
	 Integer maxComponentsRetailPriceEUR;
	 Integer maxComponentsRetailPriceGBP;
	 Integer maxComponentsRetailPriceUSD;
	 
	 
	 //Tools
	 Integer totalNumberOfTools;
	 Integer averageToolsRetailPriceEUR;
	 Integer averageToolsRetailPriceGBP;
	 Integer averageToolsRetailPriceUSD;
	 Integer deviationToolsRetailPriceEUR;
	 Integer deviationToolsRetailPriceGBP;
	 Integer deviationToolsRetailPriceUSD;
	 Integer minToolsRetailPriceEUR;
	 Integer minToolsRetailPriceGBP;
	 Integer minToolsRetailPriceUSD;
	 Integer maxToolsRetailPriceEUR;
	 Integer maxToolsRetailPriceGBP;
	 Integer maxToolsRetailPriceUSD;
	 	 
	 
	 //Proposed patronages
	 Integer totalNumberProposedPatronages;
	 Integer deviationBudgetProposedPatronages;
	 Integer averageBudgetProposedPatronages;
	 Integer minBudgetProposedPatronages;
	 Integer maxBudgetProposedPatronages;

	 //Accepted patronages
	 Integer totalNumberAccepedPatronages;
	 Integer deviationBudgetAcceptedPatronages;
	 Integer averageBudgetAcceptedPatronages;
	 Integer minBudgetAcceptedPatronages;
	 Integer maxBudgetAcceptedPatronages;

	 //Denied patronages
	 Integer totalNumberDeniedPatronages;
	 Integer deviationBudgetDeniedPatronages;
	 Integer averageBudgetDeniedPatronages; 
	 Integer minBudgetDeniedPatronages;
	 Integer maxBudgetDeniedPatronages;

}
