package automation.cucumber.screens;


import automation.cucumber.driver.LocalWebDriverFactory;
import org.openqa.selenium.WebDriver;

import static automation.cucumber.driver.WebDriverType.CHROME;


public abstract class BasePage
{
    public WebDriver driver = new LocalWebDriverFactory().create(CHROME);
}
