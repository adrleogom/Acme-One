package acme.testing.authenticated.becomePatron;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.core.annotation.Order;

import acme.testing.TestHarness;

public class BecomePatronNegativeTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/become-patron/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String company, final String statement, final String furtherInfo) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Account", "Become a patron");
		super.checkFormExists();
		
		super.fillInputBoxIn("company", company);
		super.fillInputBoxIn("statement", statement);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.clickOnSubmit("Register");
		
		super.checkErrorsExist();

	}
	

}
