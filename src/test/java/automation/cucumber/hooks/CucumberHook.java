package automation.cucumber.hooks;

import automation.cucumber.driver.LocalWebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static automation.cucumber.driver.WebDriverType.CHROME;


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
