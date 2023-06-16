package net.innovium.sportsstoreuitest.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {

        this.driver = driver;
    }
    public void enterDetails(String name, String line1, String line2, String line3, String city, String state, String zip, String country) {
        driver.findElement(By.id("Name")).sendKeys(name);
        driver.findElement(By.name("Line1")).sendKeys(line1);
        driver.findElement(By.name("Line2")).sendKeys(line2);
        driver.findElement(By.id("Line3")).sendKeys(line3);
        driver.findElement(By.id("City")).sendKeys(city);
        driver.findElement(By.id("State")).sendKeys(state);
        driver.findElement(By.id("Zip")).sendKeys(zip);
        driver.findElement(By.id("Country")).sendKeys(country);
    }

    public void submitOrder() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
    }

    public String getConfirmationText() {
        return driver.findElement(By.cssSelector("h2")).getText();
    }
    public void returnToStore() {
        driver.findElement(By.linkText("Return to Store")).click();
    }
}
