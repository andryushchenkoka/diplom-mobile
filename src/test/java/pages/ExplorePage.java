package pages;

import pages.components.MainNavTabComponent;
import pages.components.SearchLineComponent;

public class ExplorePage {

    SearchLineComponent searchLine = new SearchLineComponent();
    MainNavTabComponent mainNavTab = new MainNavTabComponent();

    public SearchPage tapSearchLine() {

        return searchLine.tapSearchLine();
    }

    public boolean areAllTabsVisible() {

        return mainNavTab.areAllTabsVisible();
    }

    public SearchPage tapSearchTab() {

        return mainNavTab.openSearchTab();
    }
}
