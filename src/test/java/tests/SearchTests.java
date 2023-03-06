package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.ExplorePage;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

@Tag("UI")
@Epic("Mobile")
@Feature("Поиск статьей")
@Owner("andryushchenkoka")
public class SearchTests extends BaseTest {

    ExplorePage explorePage = new ExplorePage();
    SearchPage searchPage = new SearchPage();

    @ParameterizedTest
    @CsvFileSource(resources = "/data/search_data_test.csv")
    @Story("Поиск существующей статьи")
    @DisplayName("Поиск существующей статьи")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSearchedArticleHeadersTest(String request, String language) {

        step("Тапнуть по поисковой строке", () -> {
            explorePage.tapSearchLine();
        });

        step("Ввести запрос в поисковую строку", () -> {
            searchPage.setSearchRequest(request);
        });

        step("Установить язык ответов", () -> {
            searchPage.setSearchLanguage(language);
        });

        step("Проверить, что все результаты поиска содержат введенный запрос", () -> {

            List<String> searchedHeaders = searchPage.getSearchResultsHeaders();
            Assertions.assertTrue(searchPage.isRequestInAllResults(request, searchedHeaders));
        });
    }
}
