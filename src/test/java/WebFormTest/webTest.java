package WebFormTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class webTest {

    static WebDriver driver;

    private static final String baseURL = "https://www.selenium.dev/selenium/web/dynamic.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    void boxTest() {
        driver.get(baseURL);

        WebElement element=driver.findElement(By.id("adder"));
        element.click();
        // implicit wait of 2 seconds - if the element not found, wait 2 seconds before returning an error
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assertTrue(driver.findElement(By.id("box0")).isDisplayed());

    }
    @Test
    void inputFieldTest() {
        driver.get(baseURL);

        WebElement element=driver.findElement(By.id("reveal"));
        element.click();
        WebElement textField = driver.findElement(By.id("revealed"));
        // wait in total 5 seconds to the songList element to be displayed, check the existence every 500 milliseconds.
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        wait.until(d -> textField.isDisplayed());

        textField.sendKeys("for testing purposes");

        assertEquals("for testing purposes",textField.getDomProperty("value"));

    }

    @AfterEach
    public void finally_(){driver.quit();}
}
