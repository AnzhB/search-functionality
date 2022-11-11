package automation.testNG.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static automation.testNG.model.enams.Messages.SEARCH_RETURNED_NO_RESULTS;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.logging.Logger;

public class SearchResultsPage extends BasePage  {

    private static final Logger LOGGER = Logger.getLogger(SearchResultsPage.class.getName());

    List<WebElement> searchResults = driver.findElements(By.xpath("//article[@class = 'search-results__item']"));
    private static final String FIRST_RESULT = "//div[@class = 'search-results__items']/article[1]";

    private static final String EMPTY_RESULT_ERROR = "//div[@class = 'search-results__exception-message search-results--empty-result']";



    public void verifyFirstSearchResult() {
        assertThat(driver.findElement(By.xpath(FIRST_RESULT))
                .getText())
                .as("first search result doesn't contain provided value")
                .contains("testing");
        LOGGER.info("first search result verified");
    }

    public void verifyEmptySearchResults() {
        Assert.assertTrue("Search results are not empty", driver.findElement(By.xpath(EMPTY_RESULT_ERROR)).isDisplayed());
        assertThat(driver.findElement(By.xpath(EMPTY_RESULT_ERROR)).getText(), is(equalTo(SEARCH_RETURNED_NO_RESULTS.getValue())));
        LOGGER.info("search results contain empty search result error");
}

}
