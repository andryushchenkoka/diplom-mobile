package pages.components;

import static com.codeborne.selenide.Selenide.$;

import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import pages.SearchPage;

public class MainNavTabComponent {

    private final SelenideElement searchTab = $(id("org.wikipedia:id/nav_tab_search"));

    public ElementsCollection getMainTabs() {

        return $(id("org.wikipedia:id/main_nav_tab_layout"))
                .$$("android.widget.FrameLayout");
    }

    public boolean areAllTabsVisible() {

        ElementsCollection tabs = getMainTabs();

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
