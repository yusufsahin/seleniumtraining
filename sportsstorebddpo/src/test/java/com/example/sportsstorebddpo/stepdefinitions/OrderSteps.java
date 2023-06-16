package com.example.sportsstorebddpo.stepdefinitions;

import com.example.sportsstorebddpo.HomePage;
import com.example.sportsstorebddpo.OrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class OrderSteps {
    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    @Given("User is on sportsstore homepage")
    public void user_is_on_sportsstore_homepage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net/");

        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @When("User clicks on Chess category")
    public void user_clicks_on_chess_category() {
        homePage.selectProduct("Chess");
    }

    @And("User adds Thinking cap to the cart")
    public void user_adds_thinking_cap_to_the_cart() {
        homePage.addToCart(1);
    }

    @And("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        homePage.goToCheckout();
    }

    @And("User fills order information")
    public void user_fills_order_information() {
        orderPage.enterDetails("John Doe", "ABC Bulv.", "996677 Str.", "No:10", "New York", "NY", "456677", "Turkey");
    }

    @Then("User should see order confirmation message")
    public void user_should_see_order_confirmation_message() {
        orderPage.submitOrder();
        Assert.assertEquals(orderPage.getConfirmationText(), "Thanks!");
        orderPage.returnToStore();
        driver.quit();
    }
}
