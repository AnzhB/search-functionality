package automation.cucumber.steps;

import automation.testNG.page.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static automation.testNG.utils.RandomNameGenerator.getRandomNumber;

public class HomePageSteps {

    private HomePage homePage = new HomePage();
    @When("main page is opened")
    public void openPage() {
        homePage.openPage();
    }

    @When("click search icon")
    public void clickSearchIcon() {
        homePage.clickSearchIcon();
    }

    @Then("verify search panel appears")
    public void verifySearchPanelAppears() {
        homePage.waitForSearchPanelAppears();
    }

    @When("^type \"([^\"]*)\" into search field$")
    public void typeQuery(String query) {
        homePage.searchForQueryParameter(query);
    }

    @When("^type randomly generated query into search field$")
    public void typeRandomlyGeneratedQuery() {
        homePage.searchForQueryParameter(getRandomNumber(10));
    }

}
