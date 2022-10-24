package automation;

//import org.junit.Test;
import automation.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static automation.base.Constants.*;
import static automation.utils.RandomNameGenerator.*;

public class SearchTestsTestng {

    WebDriver driver = Driver.getWebDriver();

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp() {

        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test(description = "Search results test")
    public void commonSearchTermResultsNotEmpty() {
        WebElement searchButton = driver.findElement(By.xpath(("//div[@class = 'header-search-ui header__control']")));
        searchButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(("//div[@class = 'header-search__panel opened']"))));
        WebElement inputField = driver.findElement(By.xpath(("//input[@id = 'new_form_search']")));
        inputField.sendKeys("Testing approach");
        WebElement findButton = driver.findElement(By.xpath(("//button[@class = 'header-search__submit']")));
        findButton.click();
        List<WebElement> searchResults = driver.findElements(By.xpath("//article[@class = 'search-results__item']"));
        Assert.assertTrue("Search results are empty", searchResults.size() > 0);
    }

    @Test(description = "Empty search results test")
    public void searchResultsAreEmpty() {
        WebElement searchButton = driver.findElement(By.xpath(("//div[@class = 'header-search-ui header__control']")));
        searchButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(("//div[@class = 'header-search__panel opened']"))));
        WebElement inputField = driver.findElement(By.xpath(("//input[@id = 'new_form_search']")));
        inputField.sendKeys(generateRandomText(10));
        WebElement findButton = driver.findElement(By.xpath(("//button[@class = 'header-search__submit']")));
        findButton.click();
        WebElement emptyResultsError = driver.findElement(
                By.xpath("//div[@class = 'search-results__exception-message search-results--empty-result']"));
        Assert.assertTrue("Search results are empty", emptyResultsError.isDisplayed());

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        Driver.close();
    }

}
