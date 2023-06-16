package net.innovium.sportsstoreuitest.pageobjects;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class OrderTest2 {
    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;


    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net/");

        homePage= new HomePage(driver);
        orderPage= new OrderPage(driver);

    }

    @Test
    public  void order()
    {
        homePage.selectProduct("Chess");
        homePage.addToCart(1);
        homePage.goToCheckout();

        orderPage.enterDetails("John Doe", "ABC Bulv.", "996677 Str.", "No:10", "New York", "NY", "456677", "Turkey");

        orderPage.submitOrder();
        Assertions.assertEquals(orderPage.getConfirmationText(), "Thanks!");
        orderPage.returnToStore();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
