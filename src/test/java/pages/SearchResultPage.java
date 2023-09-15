package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchResultPage {
    public SearchResultPage checkResults() {
        $$(id("org.wikipedia.alpha:id/search_container")).shouldHave(sizeGreaterThan(0));
        return this;
    }

    public SearchResultPage openArticleLocal() {
        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        return this;
    }

    public SearchResultPage openArticleRemote() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_container")).first().click();
        return this;
    }
}
