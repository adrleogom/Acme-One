package acme.testing.patron.patronage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageCreateTest extends TestHarness{
	
	
	LocalDateTime initialLocalTime = LocalDateTime.now().plusMonths(2);
    LocalDateTime finalLocalTime = LocalDateTime.now().plusMonths(4);

    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    String initialDate = this.initialLocalTime.format(this.formatDate);
    String finalDate = this.finalLocalTime.format(this.formatDate);
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronageTest(final int recordIndex, final String code,final String budget, final String furtherInfo,
		final String legalStuff) {
		
		
		super.signIn("patron10", "patron10");
	
		super.clickOnMenu("Patron", "List my patronages");
		super.checkListingExists();
		super.clickOnButton("Create patronage");
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("initialDate", this.initialDate);
		super.fillInputBoxIn("finalDate", this.finalDate);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.clickOnSubmit("Create");
		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("initialDate", this.initialDate);
		super.checkInputBoxHasValue("finalDate", this.finalDate);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativePatronageTest(final int recordIndex, final String code,final String budget, final String furtherInfo,
		final String legalStuff) {
		
		
		super.signIn("patron10", "patron10");
		
		super.clickOnMenu("Patron", "List my patronages");
		super.clickOnButton("Create patronage");
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("initialDate", this.initialDate);
		super.fillInputBoxIn("finalDate", this.finalDate);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.clickOnSubmit("Create");
		super.checkErrorsExist();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Patron");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();
		
		super.signIn("administrator", "administrator");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();
		super.signOut();
		
		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();
		super.signOut();
		
		
	}
}
