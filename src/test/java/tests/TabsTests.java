package tests;

import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.ArticlePage;
import pages.ExplorePage;

@Tag("UI")
@Epic("Mobile")
@Owner("andryushchenkoka")
public class TabsTests extends BaseTest {

    ExplorePage explorePage = new ExplorePage();
    ArticlePage articlePage = new ArticlePage();

    @Test
    @Feature("Меню навигации")
    @Story("Видимость меню навигации")
    @DisplayName("Проверить видимость всех табов")
    @Severity(SeverityLevel.CRITICAL)
    public void checkMainTabsVisibility() {

        step("Проверить видимость всех табов", () -> {
            Assertions.assertTrue(explorePage.areAllTabsVisible());
        });
    }

    @Test
    @Feature("Меню статьи")
    @Story("Видимость элементов меню")
    @DisplayName("Проверить видимость всех табов")
    @Severity(SeverityLevel.CRITICAL)
    public void checkActionTabsVisibility() {

        step("Найти и открыть первую статью из списка", () -> {
            explorePage.tapSearchTab()
                    .setSearchRequest("")
                    .setSearchLanguage("")
                    .openFirstArticle();
        });

        step("Проверить видимость всех табов", () -> {
            Assertions.assertTrue(articlePage.areAllTabsVisible());
        });
    }
}
