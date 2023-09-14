package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;

public class WikiTestsLocal extends tests.TestBase {

    SearchPage searchPage = new SearchPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    OpenArticlePage openArticlePage = new OpenArticlePage();
    OnboardingPage onboardingPage = new OnboardingPage();
    WikiLanguagesPage wikiLanguagesPage = new WikiLanguagesPage();
    AddLanguagePage addLanguagePage = new AddLanguagePage();

    @Test
    @Tag("local")
    @Owner("Elena Sokolova")
    @DisplayName("Search test")
    void successfulSearchTest() {
        step("Click on back button", () -> {
            back();
        });
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
    @Tag("local")
    @Owner("Elena Sokolova")
    @DisplayName("Open article test")
    void successfulOpenArticleTest() {
        step("Click on back button", () -> {
            back();
        });
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
            openArticlePage.openArticle();
        });
        step("Check article title", () -> {
            openArticlePage.checkHeaderTitle();
        });
    }

    @Test
    @Tag("local")
    @Owner("Elena Sokolova")
    @DisplayName("Add language")
    void successfulAddLanguageTest() {
        step("Click on the Add or Edit language button", () -> {
            onboardingPage.clickAddOrEditLanguageButton();
        });
        step("Select language", () -> {
            wikiLanguagesPage.clickAddLanguageButton();
            addLanguagePage.selectLanguage();
        });
        step("Check selected language", () -> {
            wikiLanguagesPage.clickBackButton();
            onboardingPage.checkLanguage();
        });
    }
}