package tests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("UI")
@Epic("Mobile")
@Feature("Поиск статьей")
@Owner("andryushchenkoka")
public class SearchTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "wikipedia",
            "Microsoft"
    })
    @Story("Поиск существующей статьи")
    @DisplayName("Поиск существующей статьи")
    @Severity(SeverityLevel.CRITICAL)
    public void checkSearchedArticleHeadersTest(String request) {

        step("Ввести запрос в поисковую строку", () -> {

            step("Тап по поисковой строке", () -> {
                $(id("org.wikipedia:id/search_container")).click();
            });

            step("Ввести запрос", () -> {
                $(id("org.wikipedia:id/search_src_text")).sendKeys(request);
            });
        });

        step("Проверка", () -> {
            step("Все результаты поиска содержат введенный запрос", () -> {

                List<String> heads = $$(id("org.wikipedia:id/page_list_item_title"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0))
                        .texts().stream().map(String::toLowerCase).collect(Collectors.toList());
                Assertions.assertTrue(heads.contains(request.toLowerCase()));
            });
        });
    }
}
