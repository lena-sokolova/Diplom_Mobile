package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OnboardingPage {

    public static final String LANGUAGE = "Русский";

    public OnboardingPage clickAddOrEditLanguageButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/addLanguageButton")).click();
        return this;
    }

    public OnboardingPage checkLanguage() {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text(LANGUAGE)).shouldBe(visible);
        return this;
    }
}