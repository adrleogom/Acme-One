package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitCreateTest extends TestHarness{
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex,final String code, final String title,
		  final String description,final String assemblyNotes,final String furtherInfo,
		  final String published) {
			super.signIn("inventor1", "inventor1");
		
		
			super.clickOnMenu("Inventor", "List my toolkits");
			super.checkListingExists();
			
			super.clickOnButton("New toolkit");
			super.fillInputBoxIn("code", code);
			super.fillInputBoxIn("title", title);
			super.fillInputBoxIn("description", description);
			super.fillInputBoxIn("assemblyNotes", assemblyNotes);
			super.fillInputBoxIn("furtherInfo", furtherInfo);
			super.clickOnSubmit("Create toolkit");
			
			super.clickOnMenu("Inventor", "List my toolkits");
			super.checkListingExists();
			super.sortListing(0, "asc");
			super.checkColumnHasValue(recordIndex, 0, code);
			super.checkColumnHasValue(recordIndex, 1, title);
			super.checkColumnHasValue(recordIndex, 2, published);
			super.clickOnListingRecord(recordIndex);

			super.checkFormExists();
			super.checkInputBoxHasValue("code", code);
			super.checkInputBoxHasValue("title", title);
			super.checkInputBoxHasValue("description", description);
			super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);
			super.checkInputBoxHasValue("furtherInfo", furtherInfo);

			super.clickOnButton("Components and Tools");

			super.checkListingExists();
			super.checkListingEmpty();
			
			super.signOut();

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex,final String code, final String title,
		  final String description,final String assemblyNotes,final String furtherInfo,
		  final String published) {
			super.signIn("inventor1", "inventor1");
		
		
			super.clickOnMenu("Inventor", "List my toolkits");
			super.checkListingExists();
			
			super.clickOnButton("New toolkit");
			super.fillInputBoxIn("code", code);
			super.fillInputBoxIn("title", title);
			super.fillInputBoxIn("description", description);
			super.fillInputBoxIn("assemblyNotes", assemblyNotes);
			super.fillInputBoxIn("furtherInfo", furtherInfo);
			super.clickOnSubmit("Create toolkit");
			
			super.checkErrorsExist();

			super.signOut();

	}
	
	@Test
    @Order(30)
    public void hackingTest() {
        super.navigate("/inventor/toolkit/create");
        super.checkPanicExists();
    }
}
