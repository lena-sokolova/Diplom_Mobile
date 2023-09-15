package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;
import static pages.AddLanguagePage.LANGUAGE;
import static pages.SearchPage.SEARCH_VALUE;

@Tag("local")
@Owner("Elena Sokolova")
public class WikiTestsLocal extends tests.TestBase {

    SearchPage searchPage = new SearchPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    ArticlePage articlePage = new ArticlePage();
    OnboardingPage onboardingPage = new OnboardingPage();
    WikiLanguagesPage wikiLanguagesPage = new WikiLanguagesPage();
    AddLanguagePage addLanguagePage = new AddLanguagePage();

    @Test
    @DisplayName("Search test")
    void successfulSearchTest() {
        step("Click on back button", () -> {
            back();
        });
        step("Click on search field", () -> {
            searchPage.clickSearch();
        });
        step("Type search value", () -> {
            searchPage.setSearchValue(SEARCH_VALUE);
        });
        step("Verify content found", () -> {
            searchResultPage.checkResults();
        });
    }

    @Test
    @DisplayName("Open article test")
    void successfulOpenArticleTest() {
        step("Click on back button", () -> {
            back();
        });
        step("Click on search field", () -> {
            searchPage.clickSearch();
        });
        step("Type search value", () -> {
            searchPage.setSearchValue(SEARCH_VALUE);
        });
        step("Verify content found", () -> {
            searchResultPage.checkResults();
        });
        step("Open article", () -> {
            searchResultPage.openArticleLocal();
        });
        step("Check article title", () -> {
            articlePage.checkHeaderTitle();
        });
    }

    @Test
    @DisplayName("Add language")
    void successfulAddLanguageTest() {
        step("Click on the Add or Edit language button", () -> {
            onboardingPage.clickAddOrEditLanguageButton();
        });
        step("Select language", () -> {
            wikiLanguagesPage.clickAddLanguageButton();
            addLanguagePage.selectLanguage(LANGUAGE);
        });
        step("Check selected language", () -> {
            wikiLanguagesPage.clickBackButton();
            onboardingPage.checkLanguage(LANGUAGE);
        });
    }
}