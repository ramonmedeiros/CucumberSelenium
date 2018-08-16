package cucumber.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "feature/GoogleSearch.feature", glue = "cucumber.test", plugin = { "html:target/myreport",
		"pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt" }, monochrome = true, dryRun = false)
public class GoogleSearchTeste {

	public static ChromeDriver driver;

	public static ChromeDriver getBrowser() {
		return driver;
	}

	@BeforeClass
	public static void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
