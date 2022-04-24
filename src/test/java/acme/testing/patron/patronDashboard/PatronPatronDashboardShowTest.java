
package acme.testing.patron.patronDashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class PatronPatronDashboardShowTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patron-dashboard/patron.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)

	public void patronPatronDashboardShowTest(final String totalPROPOSED, final String totalDENIED, final String totalACCEPTED, final String averageEURPROPOSED, final String deviationEURPROPOSED, final String minEURPROPOSED, final String maxEURPROPOSED,
		final String averageUSDACCEPTED, final String deviationUSDACCEPTED, final String minUSDACCEPTED, final String maxUSDACCEPTED, final String averageEURDENIED, final String deviationEURDENIED, final String minEURDENIED, final String maxEURDENIED) {
		super.signIn("patron1", "patron1");
		super.clickOnMenu("Patron", "Patron Dashboard");
		final BrowserDriver driver = super.getDriver();
		WebElement totalBYDENIED = null;
		WebElement totalBYACCEPTED = null;
		WebElement totalBYPROPOSED = null;
		WebElement averageBYUSDACCEPTED = null;
		WebElement deviationBYUSDACCEPTED = null;
		WebElement minBYUSDACCEPTED = null;
		WebElement maxBYUSDACCEPTED = null;
		WebElement averageBYEURDENIED = null;
		WebElement deviationBYEURDENIED = null;
		WebElement minBYEURDENIED = null;
		WebElement maxBYEURDENIED = null;
		WebElement averageBYEURPROPOSED = null;
		WebElement deviationBYEURPROPOSED = null;
		WebElement minBYEURPROPOSED = null;
		WebElement maxBYEURPROPOSED = null;

		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[2]/td[1]")).getText().equals("ACCEPTED")) {
			totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[2]/td[2]"));
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[1]")).getText().equals("DENIED")) {
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[2]"));
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[4]/td[2]"));
			} else {
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[2]"));
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[4]/td[2]"));
			}
		} else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[2]/td[1]")).getText().equals("DENIED")) {
			totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[2]/td[2]"));
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[2]"));
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[4]/td[2]"));
			} else {
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[2]"));
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[4]/td[2]"));
			}
		} else {
			totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[2]/td[2]"));
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[2]"));
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[4]/td[2]"));
			} else {
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[3]/td[2]"));
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr[4]/td[2]"));
			}
		}

		//PRIMERA FILA ACCEPTED
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[1]")).getText().equals("ACCEPTED")) {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
			//SEGUNDA FILA DENIED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[1]")).getText().equals("DENIED")) {
				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
				
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
			}
			//SEGUNDA FILA PROPOSED
			else {
				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
				
				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
			}
		}
		//PRIMERA FILA DENIED
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[1]")).getText().equals("DENIED")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
			//SEGUNDA FILA ACCEPTED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
				
				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
			}
			//SEGUNDA FILA PROPOSED
			else {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
				
				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
			}
		}
		//PRIMERA FILA PROPOSED
		else {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
			//SEGUNDA FILA ACCEPTED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
				
				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
			}
			//SEGUNDA FILA DENIED
			else {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
				
				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
			}
		}

		assert totalPROPOSED.equals(totalBYPROPOSED.getText());
		assert totalACCEPTED.equals(totalBYACCEPTED.getText());
		assert totalDENIED.equals(totalBYDENIED.getText());
		
		assert averageEURPROPOSED.equals(averageBYEURPROPOSED.getText());
		assert deviationEURPROPOSED.equals(deviationBYEURPROPOSED.getText());
		assert minEURPROPOSED.equals(minBYEURPROPOSED.getText());
		assert maxEURPROPOSED.equals(maxBYEURPROPOSED.getText());
		
		assert averageEURDENIED.equals(averageBYEURDENIED.getText());
		assert deviationEURDENIED.equals(deviationBYEURDENIED.getText());
		assert minEURDENIED.equals(minBYEURDENIED.getText());
		assert maxEURDENIED.equals(maxBYEURDENIED.getText());
		
		assert averageUSDACCEPTED.equals(averageBYUSDACCEPTED.getText());
		assert deviationUSDACCEPTED.equals(deviationBYUSDACCEPTED.getText());
		assert minUSDACCEPTED.equals(minBYUSDACCEPTED.getText());
		assert maxUSDACCEPTED.equals(maxBYUSDACCEPTED.getText());

		super.signOut();
	}

}
