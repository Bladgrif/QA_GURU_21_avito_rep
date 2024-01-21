package com.avito.tests;

import com.avito.pages.MainPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("avito_test")
@Feature("Check Category on main page")
@Owner("Roman Grigorev")

public class ProductSearch extends BaseTest {
    MainPage mainPage = new MainPage();
    String model = "iPhone";
    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("In the search bar, enter the phone model, check the search results")
    void ProductSearchByKeyword() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainPage.openPage()
                .setFieldSearch(model)
                .checkElementsFromCollection(model);
    }
}
