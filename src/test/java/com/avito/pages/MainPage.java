package com.avito.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    SelenideElement fieldSearch = $("[data-marker='search-form'] [data-marker='search-form/suggest']");

    @Step("Open page")
    public MainPage openPage() {
        open("https://www.avito.ru/");
        return this;
    }

    @Step("Enter the name of the model in the search field")
    public MainPage setFieldSearch(String value) {
        fieldSearch.setValue(value).pressEnter();
        return this;
    }

    @Step("Checking the search results")
    public MainPage checkElementsFromCollection(String value) {
        value = ".*" + value + ".*";
//        String value = ".*iPhone.*";
        List<String> texts = $$("[data-marker='catalog-serp'] [itemprop='name']").texts();
        for (String text : texts) {
            assert (text).matches(value);
        }
        return this;
    }
}
