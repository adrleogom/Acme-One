package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageReportListShowButtonListShowTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/patronage.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTestAuthenticated(final int recordIndex, final String code, final String status, final String initialDate, final String finalDate, final String legalStuff, final String budget, final String furtherInfo, final String company,
		final String statement, final String pFurtherInformation, final String name, final String surname, final String sNumber, final String creationMoment, final String memorandum, final String rFurtherInfo) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patron", "List my patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, status);
		super.checkColumnHasValue(recordIndex, 2, initialDate);
		super.checkColumnHasValue(recordIndex, 3, finalDate);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("status", status);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		super.checkInputBoxHasValue("inventor.company", company);
		super.checkInputBoxHasValue("inventor.statement", statement);
		super.checkInputBoxHasValue("inventor.furtherInfo", pFurtherInformation);
		super.checkInputBoxHasValue("inventor.identity.name", name);
		super.checkInputBoxHasValue("inventor.identity.surname", surname);

		super.clickOnButton("Patronage reports");
		super.checkListingExists();
		super.sortListing(0, "desc");

		super.checkColumnHasValue(recordIndex, 0, sNumber);
		super.checkColumnHasValue(recordIndex, 1, creationMoment);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("furtherInfo", rFurtherInfo);

		super.signOut();
	}
	
		@Test
		@Order(30)
		public void hackingTest1() {
			super.checkNotLinkExists("Patron");
			super.navigate("/patron/patronage/list");
			super.checkPanicExists();
		}
		
}
