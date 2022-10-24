package automation.base;

import java.util.function.Supplier;



public class Constants {

    public static final Supplier<String> BROWSER = () -> System.getProperty("webdriver.browser.name");
    public static final Supplier<String> HOST = () -> System.getProperty("webdriver.host");

    public static final String BASE_URL = "https://www.epam.com/";


    public static void onStart() {
            if (BROWSER.get() == null && HOST.get() == null) {
               System.getProperty("webdriver.browser.name", "/Users/Anzhalika_Baradzina/Downloads/chromedriver");
        }
    }
}
