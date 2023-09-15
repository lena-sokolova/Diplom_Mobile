package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;

public class ArticlePage {

    public ArticlePage checkHeaderTitle() {
        $(className("android.widget.TextView")).shouldBe(visible);
        return this;
    }
}
