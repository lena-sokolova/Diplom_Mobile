package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    public static final String SEARCH_VALUE = "Appium";

    public SearchPage clickSearch() {
        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        return this;
    }

    public SearchPage setSearchValue() {
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(SEARCH_VALUE);
        return this;
    }

    public SearchPage checkResults() {
        $$(id("org.wikipedia.alpha:id/search_container")).shouldHave(sizeGreaterThan(0));
        return this;
    }

    public SearchPage openArticle() {
        $(id("org.wikipedia.alpha:id/search_container")).click();
        return this;
    }

    public SearchPage clickBackButton() {
        $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click();
        return this;
    }

    public SearchPage checkHeaderLogo() {
        $(id("org.wikipedia.alpha:id/single_fragment_toolbar_wordmark")).shouldBe(visible);
        ;
        return this;
    }
}