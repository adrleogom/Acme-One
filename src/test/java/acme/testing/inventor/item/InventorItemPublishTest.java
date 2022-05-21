package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemPublishTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String itemType, final String name,final String code, final String technology, 
		final String description, final String retailPrice,final String furtherInfo) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my components and tools");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 1, name);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();

		super.signOut();
	}
	
	

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publish-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String itemType, final String name,final String code, final String technology, 
		final String description, final String retailPrice,final String furtherInfo) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my components and tools");
		super.checkListingExists();
		super.sortListing(1, "asc");

		super.checkColumnHasValue(recordIndex, 1, name);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists(); super.fillInputBoxIn("itemType", itemType);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("retailPrice", retailPrice);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.clickOnSubmit("Publish");
		super.checkErrorsExist();

		super.signOut();
	}
}
