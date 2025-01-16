package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CheckoutPage {
    private final By orderStatusMsg = By.cssSelector("h3");

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        if (!driver.getCurrentUrl().contains("checkout")) {
            throw new IllegalStateException("This is not the Checkout Page. Current page: " + driver.getCurrentUrl());
        }
    }

    public Boolean orderStatus(){
        return driver.findElement(orderStatusMsg).getText().contains("is complete");
    }
}
