package tests;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Tag("UI")
@Epic("Mobile")
@Owner("andryushchenkoka")
public class TabsTests extends BaseTest {

    @Test
    @Feature("Меню навигации")
    @Story("Видимость меню навигации")
    @DisplayName("Проверить видимость всех табов")
    @Severity(SeverityLevel.CRITICAL)
    public void checkMainTabsVisibility() {

        step("Проверить видимость всех табов", () -> {

            step("Отображается таб Explore", () -> {
                $(id("org.wikipedia:id/nav_tab_explore")).shouldBe(visible);
            });

            step("Отображается таб Saved", () -> {
                $(id("org.wikipedia:id/nav_tab_reading_lists")).shouldBe(visible);
            });

            step("Отображается таб Search", () -> {
                $(id("org.wikipedia:id/nav_tab_search")).shouldBe(visible);
            });

            step("Отображается таб Edits", () -> {
                $(id("org.wikipedia:id/nav_tab_edits")).shouldBe(visible);
            });

            step("Отображается таб More", () -> {
                $(id("org.wikipedia:id/nav_more_container")).shouldBe(visible);
            });
        });
    }

    @ParameterizedTest
    @Feature("Меню статьи")
    @Story("Видимость элементов меню")
    @DisplayName("Проверить видимость всех табов")
    @Severity(SeverityLevel.CRITICAL)
    @ValueSource(strings = {
            "Wikipedia"
    })
    public void checkActionTabsVisibility(String articleRequest) {

        step("Найти и открыть первую статью из списка", () -> {

            step("Ввести поисковый запрос", () -> {
                $(id("org.wikipedia:id/nav_tab_search")).click();
                $(id("org.wikipedia:id/search_card")).click();
                $(id("org.wikipedia:id/search_src_text")).sendKeys(articleRequest);
            });

            step("Открыть первую статью", () -> {
                $$(id("org.wikipedia:id/page_list_item_title")).get(0).click();
            });
        });

        step("Проверка", () -> {

            step("Отображается таб Save", () -> {
                $(id("org.wikipedia:id/page_save")).shouldBe(visible);
            });

            step("Отображается таб Language", () -> {
                $(id("org.wikipedia:id/page_language")).shouldBe(visible);
            });

            step("Отображается таб Find", () -> {
                $(id("org.wikipedia:id/page_find_in_article")).shouldBe(visible);
            });

            step("Отображается таб Theme", () -> {
                $(id("org.wikipedia:id/page_theme")).shouldBe(visible);
            });

            step("Отображается таб Contents", () -> {
                $(id("org.wikipedia:id/page_contents")).shouldBe(visible);
            });
        });
    }
}
