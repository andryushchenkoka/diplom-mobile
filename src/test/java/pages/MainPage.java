package pages;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

import com.codeborne.selenide.SelenideElement;

public class MainPage {

    private final SelenideElement searchLine = $(accessibilityId("org.wikipedia:id/search_container"));

    public SearchPage tapSearchLine() {

        searchLine.click();
        return new SearchPage();
    }
}
