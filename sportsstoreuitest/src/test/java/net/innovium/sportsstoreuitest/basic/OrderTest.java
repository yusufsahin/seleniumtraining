package net.innovium.sportsstoreuitest.basic;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderTest {
    private WebDriver driver;

    @BeforeEach
    public  void setup()
    {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net/");
    }

    @Test
    public void order() {
            driver.findElement(By.linkText("Chess")).click();
            //Chess categorsindeki ürünlerin yüklenmesi için sync./bekleme
            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card:nth-child(1) h4")));
            }

            //Thinking cap sepete ekle
            driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

            //Sepeti görüntülenmesi için senk./bekleme
            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
            }

            //Checkout Click
            driver.findElement(By.linkText("Checkout")).click();

            //Bekleme Sync
            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
            }

            //Order
            driver.findElement(By.id("Name")).sendKeys("John Doe");
            driver.findElement(By.name("Line1")).sendKeys("ABC Bulv.");
            driver.findElement(By.name("Line2")).sendKeys("996677 Str.");
            driver.findElement(By.id("Line3")).sendKeys("No:10");
            driver.findElement(By.id("City")).sendKeys("New York");
            driver.findElement(By.id("State")).sendKeys("NY");
            driver.findElement(By.id("Zip")).sendKeys("456677");
            driver.findElement(By.id("Country")).sendKeys("Turkey");
            //driver.findElement(By.xpath("//input[contains(@class,'btn btn-primary')]")).click();
            driver.findElement(By.cssSelector(".btn-primary")).click();

            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
            }
            Assertions.assertEquals(driver.findElement(By.cssSelector("h2")).getText(),"Thanks!");
            driver.findElement(By.linkText("Return to Store")).click();


    }

    @AfterEach
    public void tearDown () {
        ///driver.navigate().refresh();

        driver.quit();
    }
}
