
package acme.testing.administrator.announcements;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-announcement.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final int recordIndex, final String title, final String body, final String furtherInfo, final String confirmation, final String flag) {
		
		final BrowserDriver driver = super.getDriver();
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Announcements");
		super.clickOnButton("Create announcement");
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("furtherInfo", furtherInfo);
		super.fillInputBoxIn("confirmation", confirmation);

		super.clickOnSubmit("Create");
		super.checkListingExists();
		driver.clickAndGo(driver.locateOne(By.xpath("//*[@id=\"list_paginate\"]/ul/li[2]/a")));
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.clickOnListingRecord(recordIndex);
		
		assert driver.locateOne(By.xpath("/html/body/div[2]/div/form/div[1]/textarea")).getText().equals(title);
		assert driver.locateOne(By.xpath("/html/body/div[2]/div/form/div[2]/textarea")).getText().equals(body);
		assert driver.locateOne(By.xpath("/html/body/div[2]/div/form/div[3]/textarea")).getText().equals(furtherInfo);
		assert driver.locateOne(By.xpath("/html/body/div[2]/div/form/div[4]/textarea")).getText().equals(flag);
		super.signOut();
	}
}
