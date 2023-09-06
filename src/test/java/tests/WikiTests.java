package tests;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.AddLanguagePage;
import pages.SearchPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiTests extends tests.TestBase {

    SearchPage searchPage = new SearchPage();
    AddLanguagePage addLanguagePage = new AddLanguagePage();

    @Test
    @Owner("Elena Sokolova")
    @DisplayName("Search test")
    void successfulSearchTest() {
        step("Click on search field", () -> {
            searchPage.clickSearch();
        });
        step("Type search value", () -> {
            searchPage.setSearchValue();
        });
        step("Verify content found", () -> {
            searchPage.checkResults();
        });
    }

    @Test
    @Owner("Elena Sokolova")
    @DisplayName("Open article test")
    void successfulOpenArticleTest() {
        step("Click on search field", () -> {
            searchPage.clickSearch();
        });
        step("Type search value", () -> {
            searchPage.setSearchValue();
        });
        step("Verify content found", () -> {
            searchPage.checkResults();
        });
        step("Open article", () -> {
            searchPage.openArticle();
        });
        step("Click on the back button", () -> {
            searchPage.clickBackButton();
        });
        step("Check visibility of header logo", () -> {
            searchPage.checkHeaderLogo();
        });
    }

    @Test
    @Owner("Elena Sokolova")
    @DisplayName("Add language")
    void successfulAddLanguageTest() {
        step("Click on the settings menu icon", () -> {
            addLanguagePage.clickMenuButton();
        });
        step("Select menu item Settings", () -> {
            addLanguagePage.clickSettingsButton();
        });
        step("Select language", () -> {
            addLanguagePage.clickLanguageField()
                    .selectLanguage();
        });
        step("Check selected language", () -> {
            addLanguagePage.checkLanguage();
        });
    }
}