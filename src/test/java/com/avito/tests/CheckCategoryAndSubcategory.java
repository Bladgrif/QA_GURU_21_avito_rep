package com.avito.tests;

import com.avito.base.BaseTest;
import com.avito.pages.CheckSomeCategoryAndSubcategoryPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Tag("avito_test")
@Feature("Check Category on main page")
@Owner("Roman Grigorev")

public class CheckCategoryAndSubcategory extends BaseTest {

    CheckSomeCategoryAndSubcategoryPage checkSomeCategoryAndSubcategoryPage = new CheckSomeCategoryAndSubcategoryPage();

    @ParameterizedTest(name = "Checking the category {0} and its subcategories in the catalog")
    @ValueSource(strings = {
            "Транспорт",
            "Работа",
            "Недвижимость"
    })
    @Disabled
    @Tag("avito_test")
    @Severity(SeverityLevel.NORMAL)
    void checkCategoryAndSubcategoryFromMainPage(String category) {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 5000;


        checkSomeCategoryAndSubcategoryPage.openPage()
                .mainButtonAllCategoriesShouldBeVisible()
                .mainButtonAllCategoriesClick()
                .buttonFromCatalogHover(category)
                .checkMainTextAfterButtonFromCatalogHover(category)
                .checkSubcategorysTextAfterButtonFromCatalogHover(category);
    }
}