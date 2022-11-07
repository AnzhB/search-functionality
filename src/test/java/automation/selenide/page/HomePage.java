package automation.selenide.page;

import com.codeborne.selenide.ElementsCollection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static automation.selenide.model.enams.Color.*;
import static automation.selenide.utils.ElementAttribute.*;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class HomePage extends BasePage{

    private static final String SEARCH_ICON = "//div[@class = 'header-search-ui header__control']";
    private static final String SEARCH_INPUT = "//input[@id = 'new_form_search']";
    private static final String SUBMIT_BUTTON = "//button[@class = 'header-search__submit']";
    private static final String INPUT_FIELD = "//div[@class = 'header-search__panel opened']";
    private static final String FREQUENT_SEARCH_ITEMS_TEMPLATE = "//ul[@class = 'frequent-searches__items']/li[text()='%s']";
    private static final List<String> FREQUENT_SEARCH_ITEMS = List.of("Blockchain", "Cloud", "DevOps", "Open Source", "RPA", "Automation", "Digital Risk Management", "Contact");
    private ElementsCollection frequentSearchesItems = $$x("//ul[@class = 'frequent-searches__items']/li");


    public void clickSearchIcon () {
        $x(SEARCH_ICON).click();
    }

    public void verifyInputFieldAppears () {
        $x(INPUT_FIELD).shouldBe(visible);
        Wait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(INPUT_FIELD)));
    }

    public void searchForQueryParameter (String queryParameter) {
        $x(SEARCH_INPUT).setValue(queryParameter);
        $x(SUBMIT_BUTTON).click();
    }


    public void verifyFrequentSearchItemsAreDisplayed () {
        frequentSearchesItems.shouldHave(texts(FREQUENT_SEARCH_ITEMS));
    }

    public void verifyHoverOnFrequentSearchItemsIsHighlighted() {
        for (int n = 0; n <= 7; n++) {
            $x(format(FREQUENT_SEARCH_ITEMS_TEMPLATE, FREQUENT_SEARCH_ITEMS.get(n))).hover();
            $x(format(FREQUENT_SEARCH_ITEMS_TEMPLATE, FREQUENT_SEARCH_ITEMS.get(n))).shouldHave(cssValue(CURSOR.getAttribute(), "pointer"));
            $x(format(FREQUENT_SEARCH_ITEMS_TEMPLATE, FREQUENT_SEARCH_ITEMS.get(n))).shouldHave(cssValue(COLOR.getAttribute(), BLUE_HIGHLIGHTED_FREQUENT_SEARCH_ITEM.getValue()));

        }
    }

}
