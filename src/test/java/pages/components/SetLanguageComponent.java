package pages.components;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class SetLanguageComponent {

    public static final String LANGUAGE = "Svenska";

    public SetLanguageComponent selectLanguage(String value) {
        $$(AppiumBy.id("org.wikipedia.alpha:id/localized_language_name")).findBy(text(value)).click();
        return this;

    }
}
