package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
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

    public SearchPage clickMenuButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        return this;
    }
}
