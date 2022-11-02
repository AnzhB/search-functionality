package automation.selenide.page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.allMatch;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class SearchResultsPage extends BasePage {

    private static final String RESULTS_LIST = "#search-results__title a";
    private static final String SEARCH_RESULTS = "//article[@class ='search-results__item']/p[@class = 'search-results__description']";

    public ElementsCollection resultLinks() {
        return $$(RESULTS_LIST)
                .should(allMatch("Visible", link -> link.isDisplayed()));
    }

    public void verifyAllResultContains(String queryParameter) {
        $$x(SEARCH_RESULTS).asDynamicIterable().forEach(x -> x.should(text(queryParameter)));
    }

}
