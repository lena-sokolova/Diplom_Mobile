package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddLanguagePage {

    public static final String LANGUAGE = "Svenska";

    public AddLanguagePage clickMenuButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        return this;
    }

    public AddLanguagePage clickSettingsButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        return this;
    }

    public AddLanguagePage clickLanguageField() {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text("Wikipedia language")).click();
        return this;
    }

    public AddLanguagePage selectLanguage() {
        $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text(LANGUAGE)).click();
        return this;
    }

    public AddLanguagePage checkLanguage() {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text(LANGUAGE)).shouldBe(visible);
        return this;
    }
}