package com.avito.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.avito.config.ConfigReader;
import com.avito.config.WebConfig;
import com.avito.config.WebConfigProject;
import com.avito.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    private static final WebConfig config = ConfigReader.Instance.read();

    @BeforeAll
    static void beforeAll() {
        WebConfigProject webConfigProject = new WebConfigProject(config);
        webConfigProject.webConfig();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}
