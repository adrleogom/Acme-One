package acme.testing.authenticated.becomeInventor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.core.annotation.Order;

import acme.testing.TestHarness;

public class BecomeInventorPositiveTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/become-inventor/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String company, final String statement, final String furtherInfo) {
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Account", "Become an inventor");
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.clickOnSubmit("Register");

		super.clickOnMenu("Account", "Inventor data");
		super.checkInputBoxHasValue("company", company);
		super.checkInputBoxHasValue("statement", statement);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		

	}

	

}
