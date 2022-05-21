
package acme.testing.administrator.announcements;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final String body, final String furtherInfo, final String confirmation, final String flag) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Announcements");
		super.clickOnButton("Create announcement");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.fillInputBoxIn("confirmation", confirmation);

		super.clickOnSubmit("Create");
		super.checkListingExists();
		super.sortListing(0, "desc");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		super.checkInputBoxHasValue("flag", flag);

		super.signOut();
	}
}
