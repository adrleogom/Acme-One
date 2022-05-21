package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportCreateTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronageReportTest(final int recordIndex, final String memorandum,final String furtherInfo) {
		
		
		super.signIn("inventor1", "inventor1");
	
		super.clickOnMenu("Inventor", "List my patronages");
		super.clickOnListingRecord(1);
		super.clickOnButton("Create patronage report");
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.fillInputBoxIn("confirmation", "true");
		super.clickOnSubmit("Create");
		super.clickOnButton("Patronage reports");
		super.checkListingExists();
		super.sortListing(0, "desc");
		super.clickOnListingRecord(0);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativePatronageReportTest(final int recordIndex, final String memorandum,final String furtherInfo,final String confirmation) {
		
		
		super.signIn("inventor1", "inventor1");
		
		super.clickOnMenu("Inventor", "List my patronages");
		super.clickOnListingRecord(recordIndex);
		super.clickOnButton("Create patronage report");
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.fillInputBoxIn("confirmation",confirmation);
		super.clickOnSubmit("Create");
		super.checkErrorsExist();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Inventor");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();
		
	}

}