package cucumber.test;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = "feature/GoogleSearch.feature",
				glue = "cucumber.test",
				plugin = {"html:target/myreport","pretty", "json:target/cucumber-reports/Cucumber.json",
						"junit:target/cucumber-reports/Cucumber.xml",
						"html:target/cucumber-reports",
		                "html:target/cucumber-reports/cucumber-pretty",
		                "json:target/cucumber-reports/CucumberTestReport.json",
		                "rerun:target/cucumber-reports/rerun.txt"},	
				monochrome = true, 
				dryRun = false)
public class GoogleSearchTeste {
}
