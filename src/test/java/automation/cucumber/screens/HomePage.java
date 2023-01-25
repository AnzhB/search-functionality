package automation.cucumber.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

import static automation.cucumber.util.Constants.BASE_URL;


public class HomePage extends BasePage {

    private static final String SEARCH_ICON = "//div[@class = 'header-search-ui header__control']";
    private static final String SEARCH_INPUT = "//input[@id = 'new_form_search']";
    private static final String SUBMIT_BUTTON = "//button[@class = 'header-search__submit']";
    private static final String SEARCH_PANEL = "//div[@class = 'header-search__panel opened']";
    private static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());

    public void openPage() {
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        LOGGER.info("open URL: " + BASE_URL);
    }


    public void clickSearchIcon () {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath((SEARCH_ICON))));
       driver.findElement(By.xpath((SEARCH_ICON))).click();
       LOGGER.info("search icon was clicked");
    }

    public void searchForQueryParameter (String queryParameter) {
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(queryParameter);
        LOGGER.info("search input was populated");
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
        LOGGER.info("submit button was clicked");
    }

    public void waitForSearchPanelAppears(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath((SEARCH_PANEL))));
        LOGGER.info("search panel appeared");
    }

}
