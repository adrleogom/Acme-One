
package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityUpdateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/update.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveQuantityUpdateTest(final int recordIndex1, final int recordIndex2, final int recordIndex3, final String numero) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my toolkits");
		super.clickOnListingRecord(recordIndex1);
		super.clickOnButton("Quantities list");
		super.clickOnListingRecord(recordIndex2);
		super.fillInputBoxIn("number", numero);
		super.clickOnSubmit("Update quantity");
		super.checkColumnHasValue(recordIndex2, recordIndex3, numero);
		super.signOut();
	}

}
