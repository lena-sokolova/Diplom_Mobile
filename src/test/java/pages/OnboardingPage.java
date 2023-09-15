package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OnboardingPage {

    public OnboardingPage clickAddOrEditLanguageButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/addLanguageButton")).click();
        return this;
    }

    public OnboardingPage checkLanguage(String value) {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text(value)).shouldBe(visible);
        return this;
    }
}