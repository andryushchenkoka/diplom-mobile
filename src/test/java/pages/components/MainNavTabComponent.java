package pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static io.appium.java_client.AppiumBy.accessibilityId;

import com.codeborne.selenide.SelenideElement;

import pages.ExplorePage;
import pages.SearchPage;

public class MainNavTabComponent {

    private final SelenideElement exploreTab = $(accessibilityId("Explore")),
            savedTab = $(accessibilityId("Saved")),
            searchTab = $(accessibilityId("Search")),
            editsTab = $(accessibilityId("Edits")),
            moreTab = $(accessibilityId("More"));

    public void checkMainTabsVisibility() {

        exploreTab.shouldBe(visible);
        savedTab.shouldBe(visible);
        searchTab.shouldBe(visible);
        editsTab.shouldBe(visible);
        moreTab.shouldBe(visible);
    }

    public ExplorePage openExploreTab() {

        exploreTab.click();
        return new ExplorePage();
    }

    public SearchPage openSearchTab() {

        searchTab.click();
        return new SearchPage();
    }
}
