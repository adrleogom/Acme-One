package acme.testing.patron.patronage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronagePublishTest extends TestHarness{
	
	LocalDateTime initialLocalTime = LocalDateTime.now().plusMonths(2);
    LocalDateTime finalLocalTime = LocalDateTime.now().plusMonths(4);

    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String initialDate = this.initialLocalTime.format(this.formatDate);
    String finalDate = this.finalLocalTime.format(this.formatDate);
	
	@ParameterizedTest
	@Order(10)
	@CsvFileSource(resources = "/patron/patronage/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	public void positivePatronageTest(final int recordIndex, final String published) {
		
		super.signIn("patron3", "patron3");
		super.clickOnMenu("Patron", "List my patronages");
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("initialDate", this.initialDate);
		super.fillInputBoxIn("finalDate", this.finalDate);
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();
		super.checkColumnHasValue(recordIndex, 4, published);
		super.signOut();
	}
	
	@Test
	@Order(20)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/patronage/publish");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/patron/patronage/publish");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/patronage/publish");
		super.checkPanicExists();
		super.signOut();
		
	}

}
