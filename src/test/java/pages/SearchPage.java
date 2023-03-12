package pages;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import pages.components.SearchLineComponent;

public class SearchPage {

    private final SelenideElement searchResultsPanel = $(id("org.wikipedia:id/search_results_list"));
    SearchLineComponent searchLine = new SearchLineComponent();

    public SearchPage tapSearchLine() {

        $(id("org.wikipedia:id/search_card")).click();
        return this;
    }

    public SearchPage setSearchRequest(String request) {

        return searchLine.setSearchRequest(request);
    }

    public List<String> getSearchResultsHeaders() {

        return searchResultsPanel.$$("android.widget.TextView").texts();
    }

    public ArticlePage openFirstArticle() {

        $(id("org.wikipedia:id/fragment_search_results"))
                .$("android.widget.TextView").click();
        return new ArticlePage();
    }

    public boolean isRequestInAllResults(String request, List<String> results) {

        for (String item : results)
            if (!item.toLowerCase().contains(request.toLowerCase())) return false;
        return true;
    }
}
