
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
		final String averageUSDACCEPTED, final String deviationUSDACCEPTED, final String minUSDACCEPTED, final String maxUSDACCEPTED, final String averageEURDENIED, final String deviationEURDENIED, final String minEURDENIED, final String maxEURDENIED,
		final String averageBYUSDPROPOSEDCSV, final String deviationBYUSDPROPOSEDCSV, final String minBYUSDPROPOSEDCSV, final String maxBYUSDPROPOSEDCSV, final String averageBYEURACCEPTEDCSV, final String deviationBYEURACCEPTEDCSV,
		final String minBYEURACCEPTEDCSV, final String maxBYEURACCEPTEDCSV) {
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

		WebElement averageBYUSDPROPOSED = null;
		WebElement deviationBYUSDPROPOSED = null;
		WebElement minBYUSDPROPOSED = null;
		WebElement maxBYUSDPROPOSED = null;

		WebElement averageBYEURACCEPTED = null;
		WebElement deviationBYEURACCEPTED = null;
		WebElement minBYEURACCEPTED = null;
		WebElement maxBYEURACCEPTED = null;

		//TABLA Total number of patronages by status
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

		//TABLA Budget of patronages by status and stat

		//PRIMERA FILA
		//PU
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[2]")).getText().equals("USD")) {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
		}
		//DE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[1]")).getText().equals("DENIED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[2]")).getText().equals("EUR")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
		}
		//AU
		else {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[2]/td[6]"));
		}

		//SEGUNDA FILA
		//PU
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[2]")).getText().equals("USD")) {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
		}
		//DE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[1]")).getText().equals("DENIED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[2]")).getText().equals("EUR")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
		}
		//AU
		else {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[3]/td[6]"));
		}

		//TERCERA FILA
		//PU
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[2]")).getText().equals("USD")) {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
		}
		//DE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[1]")).getText().equals("DENIED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[2]")).getText().equals("EUR")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
		}
		//AU
		else {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[4]/td[6]"));
		}

		//CUARTA FILA
		//PU
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[2]")).getText().equals("USD")) {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[6]"));
		}
		//DE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[1]")).getText().equals("DENIED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[2]")).getText().equals("EUR")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[6]"));
		}
		//AU
		else {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[5]/td[6]"));
		}

		//QUINTA FILA
		//PU
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[2]")).getText().equals("USD")) {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[6]"));
		}
		//DE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[1]")).getText().equals("DENIED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[2]")).getText().equals("EUR")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[6]"));
		}
		//AU
		else {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr[6]/td[6]"));
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

		assert averageBYUSDPROPOSED.getText().equals(averageBYUSDPROPOSEDCSV);
		assert deviationBYUSDPROPOSED.getText().equals(deviationBYUSDPROPOSEDCSV);
		assert minBYUSDPROPOSED.getText().equals(minBYUSDPROPOSEDCSV);
		assert maxBYUSDPROPOSED.getText().equals(maxBYUSDPROPOSEDCSV);

		assert averageBYEURACCEPTED.getText().equals(averageBYEURACCEPTEDCSV);
		assert deviationBYEURACCEPTED.getText().equals(deviationBYEURACCEPTEDCSV);
		assert minBYEURACCEPTED.getText().equals(minBYEURACCEPTEDCSV);
		assert maxBYEURACCEPTED.getText().equals(maxBYEURACCEPTEDCSV);

		super.signOut();
	}

}
