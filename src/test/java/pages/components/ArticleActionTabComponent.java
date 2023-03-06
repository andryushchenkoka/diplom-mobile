package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ArticleActionTabComponent {

    private final SelenideElement saveTab = $(accessibilityId("Save")),
            langTab = $(accessibilityId("Language")),
            findTab = $(accessibilityId("Find in article")),
            themeTab = $(accessibilityId("Theme")),
            contentsTab = $(accessibilityId("Contents"));

    public ElementsCollection getTabs() {

        return $(id("org.wikipedia:id/page_actions_tab_layout"))
                .$$x("android.widget.TextView");
    }

    public boolean areAllTabsVisible() {

        ElementsCollection tabs = getTabs();

        for (SelenideElement tab : tabs) {
            if (!tab.isDisplayed()) return false;
        }
        return true;
    }
}
