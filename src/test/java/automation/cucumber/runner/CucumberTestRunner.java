package automation.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@run",
        glue = "automation",
        features ="src/test/java/resources/com/cucumber/Search.feature"

)
public class CucumberTestRunner {
}
