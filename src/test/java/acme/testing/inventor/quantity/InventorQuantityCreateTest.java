
package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveQuantityCreateTest(final int recordIndex1, final int recordIndex2) {

		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.clickOnListingRecord(recordIndex1);
		super.clickOnButton("Quantities list");
		super.clickOnButton("Add component or tool");
		super.fillInputBoxIn("number", "1");
		super.clickOnSubmit("Add component or tool");
		super.checkColumnHasValue(recordIndex2, 0, "TOOL");
		super.checkColumnHasValue(recordIndex2, 1, "Item 8");
		super.signOut();
	}
}
