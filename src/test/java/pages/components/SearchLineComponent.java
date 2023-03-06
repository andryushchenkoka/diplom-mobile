package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

import com.codeborne.selenide.SelenideElement;

import pages.SearchPage;

public class SearchLineComponent {

    private final SelenideElement searchLine = $(accessibilityId("Search Wikipedia"));

    public SearchPage tapSearchLine() {

        searchLine.click();
        return new SearchPage();
    }

    public SearchPage setSearchRequest(String request) {

        searchLine.click();
        searchLine.sendKeys(request);
        return new SearchPage();
    }
}
