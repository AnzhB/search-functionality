package automation.cucumber.hooks;

import automation.testNG.driver.LocalWebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static automation.testNG.driver.WebDriverType.*;

public class CucumberHook {

    @Before
    public void setupDriver(){
        LocalWebDriverFactory.setWebDriverType(CHROME);
    }


    @After
    public void quitDriver(){
        LocalWebDriverFactory.close();
    }
}
