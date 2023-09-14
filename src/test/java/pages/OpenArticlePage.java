package pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;

public class OpenArticlePage {
    public OpenArticlePage openArticle() {
        $(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        return this;
    }

    public OpenArticlePage checkHeaderTitle() {
        $(className("android.widget.TextView")).shouldBe(visible);
        return this;
    }
}
