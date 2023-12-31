package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class AddLanguagePage {
    public static final String LANGUAGE = "Русский";

    public AddLanguagePage selectLanguage(String value) {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text(value)).click();
        return this;
    }
}
