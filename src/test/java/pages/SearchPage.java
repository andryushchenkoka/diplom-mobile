package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import pages.components.SearchLineComponent;

public class SearchPage {

    private final SelenideElement searchLanguages = $(id("org.wikipedia:id/horizontal_scroll_languages")),
            searchResultsPanel = $(id("org.wikipedia:id/search_results_list"));
    SearchLineComponent searchLine = new SearchLineComponent();

    public SearchPage setSearchRequest(String request) {

        return searchLine.setSearchRequest(request);
    }

    public SearchPage setSearchLanguage(String lang) {

        searchLanguages.$(byText(lang.toUpperCase())).click();
        return this;
    }

    public List<String> getSearchResultsHeaders() {

        return searchResultsPanel.$$x("android.view.ViewGroup/android.widget.TextView").texts();
    }

    public ElementsCollection getSearchResults() {

        return $(id("org.wikipedia:id/fragment_search_results"))
                .$$("android.view.ViewGroup");
    }

    public ArticlePage openFirstArticle() {

        getSearchResults().get(0).click();
        return new ArticlePage();
    }

    public boolean isRequestInAllResults(String request, List<String> results) {

        for (String item : results)
            if (!item.toLowerCase().contains(request.toLowerCase())) return false;
        return true;
    }
}
