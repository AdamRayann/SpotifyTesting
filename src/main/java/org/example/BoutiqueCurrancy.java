package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface BoutiqueCurrancy {

    WebDriver getDriver();
    By currency = By.name("currency_code");


    default boolean isFeatureVisible() {
        return getDriver().findElement(currency).isDisplayed();
    }

    default void clickCurrencyButton() {
        getDriver().findElement(currency).click();
    }

    default String getCurrencyText() {
        return getDriver().findElement(currency).getText();
    }


}
