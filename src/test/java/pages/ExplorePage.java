package pages;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

import pages.components.MainNavTabComponent;

public class ExplorePage {

    MainNavTabComponent mainNavTab = new MainNavTabComponent();

    public boolean areAllTabsVisible() {

        return mainNavTab.areAllTabsVisible();
    }

    public SearchPage tapSearchLine() {

        $(id("org.wikipedia:id/search_container")).click();
        return new SearchPage();
    }

    public SearchPage tapSearchTab() {

        return mainNavTab.openSearchTab();
    }
}
