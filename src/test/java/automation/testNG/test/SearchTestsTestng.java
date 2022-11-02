package automation.testNG.test;

import org.testng.annotations.Test;

import static automation.testNG.utils.RandomNameGenerator.*;


public class SearchTestsTestng extends BaseSteps{


    @Test (description = "First search result test")
    public void firstSearchResult()
    {
        homePage.clickSearchIcon();
        homePage.waitForSearchPanelAppears();
        homePage.searchForQueryParameter("testing");
        searchResultsPage.verifyFirstSearchResult();

    }

    @Test (description = "Empty search results test")
    public void searchResultsAreEmpty()
    {
        homePage.clickSearchIcon();
        homePage.waitForSearchPanelAppears();
        homePage.searchForQueryParameter(getRandomNumber(10));
        searchResultsPage.verifyEmptySearchResults();

    }


}
