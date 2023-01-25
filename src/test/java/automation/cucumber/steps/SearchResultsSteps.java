package automation.cucumber.steps;


import automation.cucumber.screens.SearchResultsPage;
import io.cucumber.java.en.Then;

public class SearchResultsSteps {

    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Then("verify 1st search result")
    public void VerifyFirstResult() {
        searchResultsPage.verifyFirstSearchResult();
    }

    @Then("verify there ara no search results")
    public void VerifyEmptyResults() {
        searchResultsPage.verifyEmptySearchResults();
    }

}
