package com.avito.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckSomeCategoryAndSubcategoryPage {
//    SelenideElement mainButtonAllCategories = $("#a").parent().parent().parent().$(byText("Все категории")),
    SelenideElement mainButtonAllCategories = $("button[data-marker='top-rubricator/all-categories'] svg"),
            buttonFromCatalog = $(".new-rubricator-content-leftcontent-_hhyV"),
            textButtonFromCatalogTransport = $("[data-name='Транспорт']"),
            textButtonFromCatalogRealty = $("[data-name='Недвижимость']"),
            textButtonFromCatalogJob = $("[data-name='Работа']");


    String[] TransportList = {"Мотоциклы и мототехника", "Грузовики и спецтехника", "Водный транспорт", "Запчасти и аксессуары"},
            JobList = {"Ищу работу", "Ищу сотрудника"},
            RealtyList = {"Купить жильё", "Снять посуточно", "Снять долгосрочно", "Коммерческая недвижимость", "Другие категории"};

    @Step("Open page")
    public CheckSomeCategoryAndSubcategoryPage openPage() {
        open("https://www.avito.ru/");
        return this;
    }

    @Step("Button with all categories should be visible")
    public CheckSomeCategoryAndSubcategoryPage mainButtonAllCategoriesShouldBeVisible() {
        mainButtonAllCategories.should(visible, Duration.ofSeconds(15));

        return this;
    }

    @Step("Click the button with all categories")
    public CheckSomeCategoryAndSubcategoryPage mainButtonAllCategoriesClick() {
        mainButtonAllCategories.shouldBe(appear, Duration.ofSeconds(15));
        mainButtonAllCategories.click();
        mainButtonAllCategories.click();
        return this;
    }

    @Step("Move the mouse over the category")
    public CheckSomeCategoryAndSubcategoryPage buttonFromCatalogHover(String category) {
        buttonFromCatalog.should(visible, Duration.ofSeconds(10));
        buttonFromCatalog.$(byText(category)).hover();
        return this;
    }

    @Step("Let's check that the subcategories display the category name of their catalog")
    public CheckSomeCategoryAndSubcategoryPage checkMainTextAfterButtonFromCatalogHover(String category) {
        switch (category) {
            case ("Транспорт"):
                textButtonFromCatalogTransport.shouldHave(text(category));
                break;
            case ("Работа"):
                textButtonFromCatalogJob.shouldHave(text(category));
                break;
            case ("Недвижимость"):
                textButtonFromCatalogRealty.shouldHave(text(category));
                break;
        }
        return this;
    }

    @Step("Let's check that all the necessary categories are displayed in the subcategories")
    public CheckSomeCategoryAndSubcategoryPage checkSubcategorysTextAfterButtonFromCatalogHover(String category) {
        switch (category) {
            case ("Транспорт"):
                checkCategoriesLists(category, TransportList);
                break;
            case ("Работа"):
                checkCategoriesLists(category, JobList);
                break;
            case ("Недвижимость"):
                checkCategoriesLists(category, RealtyList);
                break;
        }
        return this;
    }

    @Step("Method for checking the collection")
    public CheckSomeCategoryAndSubcategoryPage checkCategoriesLists(String mainCategory, String[] List) {
        String badMoment2 = "[data-name='" + mainCategory + "']";
        for (String category : List) {
            String badMoment = "[data-name='" + category + "']";
            SelenideElement textCategoriesFromCatalog = $(badMoment2).parent().sibling(0);
            textCategoriesFromCatalog.$(badMoment).shouldHave(text(category));
        }
        return this;
    }

}
