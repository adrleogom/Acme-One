package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitListMineShowTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String furtherInfo, final String inventor) {
		
		super.signIn("inventor4", "inventor4");


		super.clickOnMenu("Inventor", "List my toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, name);
		

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
	
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		super.checkInputBoxHasValue("inventor", inventor);
		
		super.checkButtonExists("Components and Tools");
		super.clickOnButton("Components and Tools");
		
		super.checkListingExists();
		
	}
}