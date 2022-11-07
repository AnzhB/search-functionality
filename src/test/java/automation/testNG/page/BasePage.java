package automation.testNG.page;

import automation.testNG.driver.LocalWebDriverFactory;
import org.openqa.selenium.WebDriver;

import static automation.testNG.driver.WebDriverType.CHROME;

public abstract class BasePage
{
    public WebDriver driver = new LocalWebDriverFactory().create(CHROME);


}
