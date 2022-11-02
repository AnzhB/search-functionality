package automation.testNG.page;

import automation.testNG.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static automation.testNG.model.enams.Messages.SEARCH_RETURNED_NO_RESULTS;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

public class SearchResultsPage {

    WebDriver driver = Driver.getWebDriver();

    List<WebElement> searchResults = driver.findElements(By.xpath("//article[@class = 'search-results__item']"));
    private static final String FIRST_RESULT = "//div[@class = 'search-results__items']/article[1]";

    private static final String EMPTY_RESULT_ERROR = "//div[@class = 'search-results__exception-message search-results--empty-result']";

    public void verifyFirstSearchResult() {
        Assert.assertThat(driver.findElement(By.xpath(FIRST_RESULT))
                .getText(), containsString("testing"));
    }

    public void verifyEmptySearchResults() {
        Assert.assertTrue("Search results are not empty", driver.findElement(By.xpath(EMPTY_RESULT_ERROR)).isDisplayed());
        assertThat(driver.findElement(By.xpath(EMPTY_RESULT_ERROR)).getText(), is(equalTo(SEARCH_RETURNED_NO_RESULTS.getValue())));
}

}
