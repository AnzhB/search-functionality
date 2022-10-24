package automation.test;

import org.testng.annotations.Test;

import static automation.base.Constants.BASE_URL;
import static automation.model.enams.Messages.SEARCH_RETURNED_NO_RESULTS;
import static automation.utils.RandomNameGenerator.*;
import static com.codeborne.selenide.Selenide.open;


public class SearchTest extends BaseSteps {

    @Test
    public void SearchForQueryParameter() {

        open(BASE_URL);

        homePage.clickSearchIcon();
        homePage.verifyInputFieldAppears();
        homePage.searchForQueryParameter("test");
        searchResultsPage.verifyAllResultContains("test");
    }

    @Test
    public void searchPanel() {

        open(BASE_URL);

        homePage.clickSearchIcon();
        homePage.verifyInputFieldAppears();
        homePage.verifyFrequentSearchItemsAreDisplayed();
        homePage.verifyHoverOnFrequentSearchItemsIsHighlighted();
    }


    @Test
    public void SearchForInvalidParameters() {

        open(BASE_URL);

        homePage.clickSearchIcon();
        homePage.verifyInputFieldAppears();
        homePage.searchForQueryParameter(generateRandomText(10));
        searchResultsPage.verifyWarningText(SEARCH_RETURNED_NO_RESULTS);
        homePage.clickSearchIcon();
        homePage.searchForQueryParameter(getRandomNumber(10));
        searchResultsPage.verifyWarningText(SEARCH_RETURNED_NO_RESULTS);
    }

}
