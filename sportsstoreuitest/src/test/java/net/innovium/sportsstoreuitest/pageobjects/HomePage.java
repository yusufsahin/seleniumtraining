package net.innovium.sportsstoreuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void  selectProduct(String product) {
        driver.findElement(By.linkText(product)).click();
        //Chess categorsindeki ürünlerin yüklenmesi için sync./bekleme
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card:nth-child(1) h4")));
        }
    }
        public void addToCart(int productIndex) {
        driver.findElement(By.xpath("(//button[@type='submit'])[" + productIndex + "]")).click();
            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
            }
    }
    public void goToCheckout() {
        driver.findElement(By.linkText("Checkout")).click();
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        }
    }

}
