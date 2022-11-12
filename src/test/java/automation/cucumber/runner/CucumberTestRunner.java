package automation.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/SystemTestReports/html",
                "json:target/SystemTestReports/json/report.json",
                "junit:target/SystemTestReports/junit/report.xml",
        },

        dryRun = false,
        monochrome = true,
        tags = "@run and @smoke",
        glue = "automation",
        features ="src/test/java/resources/com/cucumber/Search.feature"

)
public class CucumberTestRunner {
}
