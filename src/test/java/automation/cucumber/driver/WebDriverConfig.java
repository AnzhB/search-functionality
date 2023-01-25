package automation.cucumber.driver;
import org.apache.commons.lang3.StringUtils;

public class WebDriverConfig {

    private static WebDriverConfig INSTANCE;

    public static WebDriverConfig getInstance() {

        if (INSTANCE == null)
            INSTANCE = new WebDriverConfig();

        return INSTANCE;
    }

    public static void apply(WebDriverConfig config) {
        INSTANCE = config;
    }

    private String webDriverType;


    public String getWebDriverType() {
        return getValueOrDefault(webDriverType, "chrome");
    }

    private String getValueOrDefault(String value, String defaultValue) {
        return StringUtils.isEmpty(value) ? defaultValue : value;
    }
}