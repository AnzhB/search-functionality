package automation.testNG.page;

import automation.testNG.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {


    private static final String SEARCH_ICON = "//div[@class = 'header-search-ui header__control']";
    private static final String SEARCH_INPUT = "//input[@id = 'new_form_search']";
    private static final String SUBMIT_BUTTON = "//button[@class = 'header-search__submit']";
    private static final String SEARCH_PANEL = "//div[@class = 'header-search__panel opened']";

    WebDriver driver = Driver.getWebDriver();

    public void clickSearchIcon () {
       driver.findElement(By.xpath((SEARCH_ICON))).click();
    }

    public void searchForQueryParameter (String queryParameter) {
        driver.findElement(By.xpath(SEARCH_INPUT)).sendKeys(queryParameter);
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public void waitForSearchPanelAppears(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath((SEARCH_PANEL))));
    }

}
