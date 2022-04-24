package acme.testing.any.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyItemListPublishedTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String itemType, final String name,
		final String code, final String technology, final String description, 
		final String retailPrice, final String furtherInfo, final String inventor) {
		

		super.clickOnMenu("Anonymous", "List published items");
		super.checkListingExists();
		super.sortListing(0, "asc");


		super.checkColumnHasValue(recordIndex, 0, itemType);
		super.checkColumnHasValue(recordIndex, 1, name);
		super.checkColumnHasValue(recordIndex, 2, code);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("itemType", itemType);
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		super.checkInputBoxHasValue("inventor", inventor);

	}
	
}