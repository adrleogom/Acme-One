
package acme.testing.administrator.administratorDashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class AdministratorAdministratorDashboardShowTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/administrator-dashboard/show.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)

	public void administratorAdministratorDashboardShowTest(final String totalNumberOfComponentsByCurrency, final String totalNumberOfToolsByCurrency, final String totalBYACCEPTEDSTATUS, final String totalBYDENIEDSTATUS, final String totalBYPROPOSEDSTATUS,
		final String averageBYUSDACCEPTEDCSV, final String deviationBYUSDACCEPTEDCSV, final String minBYUSDACCEPTEDCSV, final String maxBYUSDACCEPTEDCSV, final String averageBYEURDENIEDCSV, final String deviationBYEURDENIEDCSV,
		final String minBYEURDENIEDCSV, final String maxBYEURDENIEDCSV, final String averageBYEURPROPOSEDCSV, final String deviationBYEURPROPOSEDCSV, final String minBYEURPROPOSEDCSV, final String maxBYEURPROPOSEDCSV, final String toolsEURaverageCSV,
		final String toolsEURdeviationCSV, final String toolsEURminCSV, final String toolsEURmaxCSV, final String toolsGBPaverageCSV, final String toolsGBPdeviationCSV, final String toolsGBPminCSV, final String toolsGBPmaxCSV,
		final String toolsUSDaverageCSV, final String toolsUSDdeviationCSV, final String toolsUSDminCSV, final String toolsUSDmaxCSV, final String componentsEURTECH1averageCSV, final String componentsEURTECH1deviationCSV,
		final String componentsEURTECH1minCSV, final String componentsEURTECH1maxCSV, final String componentsGBPTECH5averageCSV, final String componentsGBPTECH5deviationCSV, final String componentsGBPTECH5minCSV, final String componentsGBPTECH5maxCSV,
		final String componentsGBPTECH6averageCSV, final String componentsGBPTECH6deviationCSV, final String componentsGBPTECH6minCSV, final String componentsGBPTECH6maxCSV, final String componentsUSDTECH7averageCSV,
		final String componentsUSDTECH7deviationCSV, final String componentsUSDTECH7minCSV, final String componentsUSDTECH7maxCSV, final String componentsGBPTECH9averageCSV, final String componentsGBPTECH9deviationCSV,
		final String componentsGBPTECH9minCSV, final String componentsGBPTECH9maxCSV, final String componentsEURTECH4averageCSV, final String componentsEURTECH4deviationCSV, final String componentsEURTECH4minCSV, final String componentsEURTECH4maxCSV,
		final String componentsEURTECH11averageCSV, final String componentsEURTECH11deviationCSV, final String componentsEURTECH11maxCSV, final String componentsEURTECH11minCSV, final String componentsEURTECH19averageCSV,
		final String componentsEURTECH19deviationCSV, final String componentsEURTECH19maxCSV, final String componentsEURTECH19minCSV, final String componentsEURTECH17averageCSV, final String componentsEURTECH17deviationCSV,
		final String componentsEURTECH17maxCSV, final String componentsEURTECH17minCSV, final String componentsEURTECH15averageCSV, final String componentsEURTECH15deviationCSV, final String componentsEURTECH15maxCSV,
		final String componentsEURTECH15minCSV, final String componentsEURTECH13averageCSV, final String componentsEURTECH13deviationCSV, final String componentsEURTECH13maxCSV, final String componentsEURTECH13minCSV, final String averageBYEURACCEPTEDCSV,
		final String deviationBYEURACCEPTEDCSV, final String maxBYEURACCEPTEDCSV, final String minBYEURACCEPTEDCSV, final String averageBYUSDPROPOSEDCSV, final String deviationBYUSDPROPOSEDCSV, final String maxBYUSDPROPOSEDCSV,
		final String minBYUSDPROPOSEDCSV) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");

		final BrowserDriver driver = super.getDriver();

		final WebElement totalNumberOfComponents = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr/td"));
		final WebElement totalNumberOfTools = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr/td"));

		WebElement totalBYACCEPTED;
		WebElement totalBYDENIED;
		WebElement totalBYPROPOSED;

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

		WebElement averageBYEURACCEPTED = null;
		WebElement deviationBYEURACCEPTED = null;
		WebElement minBYEURACCEPTED = null;
		WebElement maxBYEURACCEPTED = null;

		WebElement averageBYUSDPROPOSED = null;
		WebElement deviationBYUSDPROPOSED = null;
		WebElement minBYUSDPROPOSED = null;
		WebElement maxBYUSDPROPOSED = null;

		WebElement toolsGBPaverage = null;
		WebElement toolsGBPdeviation = null;
		WebElement toolsGBPmin = null;
		WebElement toolsGBPmax = null;

		WebElement toolsUSDaverage = null;
		WebElement toolsUSDdeviation = null;
		WebElement toolsUSDmin = null;
		WebElement toolsUSDmax = null;

		WebElement toolsEURaverage = null;
		WebElement toolsEURdeviation = null;
		WebElement toolsEURmin = null;
		WebElement toolsEURmax = null;

		WebElement componentsTECH1average = null;
		WebElement componentsTECH1deviation = null;
		WebElement componentsTECH1min = null;
		WebElement componentsTECH1max = null;

		WebElement componentsTECH5average = null;
		WebElement componentsTECH5deviation = null;
		WebElement componentsTECH5min = null;
		WebElement componentsTECH5max = null;

		WebElement componentsTECH6average = null;
		WebElement componentsTECH6deviation = null;
		WebElement componentsTECH6min = null;
		WebElement componentsTECH6max = null;

		WebElement componentsTECH7average = null;
		WebElement componentsTECH7deviation = null;
		WebElement componentsTECH7min = null;
		WebElement componentsTECH7max = null;

		WebElement componentsTECH9average = null;
		WebElement componentsTECH9deviation = null;
		WebElement componentsTECH9min = null;
		WebElement componentsTECH9max = null;

		WebElement componentsTECH4average = null;
		WebElement componentsTECH4deviation = null;
		WebElement componentsTECH4min = null;
		WebElement componentsTECH4max = null;

		WebElement componentsTECH11average = null;
		WebElement componentsTECH11deviation = null;
		WebElement componentsTECH11min = null;
		WebElement componentsTECH11max = null;

		WebElement componentsTECH19average = null;
		WebElement componentsTECH19deviation = null;
		WebElement componentsTECH19max = null;
		WebElement componentsTECH19min = null;

		WebElement componentsTECH17average = null;
		WebElement componentsTECH17deviation = null;
		WebElement componentsTECH17max = null;
		WebElement componentsTECH17min = null;

		WebElement componentsTECH15average = null;
		WebElement componentsTECH15deviation = null;
		WebElement componentsTECH15max = null;
		WebElement componentsTECH15min = null;

		WebElement componentsTECH13average = null;
		WebElement componentsTECH13deviation = null;
		WebElement componentsTECH13max = null;
		WebElement componentsTECH13min = null;

		//TABLA Total number of patronages by status
		//FILA UNO ACCEPTED
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[2]/td[1]")).getText().equals("ACCEPTED")) {
			totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[2]/td[2]"));
			//FILA DOS DENIED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[1]")).getText().equals("DENIED")) {
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[2]"));
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[4]/td[2]"));
			}
			//FIA DOS PROPOSED
			else {
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[2]"));
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[4]/td[2]"));
			}
		}
		//FILA UNO DENIED
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[2]/td[1]")).getText().equals("DENIED")) {
			totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[2]/td[2]"));
			//FILA DOS ACCEPTED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[2]"));
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[4]/td[2]"));
			}
			//FILA DOS PROPOSED
			else {
				totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[2]"));
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[4]/td[2]"));
			}
		}
		//FILA UNO PROPOSED
		else {
			totalBYPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[2]/td[2]"));
			//FILA DOS ACCEPTED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[2]"));
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[4]/td[2]"));
			}
			//FILA DOS DENID
			else {
				totalBYDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[3]/td[2]"));
				totalBYACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[3]/tbody/tr[4]/td[2]"));
			}
		}

		//TABLA Budget of patronages by status and stat

		//PRIMERA FILA
		//D
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[1]")).getText().equals("DENIED")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
		}
		//AU
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[2]")).getText().equals("USD")) {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
		}
		//PU
		else {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
		}

		//SEGUNDA FILA
		//D
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[1]")).getText().equals("DENIED")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
		}
		//AU
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[2]")).getText().equals("USD")) {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
		}
		//PU
		else {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
		}

		//TERCERA FILA
		//D
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[1]")).getText().equals("DENIED")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
		}
		//AU
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[2]")).getText().equals("USD")) {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
		}
		//PU
		else {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
		}

		//CUARTA FILA
		//D
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[1]")).getText().equals("DENIED")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[6]"));
		}
		//AU
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[2]")).getText().equals("USD")) {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[6]"));
		}
		//PU
		else {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[5]/td[6]"));
		}

		//QUINTA FILA
		//D
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[1]")).getText().equals("DENIED")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[6]"));
		}
		//AE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[2]")).getText().equals("EUR")) {
			averageBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[3]"));
			deviationBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[4]"));
			minBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[5]"));
			maxBYEURACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[6]"));
		}
		//PE
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[1]")).getText().equals("PROPOSED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[2]")).getText().equals("EUR")) {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[6]"));
		}
		//AU
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[1]")).getText().equals("ACCEPTED") && driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[2]")).getText().equals("USD")) {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[6]"));
		}
		//PU
		else {
			averageBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[3]"));
			deviationBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[4]"));
			minBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[5]"));
			maxBYUSDPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[6]/td[6]"));
		}
		//TABLA STATS OF TOOL PRICES
		//PRIMERA FILA
		//EUR
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[1]")).getText().equals("EUR")) {
			toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[2]"));
			toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[3]"));
			toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[4]"));
			toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[5]"));
		}
		//GBP
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[1]")).getText().equals("GBP")) {
			toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[2]"));
			toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[3]"));
			toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[4]"));
			toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[5]"));
		}
		//USD
		else {
			toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[2]"));
			toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[3]"));
			toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[4]"));
			toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[5]"));
		}

		//SEGUNDA FILA
		//EUR
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[1]")).getText().equals("EUR")) {
			toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
			toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
			toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
			toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));
		}
		//GBP
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[1]")).getText().equals("GBP")) {
			toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
			toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
			toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
			toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));
		}
		//USD
		else {
			toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
			toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
			toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
			toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));
		}

		//TERCERA FILA
		//EUR
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[1]")).getText().equals("EUR")) {
			toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
			toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
			toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
			toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
		}
		//GBP
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[1]")).getText().equals("GBP")) {
			toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
			toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
			toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
			toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
		}
		//USD
		else {
			toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
			toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
			toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
			toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
		}

		//TABLA STATS OF COMPONENT PRICES

		//PRIMERA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));
		}

		//SEGUNDA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));
		}

		//TERCERA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));
		}

		//CUARTA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));
		}

		//QUINTA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));
		}

		//SEXTA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));
		}

		//SEPTIMA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}

		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[8]/td[6]"));
		}

		//OCTAVA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[9]/td[6]"));
		}

		//NOVENA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[10]/td[6]"));
		}

		//DECIMA FILA
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[11]/td[6]"));
		}

		//FILA ONCE
		//TECH 1
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracteres Tech 1 con 100 caracte")) {
			componentsTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 11
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 11")) {
			componentsTECH11average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH11deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH11min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH11max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 5
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 5")) {
			componentsTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 6
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 6")) {
			componentsTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 19
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 19")) {
			componentsTECH19average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH19deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH19min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH19max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 17
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 17")) {
			componentsTECH17average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH17deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH17min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH17max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 15
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 15")) {
			componentsTECH15average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH15deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH15min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH15max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 7
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 7")) {
			componentsTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 9
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 9")) {
			componentsTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 4
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[2]")).getText().equals("Tech 4")) {
			componentsTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}
		//TECH 13
		else {
			componentsTECH13average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[3]"));
			componentsTECH13deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[4]"));
			componentsTECH13min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[5]"));
			componentsTECH13max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[12]/td[6]"));
		}

		assert totalNumberOfComponents.getText().equals(totalNumberOfComponentsByCurrency);
		assert totalNumberOfTools.getText().equals(totalNumberOfToolsByCurrency);

		assert totalBYACCEPTED.getText().equals(totalBYACCEPTEDSTATUS);
		assert totalBYDENIED.getText().equals(totalBYDENIEDSTATUS);
		assert totalBYPROPOSED.getText().equals(totalBYPROPOSEDSTATUS);

		assert averageBYUSDACCEPTED.getText().equals(averageBYUSDACCEPTEDCSV);
		assert deviationBYUSDACCEPTED.getText().equals(deviationBYUSDACCEPTEDCSV);
		assert minBYUSDACCEPTED.getText().equals(minBYUSDACCEPTEDCSV);
		assert maxBYUSDACCEPTED.getText().equals(maxBYUSDACCEPTEDCSV);

		assert averageBYEURDENIED.getText().equals(averageBYEURDENIEDCSV);
		assert deviationBYEURDENIED.getText().equals(deviationBYEURDENIEDCSV);
		assert minBYEURDENIED.getText().equals(minBYEURDENIEDCSV);
		assert maxBYEURDENIED.getText().equals(maxBYEURDENIEDCSV);

		assert averageBYEURPROPOSED.getText().equals(averageBYEURPROPOSEDCSV);
		assert deviationBYEURPROPOSED.getText().equals(deviationBYEURPROPOSEDCSV);
		assert minBYEURPROPOSED.getText().equals(minBYEURPROPOSEDCSV);
		assert maxBYEURPROPOSED.getText().equals(maxBYEURPROPOSEDCSV);

		assert averageBYEURACCEPTED.getText().equals(averageBYEURACCEPTEDCSV);
		assert deviationBYEURACCEPTED.getText().equals(deviationBYEURACCEPTEDCSV);
		assert minBYEURACCEPTED.getText().equals(minBYEURACCEPTEDCSV);
		assert maxBYEURACCEPTED.getText().equals(maxBYEURACCEPTEDCSV);

		assert averageBYUSDPROPOSED.getText().equals(averageBYUSDPROPOSEDCSV);
		assert deviationBYUSDPROPOSED.getText().equals(deviationBYUSDPROPOSEDCSV);
		assert minBYUSDPROPOSED.getText().equals(minBYUSDPROPOSEDCSV);
		assert maxBYUSDPROPOSED.getText().equals(maxBYUSDPROPOSEDCSV);

		assert toolsEURaverage.getText().equals(toolsEURaverageCSV);
		assert toolsEURdeviation.getText().equals(toolsEURdeviationCSV);
		assert toolsEURmin.getText().equals(toolsEURminCSV);
		assert toolsEURmax.getText().equals(toolsEURmaxCSV);

		assert toolsGBPaverage.getText().equals(toolsGBPaverageCSV);
		assert toolsGBPdeviation.getText().equals(toolsGBPdeviationCSV);
		assert toolsGBPmin.getText().equals(toolsGBPminCSV);
		assert toolsGBPmax.getText().equals(toolsGBPmaxCSV);

		assert toolsUSDaverage.getText().equals(toolsUSDaverageCSV);
		assert toolsUSDdeviation.getText().equals(toolsUSDdeviationCSV);
		assert toolsUSDmin.getText().equals(toolsUSDminCSV);
		assert toolsUSDmax.getText().equals(toolsUSDmaxCSV);

		assert componentsTECH1average.getText().equals(componentsEURTECH1averageCSV);
		assert componentsTECH1deviation.getText().equals(componentsEURTECH1deviationCSV);
		assert componentsTECH1min.getText().equals(componentsEURTECH1minCSV);
		assert componentsTECH1max.getText().equals(componentsEURTECH1maxCSV);

		assert componentsTECH5average.getText().equals(componentsGBPTECH5averageCSV);
		assert componentsTECH5deviation.getText().equals(componentsGBPTECH5deviationCSV);
		assert componentsTECH5min.getText().equals(componentsGBPTECH5minCSV);
		assert componentsTECH5max.getText().equals(componentsGBPTECH5maxCSV);

		assert componentsTECH6average.getText().equals(componentsGBPTECH6averageCSV);
		assert componentsTECH6deviation.getText().equals(componentsGBPTECH6deviationCSV);
		assert componentsTECH6min.getText().equals(componentsGBPTECH6minCSV);
		assert componentsTECH6max.getText().equals(componentsGBPTECH6maxCSV);

		assert componentsTECH7average.getText().equals(componentsUSDTECH7averageCSV);
		assert componentsTECH7deviation.getText().equals(componentsUSDTECH7deviationCSV);
		assert componentsTECH7min.getText().equals(componentsUSDTECH7minCSV);
		assert componentsTECH7max.getText().equals(componentsUSDTECH7maxCSV);

		assert componentsTECH9average.getText().equals(componentsGBPTECH9averageCSV);
		assert componentsTECH9deviation.getText().equals(componentsGBPTECH9deviationCSV);
		assert componentsTECH9min.getText().equals(componentsGBPTECH9minCSV);
		assert componentsTECH9max.getText().equals(componentsGBPTECH9maxCSV);

		assert componentsTECH4average.getText().equals(componentsEURTECH4averageCSV);
		assert componentsTECH4deviation.getText().equals(componentsEURTECH4deviationCSV);
		assert componentsTECH4min.getText().equals(componentsEURTECH4minCSV);
		assert componentsTECH4max.getText().equals(componentsEURTECH4maxCSV);

		assert componentsTECH11average.getText().equals(componentsEURTECH11averageCSV);
		assert componentsTECH11deviation.getText().equals(componentsEURTECH11deviationCSV);
		assert componentsTECH11min.getText().equals(componentsEURTECH11minCSV);
		assert componentsTECH11max.getText().equals(componentsEURTECH11maxCSV);

		assert componentsTECH19average.getText().equals(componentsEURTECH19averageCSV);
		assert componentsTECH19deviation.getText().equals(componentsEURTECH19deviationCSV);
		assert componentsTECH19min.getText().equals(componentsEURTECH19minCSV);
		assert componentsTECH19max.getText().equals(componentsEURTECH19maxCSV);

		assert componentsTECH17average.getText().equals(componentsEURTECH17averageCSV);
		assert componentsTECH17deviation.getText().equals(componentsEURTECH17deviationCSV);
		assert componentsTECH17min.getText().equals(componentsEURTECH17minCSV);
		assert componentsTECH17max.getText().equals(componentsEURTECH17maxCSV);

		assert componentsTECH15average.getText().equals(componentsEURTECH15averageCSV);
		assert componentsTECH15deviation.getText().equals(componentsEURTECH15deviationCSV);
		assert componentsTECH15min.getText().equals(componentsEURTECH15minCSV);
		assert componentsTECH15max.getText().equals(componentsEURTECH15maxCSV);

		assert componentsTECH13average.getText().equals(componentsEURTECH13averageCSV);
		assert componentsTECH13deviation.getText().equals(componentsEURTECH13deviationCSV);
		assert componentsTECH13min.getText().equals(componentsEURTECH13minCSV);
		assert componentsTECH13max.getText().equals(componentsEURTECH13maxCSV);
	}
}
