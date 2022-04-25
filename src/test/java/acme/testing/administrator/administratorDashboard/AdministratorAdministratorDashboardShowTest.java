
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
		final String componentsGBPTECH9minCSV, final String componentsGBPTECH9maxCSV, final String componentsEURTECH4averageCSV, final String componentsEURTECH4deviationCSV, final String componentsEURTECH4minCSV, final String componentsEURTECH4maxCSV) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Dashboard");

		final BrowserDriver driver = super.getDriver();

		final WebElement totalNumberOfComponents = driver.locateOne(By.xpath("/html/body/div[2]/div/table[1]/tbody/tr/td"));
		final WebElement totalNumberOfTools = driver.locateOne(By.xpath("/html/body/div[2]/div/table[2]/tbody/tr/td	"));
		WebElement totalBYACCEPTED;
		WebElement totalBYDENIED;
		WebElement totalBYPROPOSED;
		WebElement averageBYUSDACCEPTED;
		WebElement deviationBYUSDACCEPTED;
		WebElement minBYUSDACCEPTED;
		WebElement maxBYUSDACCEPTED;
		WebElement averageBYEURDENIED;
		WebElement deviationBYEURDENIED;
		WebElement minBYEURDENIED;
		WebElement maxBYEURDENIED;
		WebElement averageBYEURPROPOSED;
		WebElement deviationBYEURPROPOSED;
		WebElement minBYEURPROPOSED;
		WebElement maxBYEURPROPOSED;
		WebElement toolsGBPaverage;
		WebElement toolsGBPdeviation;
		WebElement toolsGBPmin;
		WebElement toolsGBPmax;
		WebElement toolsUSDaverage;
		WebElement toolsUSDdeviation;
		WebElement toolsUSDmin;
		WebElement toolsUSDmax;
		WebElement toolsEURaverage;
		WebElement toolsEURdeviation;
		WebElement toolsEURmin;
		WebElement toolsEURmax;
		final WebElement componentsEURTECH1average;
		final WebElement componentsEURTECH1deviation;
		final WebElement componentsEURTECH1min;
		final WebElement componentsEURTECH1max;
		final WebElement componentsGBPTECH5average;
		final WebElement componentsGBPTECH5deviation;
		final WebElement componentsGBPTECH5min;
		final WebElement componentsGBPTECH5max;
		final WebElement componentsGBPTECH6average;
		final WebElement componentsGBPTECH6deviation;
		final WebElement componentsGBPTECH6min;
		final WebElement componentsGBPTECH6max;
		final WebElement componentsUSDTECH7average;
		final WebElement componentsUSDTECH7deviation;
		final WebElement componentsUSDTECH7min;
		final WebElement componentsUSDTECH7max;
		final WebElement componentsGBPTECH9average;
		final WebElement componentsGBPTECH9deviation;
		final WebElement componentsGBPTECH9min;
		final WebElement componentsGBPTECH9max;
		final WebElement componentsEURTECH4average;
		final WebElement componentsEURTECH4deviation;
		final WebElement componentsEURTECH4min;
		final WebElement componentsEURTECH4max;

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

		//NEW TABLA

		//PRIMERA FILA ACCEPTED
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[1]")).getText().equals("ACCEPTED")) {
			averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
			//SEGUNDA FILA DENIED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[1]")).getText().equals("DENIED")) {
				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));

				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
			}
			//SEGUNDA FILA PROPOSED
			else {
				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));

				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
			}
		}
		//PRIMERA FILA DENIED
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[1]")).getText().equals("DENIED")) {
			averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
			//SEGUNDA FILA ACCEPTED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));

				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
			}
			//SEGUNDA FILA PROPOSED
			else {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));

				averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
				deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
				minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
				maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
			}
		}
		//PRIMERA FILA PROPOSED
		else {
			averageBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[3]"));
			deviationBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[4]"));
			minBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[5]"));
			maxBYEURPROPOSED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[2]/td[6]"));
			//SEGUNDA FILA ACCEPTED
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[1]")).getText().equals("ACCEPTED")) {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));

				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));
			}
			//SEGUNDA FILA DENIED
			else {
				averageBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[3]"));
				deviationBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[4]"));
				minBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[5]"));
				maxBYUSDACCEPTED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[4]/td[6]"));

				averageBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[3]"));
				deviationBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[4]"));
				minBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[5]"));
				maxBYEURDENIED = driver.locateOne(By.xpath("/html/body/div[2]/div/table[4]/tbody/tr[3]/td[6]"));
			}
		}

		//NEW TABLE

		//PRIMERA FILA GBP
		if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[1]")).getText().equals("GBP")) {
			toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[2]"));
			toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[3]"));
			toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[4]"));
			toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[5]"));
			//SEGUNDA FILA EUR
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[1]")).getText().equals("EUR")) {
				toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
				toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
				toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
				toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));

				toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
				toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
				toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
				toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
			}
			//SEGUNDA FILA USD
			else {
				toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
				toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
				toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
				toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));

				toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
				toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
				toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
				toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
			}
		}
		//PRIMERA FILA EUR
		else if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[1]")).getText().equals("EUR")) {
			toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[2]"));
			toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[3]"));
			toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[4]"));
			toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[5]"));
			//SEGUNDA FILA GBP
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[1]")).getText().equals("GBP")) {
				toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
				toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
				toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
				toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));

				toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
				toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
				toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
				toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
			}
			//SEGUNDA FILA USD
			else {
				toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
				toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
				toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
				toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));

				toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
				toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
				toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
				toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
			}
		}
		//PRIMERA FILA USD
		else {
			toolsUSDaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[2]"));
			toolsUSDdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[3]"));
			toolsUSDmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[4]"));
			toolsUSDmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[2]/td[5]"));
			//SEGUNDA FILA GBP
			if (driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[1]")).getText().equals("GBP")) {
				toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
				toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
				toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
				toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));

				toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
				toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
				toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
				toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));
			}
			//SEGUNDA FILA EUR
			else {
				toolsGBPaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[2]"));
				toolsGBPdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[3]"));
				toolsGBPmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[4]"));
				toolsGBPmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[4]/td[5]"));

				toolsEURaverage = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[2]"));
				toolsEURdeviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[3]"));
				toolsEURmin = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[4]"));
				toolsEURmax = driver.locateOne(By.xpath("/html/body/div[2]/div/table[5]/tbody/tr[3]/td[5]"));
			}
		}

		//NEW TABLE

		componentsEURTECH1average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[3]"));
		componentsEURTECH1deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[4]"));
		componentsEURTECH1min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[5]"));
		componentsEURTECH1max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[2]/td[6]"));

		componentsGBPTECH5average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[3]"));
		componentsGBPTECH5deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[4]"));
		componentsGBPTECH5min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[5]"));
		componentsGBPTECH5max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[3]/td[6]"));

		componentsGBPTECH6average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[3]"));
		componentsGBPTECH6deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[4]"));
		componentsGBPTECH6min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[5]"));
		componentsGBPTECH6max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[4]/td[6]"));

		componentsUSDTECH7average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[3]"));
		componentsUSDTECH7deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[4]"));
		componentsUSDTECH7min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[5]"));
		componentsUSDTECH7max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[5]/td[6]"));

		componentsGBPTECH9average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[3]"));
		componentsGBPTECH9deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[4]"));
		componentsGBPTECH9min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[5]"));
		componentsGBPTECH9max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[6]/td[6]"));

		componentsEURTECH4average = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[3]"));
		componentsEURTECH4deviation = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[4]"));
		componentsEURTECH4min = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[5]"));
		componentsEURTECH4max = driver.locateOne(By.xpath("/html/body/div[2]/div/table[6]/tbody/tr[7]/td[6]"));

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

		assert componentsEURTECH1average.getText().equals(componentsEURTECH1averageCSV);
		assert componentsEURTECH1deviation.getText().equals(componentsEURTECH1deviationCSV);
		assert componentsEURTECH1min.getText().equals(componentsEURTECH1minCSV);
		assert componentsEURTECH1max.getText().equals(componentsEURTECH1maxCSV);

		assert componentsGBPTECH5average.getText().equals(componentsGBPTECH5averageCSV);
		assert componentsGBPTECH5deviation.getText().equals(componentsGBPTECH5deviationCSV);
		assert componentsGBPTECH5min.getText().equals(componentsGBPTECH5minCSV);
		assert componentsGBPTECH5max.getText().equals(componentsGBPTECH5maxCSV);

		assert componentsGBPTECH6average.getText().equals(componentsGBPTECH6averageCSV);
		assert componentsGBPTECH6deviation.getText().equals(componentsGBPTECH6deviationCSV);
		assert componentsGBPTECH6min.getText().equals(componentsGBPTECH6minCSV);
		assert componentsGBPTECH6max.getText().equals(componentsGBPTECH6maxCSV);

		assert componentsUSDTECH7average.getText().equals(componentsUSDTECH7averageCSV);
		assert componentsUSDTECH7deviation.getText().equals(componentsUSDTECH7deviationCSV);
		assert componentsUSDTECH7min.getText().equals(componentsUSDTECH7minCSV);
		assert componentsUSDTECH7max.getText().equals(componentsUSDTECH7maxCSV);

		assert componentsGBPTECH9average.getText().equals(componentsGBPTECH9averageCSV);
		assert componentsGBPTECH9deviation.getText().equals(componentsGBPTECH9deviationCSV);
		assert componentsGBPTECH9min.getText().equals(componentsGBPTECH9minCSV);
		assert componentsGBPTECH9max.getText().equals(componentsGBPTECH9maxCSV);

		assert componentsEURTECH4average.getText().equals(componentsEURTECH4averageCSV);
		assert componentsEURTECH4deviation.getText().equals(componentsEURTECH4deviationCSV);
		assert componentsEURTECH4min.getText().equals(componentsEURTECH4minCSV);
		assert componentsEURTECH4max.getText().equals(componentsEURTECH4maxCSV);
	}
}
