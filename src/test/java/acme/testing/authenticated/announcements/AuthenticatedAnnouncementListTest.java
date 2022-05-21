package acme.testing.authenticated.announcements;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.announcement.Announcement;
import acme.framework.helpers.FactoryHelper;
import acme.testing.TestHarness;

public class AuthenticatedAnnouncementListTest extends TestHarness{
	
	@Autowired
	private AuthenticatedAnnouncementRepositoryTest announcementRepository;
	
	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTestAuthenticated(final int recordIndex, final String moment, final String title, final String body, final String flag, final String furtherInfo, final int days) {
		FactoryHelper.autowire(this);
		
		Calendar calendar;
		Date deadline;

		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -days);
		deadline = calendar.getTime();
		final Announcement announcement = this.announcementRepository.findOneAnnouncementByTitle(title);
		announcement.setMoment(deadline);
		this.announcementRepository.save(announcement);
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		final String sdate = dateFormat.format(deadline);
		
		super.signIn("patron1", "patron1");
		
		super.clickOnMenu("Authenticated", "Announcements");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, sdate);
		super.checkColumnHasValue(recordIndex, 1, flag);
		super.checkColumnHasValue(recordIndex, 2, title);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("moment", sdate);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("flag", flag);
		super.checkInputBoxHasValue("body", body);
		super.checkInputBoxHasValue("flag", flag);
		super.checkInputBoxHasValue("furtherInfo", furtherInfo);
		
		super.signOut();
	}
	
	@Test
    @Order(30)
    public void hackingTest() {
        super.navigate("/authenticated/announcement/list");
        super.checkPanicExists();
    }

}
