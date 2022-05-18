
package acme.testing.administrator.announcements;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final String body, final String furtherInfo) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Announcements");
		super.clickOnButton("Create announcement");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.clickOnMenu("confirmation");

		super.clickOnSubmit("Create");
		super.checkListingExists();
		super.checkColumnHasValue(7, 0, "Title");
		super.checkColumnHasValue(7, 1, "Body");
		super.checkColumnHasValue(7, 2, "http://www.google.com");
	}
}
