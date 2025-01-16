package HTMLTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IframeTest {

    static WebDriver driver;

    private static final String baseURL = "file://C:\\Users\\adamr\\OneDrive\\שולחן העבודה\\BeyonDev4\\selenium_exercises\\pagination\\pagination1.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void test1()
    {
        driver.navigate().to(baseURL);
        for (int i = 1; i < 3; i++) {
            WebElement nextButton = driver.findElement(By.id("next"));
            nextButton.click();
            assertEquals("Paginated Content " + (i+1), driver.getTitle());
        }
        driver.navigate().back();
        assertEquals("Paginated Content 2", driver.getTitle());
        driver.navigate().back();
        assertEquals("Paginated Content 1", driver.getTitle());
        driver.navigate().forward();
        assertEquals("Paginated Content 2", driver.getTitle());
        driver.navigate().forward();
        assertEquals("Paginated Content 3", driver.getTitle());

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
