package acme.testing.authenticated.announcements;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedAnnouncementListTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTestAuthenticated(final int recordIndex, final String moment, final String title, final String body, final String flag, final String furtherInfo) {
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Authenticated", "Announcements");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, moment);
		super.checkColumnHasValue(recordIndex, 1, flag);
		super.checkColumnHasValue(recordIndex, 2, title);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("moment", moment);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("flag", flag);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("flag", flag);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		
		super.signOut();
	}

}
