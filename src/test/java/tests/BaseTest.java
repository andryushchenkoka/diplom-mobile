package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import drivers.BrowserstackDriver;
import drivers.MobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static helpers.Attach.getSessionId;

public class BaseTest {

    public static String environment = System.getProperty("env", "local");

    @BeforeAll
    static void beforeAll() {

        if (environment.equals("browserstack")) Configuration.browser = BrowserstackDriver.class.getName();
        if (environment.equals("local")) Configuration.browser = MobileDriver.class.getName();

        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(); // запустить приложение
        back(); // закрыть экран приветствия
    }

    @AfterEach
    void addAttachments() {

        String sessionId = getSessionId();
        Attach.pageSource();
        closeWebDriver();
        if (environment.equals("browserstack")) Attach.addVideo(sessionId);
    }
}
