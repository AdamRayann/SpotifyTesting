package FormTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

public class webFormTest {
    WebDriver driver;

    private static final String baseURL = "https://www.selenium.dev/selenium/web/web-form.html";
    private static final String expectedPageTitle = "Web form";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    void testPageTitle() {
        driver.get(baseURL);

        String pageTitle = driver.getTitle();
        assertEquals(expectedPageTitle, pageTitle);
    }

    @Test
    @Disabled
    void testTestInput() {
        driver.get(baseURL);
        try {
            WebElement textBox = driver.findElement(By.id("my-text-id"));
            textBox.clear();
            textBox.sendKeys("Testing testing ...");
            assertEquals("Testing testing ...",textBox.getDomProperty("value"));

            textBox = driver.findElement(By.name("my-password"));
            textBox.clear();
            textBox.sendKeys("Testing password");
            assertEquals("Testing password",textBox.getDomProperty("value"));

            textBox = driver.findElement(By.name("my-textarea"));
            textBox.clear();
            textBox.sendKeys("Testing Par...");
            assertEquals("Testing Par...",textBox.getDomProperty("value"));

        }catch (Exception e)
        {
            assertEquals(-1,0,"error occurred while inserting text");
        }

    }

    @Test
    void disabledTest() {
        driver.get(baseURL);
        try {
            WebElement disabled = driver.findElement(By.name("my-disabled"));

            assertFalse(disabled.isEnabled());
            assertThrows(Exception.class, () -> {disabled.sendKeys("Testing");});

        }catch (Exception e)
        {
            assertEquals(-1,0,"error occurred testing");
        }

    }

    @Test
    void readOnlyTest() {
        driver.get(baseURL);
        WebElement readonly = driver.findElement(By.name("my-readonly"));
        assertEquals(readonly.getAttribute("readonly"), "true");
    }

    @Test
    void selectTest() {
        driver.get(baseURL);
        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select select = new Select(selectElement);
        select.selectByIndex(0);
        assertEquals("Open this select menu",select.getFirstSelectedOption().getText());
        select.selectByIndex(1);
        assertEquals("One",select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        assertEquals("Two",select.getFirstSelectedOption().getText());
        select.selectByIndex(3);
        assertEquals("Three",select.getFirstSelectedOption().getText());

    }

    @Test
    void dropDownTest() throws InterruptedException {
        driver.get(baseURL);
        WebElement selectElement = driver.findElement(By.name("my-datalist"));
        Select select = new Select(selectElement);
        for(WebElement w : select.getOptions())
        {
            selectElement.clear();
            select.selectByVisibleText(w.getText());
        }

    }
    @AfterEach
    public void endDriver(){driver.quit();}

}
