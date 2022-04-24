package acme.testing.patron.patronDashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class PatronPatronDashboardShowTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patron-dashboard/patron.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	
	public void patronPatronDashboardShowTest(final String totalPROPOSED, final String totalDENIED, final String totalACCEPTED) {
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "Patron Dashboard");
		
		final BrowserDriver driver= super.getDriver();
		final WebElement totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[2]/td[2]"));
//		final WebElement totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[2]"));
		final WebElement totalBYDENIED = driver.locateOne(By.cssSelector("/html/body/div[2]/div/table[1]/tbody/tr[4]/td[2]"));
		
//		System.out.println(totalBYPROPOSED.getText() + totalBYACCEPTED.getText());
		
		assert totalPROPOSED.equals(totalBYPROPOSED.getText());
//		assert totalACCEPTED.equals(totalBYACCEPTED.getText());
		assert totalDENIED.equals(totalBYDENIED.getText());
		
		super.signOut();
	}

}
