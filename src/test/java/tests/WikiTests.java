package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiTests extends tests.TestBase {

    @Test
    @Owner("Elena Sokolova")
    @DisplayName("Search test")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/search_container"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    @Owner("Elena Sokolova")
    @DisplayName("Open article test")
    void successfulOpenArticleTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });
        step("Verify content found", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
        step("Open article", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).click();
        });
        step("Click on the back button", () -> {
            $(id("org.wikipedia.alpha:id/view_wiki_error_button")).click();
        });
        step("Check visibility of header logo", () -> {
            $(id("org.wikipedia.alpha:id/single_fragment_toolbar_wordmark"))
                    .shouldBe(visible);
        });
    }

    @Test
    @Owner("Elena Sokolova")
    @DisplayName("Add language")
    void successfulAddLanguageTest() {
        step("Click on the settings menu icon", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Select menu item Settings", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });
        step("Select language", () -> {
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Wikipedia language")).click();
            $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text("Deutsch")).click();
        });
        step("Check selected language", () -> {
            $$(AppiumBy.className("android.widget.TextView")).findBy(text("Deutsch")).shouldBe(visible);
        });
    }
}
