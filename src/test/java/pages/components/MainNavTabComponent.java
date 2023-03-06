package pages.components;

import static com.codeborne.selenide.Selenide.$;

import static io.appium.java_client.AppiumBy.accessibilityId;

import com.codeborne.selenide.SelenideElement;

import pages.ExplorePage;
import pages.SearchPage;

public class MainNavTabComponent {

    private final SelenideElement exploreTab = $(accessibilityId("Explore")),
            searchTab = $(accessibilityId("Search"));

    public ExplorePage openExploreTab() {

        exploreTab.click();
        return new ExplorePage();
    }

    public SearchPage openSearchTab() {

        searchTab.click();
        return new SearchPage();
    }
}
