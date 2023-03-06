package pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

import com.codeborne.selenide.SelenideElement;

public class ArticleActionTabComponent {

    private final SelenideElement saveTab = $(accessibilityId("Save")),
            langTab = $(accessibilityId("Language")),
            findTab = $(accessibilityId("Find in article")),
            themeTab = $(accessibilityId("Theme")),
            contentsTab = $(accessibilityId("Contents"));

    public void checkActionTabsVisibility() {

        saveTab.shouldBe(visible);
        langTab.shouldBe(visible);
        findTab.shouldBe(visible);
        themeTab.shouldBe(visible);
        contentsTab.shouldBe(visible);
    }
}
