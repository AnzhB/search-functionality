package automation.driver;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver webDriver;
    private static Config config;

    public static void setConfig(Config config) {
        Driver.config = config;
    }

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = DriverManager.getDriver(config);
        }
        return webDriver;
    }

    public static void setDriver(WebDriver webDriver) {
        Driver.webDriver = webDriver;
    }

    public static void close() {
        webDriver.quit();
        Driver.webDriver = null;
    }
}
