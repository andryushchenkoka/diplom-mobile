package pages;

import pages.components.ArticleActionTabComponent;

public class ArticlePage {

    ArticleActionTabComponent articleActionTab = new ArticleActionTabComponent();

    public boolean areAllTabsVisible() {

        return articleActionTab.areAllTabsVisible();
    }
}
