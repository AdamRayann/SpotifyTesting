package HTMLTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class accessibilityTesting {
    static WebDriver driver;

    private static final String baseURL = "https://www.selenium.dev/selenium/web/web-form.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void test1()
    {
        driver.navigate().to(baseURL);

        Actions actions=new Actions(driver);
        Actions tab=new Actions(driver);

        tab.keyDown("\t").perform();
        driver.switchTo().activeElement();
        actions.sendKeys("john").perform();

        tab.keyDown("\t").perform();
        driver.switchTo().activeElement();
        actions.sendKeys("1234").perform();

        tab.keyDown("\t").perform();
        driver.switchTo().activeElement();
        actions.sendKeys("Elvis has left the building").perform();

        tab.keyDown("\t").perform();
        tab.keyDown("\t").perform();
        tab.keyDown("\t").perform();

        driver.switchTo().activeElement();
        actions.sendKeys("Two").perform();

        tab.keyDown("\t").perform();
        driver.switchTo().activeElement();
        actions.sendKeys("Seattle").perform();
        tab.keyDown("\t").perform();
        tab.keyDown("\t").perform();
        WebElement webElement=driver.switchTo().activeElement();
        if(!webElement.isSelected())
            actions.sendKeys(" ").perform();
        tab.keyDown("\t").perform();
        webElement=driver.switchTo().activeElement();
        if(!webElement.isSelected())
            actions.sendKeys(" ").perform();

        tab.keyDown("\t").perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        tab.keyDown("\t").perform();
        Actions submit = new Actions(driver);
        submit.sendKeys(Keys.ENTER);

        tab.keyDown("\t").perform();
        tab.keyDown("\t").perform();
        actions.sendKeys("11/05/2022").perform();

        tab.keyDown("\t").perform();
        webElement = driver.switchTo().activeElement();
        while(!("10".equals(webElement.getDomProperty("value"))))
        {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }

        submit.perform();









    }




    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
