package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class SearchPage {

    private final SelenideElement searchLine = $(id("org.wikipedia:id/search_src_text")),
            searchLanguages = $(id("org.wikipedia:id/horizontal_scroll_languages")),
            searchResultsPanel = $(id("org.wikipedia:id/search_results_list"));

    public SearchPage setSearchRequest(String request) {

        searchLine.click();
        searchLine.sendKeys(request);
        return this;
    }

    public SearchPage setSearchLanguage(String lang) {

        searchLanguages.$(byText(lang.toUpperCase())).click();
        return this;
    }

    public List<String> getSearchResultsHeaders() {

        return searchResultsPanel.$$x("android.view.ViewGroup/android.widget.TextView").texts();
    }

    public boolean isRequestInAllResults(String request, List<String> results) {

        for (String item : results)
            if (!item.toLowerCase().contains(request.toLowerCase())) return false;
        return true;
    }
}
