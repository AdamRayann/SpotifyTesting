package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.sql.Driver;
import java.time.Duration;

public class BoutiqueHomePage extends LoadableComponent<BoutiqueHomePage>  {

    String URL = "https://cymbal-shops.retail.cymbal.dev/";
    private WebDriver driver;

    private final By product = By.xpath("/html/body/main/div[2]/div/div/div[1]/div[2]/a/div");
    private final By title = By.cssSelector(".col-12 > h3");


    public BoutiqueHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(URL);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (!driver.findElement(title).getText().contains("Hot Products")) {
            throw new IllegalStateException("This is not the Home Page. Current page: " + driver.getCurrentUrl());
        }
    }


    @Override
    protected void load() {
        driver.get(URL);
    }

    @Override
    protected void isLoaded() throws Error {
        if(!driver.getTitle().contains("Online"))
            throw new RuntimeException();
    }

    public String getProductName(int index)
    {
        return driver.findElements(By.className(".hot-product-card-img-overlay")).get(index).getText();
    }

    public String getTitle()
    {
        return driver.findElement(title).getText();
    }

    public BoutiqueProduct getProduct(int index)
    {
        //driver.findElements(By.className(".hot-product-card-img-overlay")).get(index).click();
        //this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(product).click();
        return new BoutiqueProduct(driver);
    }


//    @Override
//    public WebDriver getDriver() {
//        return driver;
//    }
}
