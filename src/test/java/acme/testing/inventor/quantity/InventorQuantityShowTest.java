package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityShowTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveQuantityShowTest(final int recordIndex1, final int recordIndex2) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List my toolkits");
		super.clickOnListingRecord(recordIndex1);
		super.clickOnButton("Quantities list");
		super.clickOnListingRecord(recordIndex2);
		super.checkFormExists();
		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Inventor");
		super.navigate("/inventor/quantity/show");
		super.checkPanicExists();
		
	}
}
