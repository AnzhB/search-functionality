package automation.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver getDriver(Config config) {

        switch (config != null ? config : Config.CHROME) {

            case SAFARI -> {
                return getSafariDriver();
            }

            case REMOTE -> {
                return getRemoteDriver();
            }

            default -> {
                return getChromeDriver();
            }
        }
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

    private static WebDriver getChromeDriver() {
        return new ChromeDriver();
    }

    private static WebDriver getSafariDriver() {
        return new SafariDriver();
    }

}