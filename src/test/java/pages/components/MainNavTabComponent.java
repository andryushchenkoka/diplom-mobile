package pages.components;

import static com.codeborne.selenide.Selenide.$;

import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import pages.ExplorePage;
import pages.SavedPage;
import pages.SearchPage;

public class MainNavTabComponent {

    private final SelenideElement exploreTab = $(accessibilityId("Explore")),
            savedTab = $(accessibilityId("Saved")),
            searchTab = $(accessibilityId("Search"));

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

    public ExplorePage openExploreTab() {

        exploreTab.click();
        return new ExplorePage();
    }

    public SavedPage openSavedTab() {

        savedTab.click();
        return new SavedPage();
    }

    public SearchPage openSearchTab() {

        searchTab.click();
        return new SearchPage();
    }
}
