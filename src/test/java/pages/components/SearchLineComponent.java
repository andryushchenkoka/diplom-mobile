package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;

import pages.SearchPage;

public class SearchLineComponent {

    private final SelenideElement searchInput = $(id("org.wikipedia:id/search_src_text"));


    public SearchPage setSearchRequest(String request) {

        searchInput.sendKeys(request);
        return new SearchPage();
    }
}
