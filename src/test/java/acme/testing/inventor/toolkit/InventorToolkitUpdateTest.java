package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitUpdateTest extends TestHarness{
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex,final String code, final String title,
		  final String description,final String assemblyNotes,final String furtherInfo,
		  final String published) {
			super.signIn("inventor1", "inventor1");
		
		
			super.clickOnMenu("Inventor", "List my toolkits");
			super.checkListingExists();
			
			super.clickOnListingRecord(recordIndex);
			super.checkFormExists();
			super.fillInputBoxIn("code", code);
			super.fillInputBoxIn("title", title);
			super.fillInputBoxIn("description", description);
			super.fillInputBoxIn("assemblyNotes", assemblyNotes);
			super.fillInputBoxIn("furtherInfo", furtherInfo);
			super.clickOnSubmit("Update toolkit");
			
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

			super.signOut();

	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negative(final int recordIndex,final String code, final String title,
		  final String description,final String assemblyNotes,final String furtherInfo,
		  final String published) {
			super.signIn("inventor1", "inventor1");
		
		
			super.clickOnMenu("Inventor", "List my toolkits");
			super.checkListingExists();
			
			super.clickOnListingRecord(recordIndex);
			super.checkFormExists();
			
			super.fillInputBoxIn("code", code);
			super.fillInputBoxIn("title", title);
			super.fillInputBoxIn("description", description);
			super.fillInputBoxIn("assemblyNotes", assemblyNotes);
			super.fillInputBoxIn("furtherInfo", furtherInfo);
			super.clickOnSubmit("Update toolkit");
			
			super.checkErrorsExist();

			super.signOut();

	}
}
