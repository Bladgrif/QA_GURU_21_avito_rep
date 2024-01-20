package com.avito.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FilteringSearchPage {
    SelenideElement buttonAllCategories =  $("button[data-marker='top-rubricator/all-categories']");
    SelenideElement buttonElectronics = $(".new-rubricator-content-leftcontent-_hhyV");
    SelenideElement fieldMobilePhone = $("[data-name='Электроника']").parent().sibling(0).$("[data-name='Мобильные телефоны']");
    SelenideElement fieldManufacturer = $("[placeholder='Производитель']");
    SelenideElement filedfromManufacturer = $("[data-placement='bottom-start']");
    SelenideElement buttonSearch = $("button[data-marker='search-filters/submit-button']");
    SelenideElement fieldMobilePhonefirst = $("a[title='Мобильные телефоны']");

    @Step("Open page")
    public FilteringSearchPage openPage() {
        open("https://www.avito.ru/cheboksary/telefony");
        return this;
    }

    @Step("Click the button with mobile phone")
    public FilteringSearchPage fieldMobilePhoneChoose() {
        fieldMobilePhonefirst.click();
        return this;
    }

    @Step("Click the button with all categories")
    public FilteringSearchPage mainButtonAllCategoriesShouldBeVisible() {
        buttonAllCategories.should(Condition.appear, Duration.ofSeconds(10));
        return this;
    }

    @Step("Click the \"All categories\" button")
    public FilteringSearchPage buttonAllCategoriesClick() {
        buttonAllCategories.click();
        buttonElectronics.should(Condition.appear, Duration.ofSeconds(10));
        return this;
    }

    @Step("Hover the mouse over the Electronics category")
    public FilteringSearchPage buttonElectronicsHover(String value) {
        buttonElectronics.$(byText(value)).hover();
        return this;
    }

    @Step("Make a click in the field with the choice of phone model")
    public FilteringSearchPage fieldMobilePhoneClick() {
        fieldMobilePhone.click();
        return this;
    }

    @Step("Enter the model name in the field")
    public FilteringSearchPage fieldManufacturerSet(String value) {
        fieldManufacturer.setValue(value);
        return this;
    }

    @Step("Make a click after entering the model")
    public FilteringSearchPage filedfromManufacturerClick(String value) {
        filedfromManufacturer.$(byText(value)).click();
        return this;
    }

    @Step("Click the search button")
    public FilteringSearchPage buttonSearchClick() {
        buttonSearch.click();
        return this;
    }

    @Step("Checking the search results")
    public FilteringSearchPage checkElementsFromCollection(String value) {
        value = ".*" + value + ".*";
        List<String> texts = $$("[data-marker='catalog-serp'] [itemprop='name']").texts();
        for (String text : texts) {
            assert (text).matches(value);
        }
        return this;
    }

}
