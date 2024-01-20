package com.avito.base;

import com.avito.helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class RemoteTestBase {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browserName","chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
//        String browserName = System.getProperty("browserName","chrome");
//        String browserName = System.getProperty("browserName");
//        String browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = System.getProperty("webDriver","https://user1:1234@selenoid.autotests.cloud/wd/hub");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }

}