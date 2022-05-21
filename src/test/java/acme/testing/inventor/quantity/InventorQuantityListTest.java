
package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityListTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveQuantityListTest(final int recordIndex1) {

		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List my toolkits");
		super.clickOnListingRecord(recordIndex1);
		super.clickOnButton("Quantities list");
		super.checkListingExists();
		super.signOut();
	}
}
