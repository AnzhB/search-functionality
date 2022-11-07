package automation.testNG.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalWebDriverFactory implements WebDriverFactory {
    private static WebDriver driver;
    private static WebDriverType webDriverType;

    public LocalWebDriverFactory() {
    }

    public static void setWebDriverType(WebDriverType webDriverType) {
        LocalWebDriverFactory.webDriverType = webDriverType;
    }


    @Override
    public  WebDriver create(WebDriverType webDriverType) {
        if (driver == null) {
            switch (webDriverType) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;
                case SAFARI:
                    driver = new SafariDriver();
                    break;
                case REMOTE:
                    driver = getRemoteDriver();

                default:
                    throw new RuntimeException("Unsupported browser: " + webDriverType);
            }
        }
        return driver;
    }

    private static WebDriver getRemoteDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.MAC);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.201.14:4444"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    public static void close() {
        driver.quit();
        LocalWebDriverFactory.driver = null;
    }

}