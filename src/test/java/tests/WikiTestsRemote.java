package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ErrorPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.SettingsPage;
import pages.components.MenuComponent;
import pages.components.SetLanguageComponent;

import static io.qameta.allure.Allure.step;

@Tag("remote")
@Owner("Elena Sokolova")
public class WikiTestsRemote extends tests.TestBase {

    SearchPage searchPage = new SearchPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ErrorPage errorPage = new ErrorPage();
    MenuComponent menuComponent = new MenuComponent();
    SettingsPage settingsPage = new SettingsPage();
    SetLanguageComponent languageComponent = new SetLanguageComponent();

    @Test
    @DisplayName("Search test")
    void successfulSearchTest() {
        step("Click on search field", () -> {
            searchPage.clickSearch();
        });
        step("Type search value", () -> {
            searchPage.setSearchValue();
        });
        step("Verify content found", () -> {
            searchResultPage.checkResults();
        });
    }

    @Test
    @DisplayName("Open article test")
    void successfulOpenArticleTest() {
        step("Click on search field", () -> {
            searchPage.clickSearch();
        });
        step("Type search value", () -> {
            searchPage.setSearchValue();
        });
        step("Verify content found", () -> {
            searchResultPage.checkResults();
        });
        step("Open article", () -> {
            searchResultPage.openArticle();
        });
        step("Click on the back button", () -> {
            errorPage.checkErrorButton();
        });
        step("Check visibility of header logo", () -> {
            errorPage.checkErrorText();
        });
    }

    @Test
    @DisplayName("Add language")
    void successfulAddLanguageTest() {
        step("Click on the settings menu icon", () -> {
            searchPage.clickMenuButton();
        });
        step("Select menu item Settings", () -> {
            menuComponent.clickSettingsButton();
        });
        step("Select language", () -> {
            settingsPage.clickLanguageField();
            languageComponent.selectLanguage();
        });
        step("Check selected language", () -> {
            settingsPage.checkLanguage();
        });
    }
}