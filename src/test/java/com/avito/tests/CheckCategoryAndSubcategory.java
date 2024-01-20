package com.avito.tests;

import com.avito.base.TestBase;
import com.avito.pages.CheckSomeCategoryAndSubcategoryPage;
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

public class CheckCategoryAndSubcategory extends TestBase {

    CheckSomeCategoryAndSubcategoryPage checkSomeCategoryAndSubcategoryPage = new CheckSomeCategoryAndSubcategoryPage();
    String categoryCars = "Транспорт";
    String categoryRealty = "Работа";
    String categoryJobs = "Недвижимость";
//    @ParameterizedTest(name = "Checking the category {0} and its subcategories in the catalog")
//    @ValueSource(strings = {
//            "Транспорт",
//            "Работа",
//            "Недвижимость"
//    })
    @Test
//    @Disabled
    @Tag("remote_avito")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Checking the category Cars and its subcategories from the catalog")
    void checkCategoryAndSubcategoryFromMainPage() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        checkSomeCategoryAndSubcategoryPage.openPage()
                .mainButtonAllCategoriesShouldBeVisible()
                .mainButtonAllCategoriesClick()
                .buttonFromCatalogHover(categoryCars)
                .checkMainTextAfterButtonFromCatalogHover(categoryCars)
                .checkSubcategorysTextAfterButtonFromCatalogHover(categoryCars);
    }
//
    @Test
//    @Disabled
    @Tag("remote_avito")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Checking the category Realty and its subcategories from the catalog")
    void checkCategoryRealtyAndSubcategoryFromMainPage() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        checkSomeCategoryAndSubcategoryPage.openPage()
                .mainButtonAllCategoriesShouldBeVisible()
                .mainButtonAllCategoriesClick()
                .buttonFromCatalogHover(categoryRealty)
                .checkMainTextAfterButtonFromCatalogHover(categoryRealty)
                .checkSubcategorysTextAfterButtonFromCatalogHover(categoryRealty);
    }

    @Test
//    @Disabled
    @Tag("remote_avito")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Checking the category Jobs and its subcategories from the catalog")
    void checkCategoryJobsAndSubcategoryFromMainPage() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        checkSomeCategoryAndSubcategoryPage.openPage()
                .mainButtonAllCategoriesShouldBeVisible()
                .mainButtonAllCategoriesClick()
                .buttonFromCatalogHover(categoryJobs)
                .checkMainTextAfterButtonFromCatalogHover(categoryJobs)
                .checkSubcategorysTextAfterButtonFromCatalogHover(categoryJobs);
    }
}
