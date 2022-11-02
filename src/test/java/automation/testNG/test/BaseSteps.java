package automation.testNG.test;


import automation.testNG.driver.Driver;
import automation.testNG.page.HomePage;
import automation.testNG.page.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseSteps {

    public static WebDriver driver;
    private final String BASE_URL = "http://epam.com";
    protected HomePage homePage = new HomePage();
    protected SearchResultsPage searchResultsPage = new SearchResultsPage();


    @BeforeMethod (alwaysRun = true)
    public void browserSetUp ()  {
//        System.getProperty("webdriver.browser.name", "/Users/Anzhalika_Baradzina/Downloads/chromedriver");
//        driver = new ChromeDriver();
        driver = Driver.getWebDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }


    @AfterMethod (alwaysRun = true)
    public void browserTearDown ()  {
        Driver.close();
    }

}

