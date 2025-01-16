import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LibraryPageTest {
    WebDriver driver;

    private static final String baseURL = "http://localhost:8082";
    private static final String expectedPageTitle = "Spotify Clone";
    private static final String expectedPageMessage = "Oops.... Not Available";


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
    void testSingerNameModified() {
        driver.get(baseURL);
        String expectedString="Harry Styles";
        WebElement libraryLink = driver.findElement(By.cssSelector("#popArtists li:nth-of-type(4)"));
        libraryLink.click();

        WebElement pageMessage = driver.findElement(By.cssSelector("#artistContent h1"));
        String pageMessageText = pageMessage.getText();

        assertEquals(expectedString, pageMessageText);

    }

    @Test
    void testSingerSubsModified() {
        driver.get(baseURL);
        String expectedString="117447470 Followers";
        WebElement libraryLink = driver.findElement(By.cssSelector("#popArtists li:nth-of-type(2)"));
        libraryLink.click();

        WebElement pageMessage = driver.findElement(By.cssSelector("#artistContent p"));
        String pageMessageText = pageMessage.getText().strip();

        assertEquals(expectedString, pageMessageText);

    }

    @Test
    void testVolModified() {
        driver.get(baseURL);
        //String expectedString="width: 0%;";
        String expectedString="";
        WebElement libraryLink = driver.findElement(By.cssSelector("#vol"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", libraryLink, "50");
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", libraryLink);

        libraryLink = driver.findElement(By.cssSelector("#vol_icon"));
        libraryLink.click();

        libraryLink = driver.findElement(By.cssSelector("div .vol_bar"));

        assertEquals(expectedString, libraryLink.getAttribute("style"));

    }

    @Test
    void testPageMessage() {
        driver.get(baseURL);

        WebElement libraryLink = driver.findElement(By.cssSelector("a[href='/library']"));
        libraryLink.click();

        WebElement pageMessage = driver.findElement(By.cssSelector("div.content h1"));
        String pageMessageText = pageMessage.getText();

        assertEquals(expectedPageMessage, pageMessageText);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
