package automation.cucumber.driver;

import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {

    WebDriver create(WebDriverType webDriverType);


}


