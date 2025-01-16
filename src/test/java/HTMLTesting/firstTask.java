package HTMLTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class firstTask {

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


    @Test
    public void test2() throws InterruptedException {
        driver.navigate().to(baseURL);
        WebElement jumpToPageButton = driver.findElement(By.id("jump-to-page"));
        jumpToPageButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("2");
        alert.accept();
        assertEquals("Paginated Content 2", driver.getTitle());


    }

    @Test
    public void test3() {
        driver.navigate().to(baseURL);
        WebElement buttonToHover = driver.findElement(By.id("next")); // Adjust selector
        String originalColor = buttonToHover.getCssValue("background-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonToHover).perform();
        String hoverColor = buttonToHover.getCssValue("background-color");
        assertTrue(!originalColor.equals(hoverColor), "Color should change on hover.");

        WebElement nonClickableElement = driver.findElement(By.id("page-number1")); // Adjust selector
        String nonClickableColor = nonClickableElement.getCssValue("background-color");
        actions.moveToElement(nonClickableElement).perform();
        String hoverColorNonClickable = nonClickableElement.getCssValue("background-color");
        assertEquals(nonClickableColor, hoverColorNonClickable, "Non-clickable elements shouldn't change color.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
