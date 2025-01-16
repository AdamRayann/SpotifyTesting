package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class BoutiqueCart implements BoutiqueCurrancy {
    WebDriver driver ;
    private final By title = By.cssSelector("h3");

    private final By emptyButton = By.className("cart-summary-empty-cart-button");
    private final By continueButton = By.xpath("/html/body/main/section/div/div[1]/div[1]/div[2]/form/a");
    private final By placeOrder = By.xpath("/html/body/main/section/div/div[2]/form/div[10]/div/button");


    public BoutiqueCart(WebDriver driver) {
        this.driver=driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        if (!driver.getCurrentUrl().contains("cart")) {
            throw new IllegalStateException("This is not the Cart Page. Current page: " + driver.getCurrentUrl());
        }
    }

    public void emptyCart()
    {
        driver.findElement(emptyButton).click();
    }

    public BoutiqueHomePage continueShopping()
    {
        driver.findElement(continueButton).click();
        return new BoutiqueHomePage(driver);
    }

    public CheckoutPage placeOrder()
    {
        driver.findElement(placeOrder).click();
        return new CheckoutPage(driver);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
