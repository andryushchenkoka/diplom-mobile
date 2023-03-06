package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import pages.ExplorePage;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class SearchTests extends BaseTest {

    ExplorePage explorePage = new ExplorePage();
    SearchPage searchPage = new SearchPage();

    @ParameterizedTest
    @CsvFileSource(resources = "/data/search_data_test.csv")
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

        step("Проверить, что все результаты поиска содержат запрос", () -> {

            List<String> searchedHeaders = searchPage.getSearchResultsHeaders();
            Assertions.assertTrue(searchPage.isRequestInAllResults(request, searchedHeaders));
        });
    }

    @Test
    public void checkSearchInBottomMenu(){


    }
}
