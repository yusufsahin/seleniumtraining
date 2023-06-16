package net.innovium.sportsstorewebuitest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowseGoogle {
    private WebDriver driver;

    @Test
    public void browseGoogleHome() {
       ChromeOptions options = new ChromeOptions();
        //Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
       // options.addArguments("--remote-allow-origins=*");

        driver= new ChromeDriver();
        //driver= new FirefoxDriver();
        //driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");

        WebElement searchBox= driver.findElement(By.name("q"));

        searchBox.sendKeys("Selenium");

        searchBox.submit();

    }

}
