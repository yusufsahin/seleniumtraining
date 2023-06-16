package net.innovium.sportsstoreuitestpo;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // path to your feature file
        glue = "net.innovium.sportsstoreuitestpo",  // path to your step definition file
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}