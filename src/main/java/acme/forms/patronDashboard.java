
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class patronDashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	Integer						totalNumberOfProposedPatronages;
	Integer						totalNumberOfAccepedPatronages;
	Integer						totalNumberOfDeniedPatronages;
	Integer						deviationBudgetPatronageProposedEUR;
	Integer						deviationBudgetPatronageAcceptedEUR;
	Integer						deviationBudgetPatronageDeniedEUR;
	Integer						averageBudgetPatronageProposedEUR;
	Integer						averageBudgetPatronageAcceptedEUR;
	Integer						averageBudgetPatronageDeniedEUR;
	Integer						maximumBudgetPatronageProposedEUR;
	Integer						maximumBudgetPatronageAcceptedEUR;
	Integer						maximumBudgetPatronageDeniedEUR;
	Integer						minimumBudgetPatronageProposedEUR;
	Integer						minimumBudgetPatronageAcceptedEUR;
	Integer						minimumBudgetPatronageDeniedEUR;
	Integer						deviationBudgetPatronageProposedUSD;
	Integer						deviationBudgetPatronageAcceptedUSD;
	Integer						deviationBudgetPatronageDeniedUSD;
	Integer						averageBudgetPatronageProposedUSD;
	Integer						averageBudgetPatronageAcceptedUSD;
	Integer						averageBudgetPatronageDeniedUSD;
	Integer						maximumBudgetPatronageProposedUSD;
	Integer						maximumBudgetPatronageAcceptedUSD;
	Integer						maximumBudgetPatronageDeniedUSD;
	Integer						minimumBudgetPatronageProposedUSD;
	Integer						minimumBudgetPatronageAcceptedUSD;
	Integer						minimumBudgetPatronageDeniedUSD;
	Integer						deviationBudgetPatronageProposedGBP;
	Integer						deviationBudgetPatronageAcceptedGBP;
	Integer						deviationBudgetPatronageDeniedGBP;
	Integer						averageBudgetPatronageProposedGBP;
	Integer						averageBudgetPatronageAcceptedGBP;
	Integer						averageBudgetPatronageDeniedGBP;
	Integer						maximumBudgetPatronageProposedGBP;
	Integer						maximumBudgetPatronageAcceptedGBP;
	Integer						maximumBudgetPatronageDeniedGBP;
	Integer						minimumBudgetPatronageProposedGBP;
	Integer						minimumBudgetPatronageAcceptedGBP;
	Integer						minimumBudgetPatronageDeniedGBP;
}
