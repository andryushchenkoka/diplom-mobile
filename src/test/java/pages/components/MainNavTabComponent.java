package pages.components;

import static com.codeborne.selenide.Selenide.$;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import pages.SearchPage;

public class MainNavTabComponent {

    private final SelenideElement searchTab = $(accessibilityId("Search"));

    public ElementsCollection getTabs() {

        return $(id("org.wikipedia:id/main_nav_tab_container"))
                .$$x("android.widget.FrameLayout")
                .filterBy(Condition.attribute("content-desc"));
    }

    public boolean areAllTabsVisible() {

        ElementsCollection tabs = getTabs();

        for (SelenideElement tab : tabs) {
            if (!tab.isDisplayed()) return false;
        }
        return true;
    }

    public SearchPage openSearchTab() {

        searchTab.click();
        return new SearchPage();
    }
}
