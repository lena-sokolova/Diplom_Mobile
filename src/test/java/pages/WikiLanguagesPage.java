package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikiLanguagesPage {

    public WikiLanguagesPage clickAddLanguageButton() {
        $$(AppiumBy.className("android.widget.TextView")).findBy(text("Add language")).click();
        return this;
    }

    public WikiLanguagesPage clickBackButton() {
        $(AppiumBy.className("android.widget.ImageButton")).click();
        return this;
    }
}
