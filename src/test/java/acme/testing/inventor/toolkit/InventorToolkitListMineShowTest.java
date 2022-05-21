package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitListMineShowTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex,final String code, final String title,
		  final String description,final String assemblyNotes,final String published, 
		final String retailPrice, final String furtherInfo) {
		if (recordIndex < 4) {
			super.signIn("inventor1", "inventor1");
		
		
			super.clickOnMenu("Inventor", "List my toolkits");
			super.checkListingExists();
			super.sortListing(0, "asc");
		
			super.checkColumnHasValue(recordIndex, 0, code);
			super.checkColumnHasValue(recordIndex, 1, title);
			
		
			super.clickOnListingRecord(recordIndex);
			super.checkFormExists();
		
			super.checkInputBoxHasValue("code", code);
			super.checkInputBoxHasValue("title", title);
			super.checkInputBoxHasValue("description", description);
			super.checkInputBoxHasValue("assemblyNotes", assemblyNotes);
			if (published=="true") {
			super.checkInputBoxHasValue("published", published);
			}
			super.checkInputBoxHasValue("furtherInfo", furtherInfo);
			if (published=="true") {
			super.checkInputBoxHasValue("retailPrice", retailPrice);
			}
		
			super.checkButtonExists("Components and Tools");
			super.clickOnButton("Components and Tools");
			
			super.checkListingExists();
		}
	}
	
	@Test
    @Order(20)
    public void hackingTest() {
        super.navigate("/inventor/toolkit/list");
        super.checkPanicExists();
    }
	
}