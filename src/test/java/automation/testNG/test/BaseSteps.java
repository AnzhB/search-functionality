package automation.testNG.test;

import automation.testNG.driver.LocalWebDriverFactory;
import automation.testNG.page.HomePage;
import automation.testNG.page.SearchResultsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import java.util.logging.Logger;
import static automation.testNG.driver.WebDriverType.*;


public class BaseSteps {

    private static final Logger LOGGER = Logger.getLogger(BaseSteps.class.getName());
    protected HomePage homePage = new HomePage();
    protected SearchResultsPage searchResultsPage = new SearchResultsPage();

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp ()  {
        LocalWebDriverFactory.setWebDriverType(REMOTE);
        LOGGER.info("web driver type was selected");

    }

    @AfterClass(alwaysRun = true)
    public void browserTearDown () {
        LocalWebDriverFactory.close();
        LOGGER.info("test suite finished");
    }

}

