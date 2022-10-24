package automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:9515"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
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