package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemDeleteTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources= "/inventor/item/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String itemType, final String name,final String code, final String technology, 
		final String description, final String retailPrice,final String furtherInfo) {
		super.signIn("inventor5", "inventor5");
		
		super.clickOnMenu("Inventor", "List my components and tools");
		super.checkListingExists();
		super.sortListing(0, "asc");

		
		super.checkColumnHasValue(recordIndex, 0, itemType);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.clickOnListingRecord(1);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("itemType", itemType);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		
		super.clickOnSubmit("Delete");
		super.signOut();
		
	
	}
	
	@ParameterizedTest
	@CsvFileSource(resources= "/inventor/item/delete-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String itemType, final String name,final String code, final String technology, 
		final String description, final String retailPrice,final String furtherInfo) {
	super.signIn("inventor5", "inventor5");
		
		super.clickOnMenu("Inventor", "List my components and tools");
		super.checkListingExists();
		super.sortListing(0, "asc");

		
		super.checkColumnHasValue(recordIndex, 0, itemType);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);
		super.clickOnListingRecord(0);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("itemType", itemType);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		
		super.checkNotSubmitExists("Delete");
		super.signOut();
		
	}

	
}
