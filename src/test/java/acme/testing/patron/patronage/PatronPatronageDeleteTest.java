package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageDeleteTest extends TestHarness{
	
	@ParameterizedTest
	@Order(10)
	@CsvFileSource(resources = "/patron/patronage/delete.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positivePatronageTest(final int recordIndex) {
		
		super.signIn("patron3", "patron3");
		super.clickOnMenu("Patron", "List my patronages");
		super.clickOnListingRecord(recordIndex);
		super.clickOnSubmit("Delete");
		super.checkNotErrorsExist();
		super.checkListingEmpty();
		super.signOut();
	}
	
	@Test
	@Order(20)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/patronage/delete");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/patron/patronage/delete");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/patronage/delete");
		super.checkPanicExists();
		super.signOut();
		
	}

}
