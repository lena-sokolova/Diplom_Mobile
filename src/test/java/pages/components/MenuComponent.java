package pages.components;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class MenuComponent {
    public MenuComponent clickSettingsButton() {
        $(AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        return this;
    }
}
