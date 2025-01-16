package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class BoutiqueProduct implements BoutiqueCurrancy {

    private WebDriver driver;

    private final By name = By.cssSelector(".product-wrapper > h2");
    private final By price = By.className("product-price");
    private final By description = By.cssSelector("div.product-wrapper > p:last-of-type");
    private final By addToTheCart = By.xpath("/html/body/main/div[1]/div/div[2]/div/form/button");
    private final By quantity = By.id("quantity");

    public BoutiqueProduct(WebDriver driver) {
        this.driver = driver;

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        if (!driver.getCurrentUrl().contains("product")) {
            throw new IllegalStateException("This is not the Product Page. Current page: " + driver.getCurrentUrl());
        }
    }

    public void SetQuantity(int index) {

        Select dropdown = new Select(driver.findElement(quantity));
        dropdown.selectByIndex(index);
    }


    public String getProductName() {

        return driver.findElement(name).getText();
    }


    public String getProductPrice() {

        return driver.findElement(price).getText();
    }


    public String getProductDescription() {

        return driver.findElement(description).getText();
    }


    public BoutiqueCart addToTheCart() {

        driver.findElement(addToTheCart).click();
        return new BoutiqueCart(driver);
    }


    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
