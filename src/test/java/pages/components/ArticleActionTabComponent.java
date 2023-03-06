package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ArticleActionTabComponent {

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
