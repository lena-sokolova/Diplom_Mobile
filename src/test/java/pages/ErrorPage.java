package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErrorPage {
    public static final String ErrorText = "An error occurred";

    public ErrorPage checkErrorButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_button")).shouldBe(visible);
        return this;
    }

    public ErrorPage checkErrorText() {
        $(AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldHave(text(ErrorText));
        return this;
    }
}
