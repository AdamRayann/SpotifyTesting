package OnlineBoutiqueTesting;
import org.example.DriverFactory;

import org.example.*;
import org.example.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.example.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class POMOnlineBoutiqueTest {
    private WebDriver driver;
    private BoutiqueHomePage homePage;

    @BeforeEach
    public void setUp() throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");   // to launch Chrome without GUI

        driver =  getDriver();

        homePage = new BoutiqueHomePage(driver).get();
    }
//    @BeforeEach
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        homePage = new BoutiqueHomePage(driver).get();
//    }
    @Test
    public void buyingProduct1()
    {

        int index = 1;
        boolean isOrderSuccessful = homePage.getProduct(index)
                .addToTheCart()
                .placeOrder()
                .orderStatus();

        assertTrue(isOrderSuccessful, "The order was not placed successfully.");

    }

    @Test
    public void test1() throws InterruptedException {


        int index = 1;
        boolean isOrderSuccessful = homePage.getProduct(index)
                .addToTheCart()
                .placeOrder()
                .orderStatus();

        assertTrue(isOrderSuccessful, "The order was not placed successfully.");

    }

    @Test
    public void test2() throws InterruptedException {


        int index = 2;
        boolean isOrderSuccessful = homePage.getProduct(index)
                .addToTheCart()
                .placeOrder()
                .orderStatus();

        assertTrue(isOrderSuccessful, "The order was not placed successfully.");

    }

    @Test
    public void test3() throws InterruptedException {


        int index = 3;
        boolean isOrderSuccessful = homePage.getProduct(index)
                .addToTheCart()
                .placeOrder()
                .orderStatus();

        assertTrue(isOrderSuccessful, "The order was not placed successfully.");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
