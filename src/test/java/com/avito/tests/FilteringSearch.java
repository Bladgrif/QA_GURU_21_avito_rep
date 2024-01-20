package com.avito.tests;

import com.avito.base.TestBase;
import com.avito.pages.ElectronicsPage;
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

public class FilteringSearch extends TestBase {
    ElectronicsPage electronicsPage = new ElectronicsPage();

    String category = "Электроника";
    String manufacturer = "Apple";
    String model = "iPhone";

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("In the section, we enter a filter for a specific brand of phone, check the search results")
    void FilteringSearchResults() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        electronicsPage.openPageElectronics()
                .chooseFieldMobilePhone()
                .fieldManufacturerSet(manufacturer)
                .filedfromManufacturerClick(manufacturer)
                .buttonSearchClick()
                .checkElementsFromCollection(model);
    }
}
