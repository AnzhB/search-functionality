package automation.selenide.page;

import automation.selenide.model.enams.Messages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;


public abstract class BasePage {


    private static final String WARNING_TEXT = "//*[@role ='alert']";

    public void verifyWarningText(Messages message) {
        $x(WARNING_TEXT).shouldBe(visible).shouldHave(text(message.getValue()));
    }
}
