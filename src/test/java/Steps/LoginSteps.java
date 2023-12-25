package Steps;

import Infrastructure.ConfigurationReader;
import Infrastructure.UI.DriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Logic.LogInPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    private WebDriver driver;
    public static DriverSetup newDriver;
    private LogInPage loginPage = null;


    @Given("Rami-Levy home page")
    public void ramiLevyHomePage() {
        ConfigurationReader.initializeConfig("config.json");
        newDriver= new DriverSetup();
        newDriver.setupDriver("chrome");
        newDriver.navigateToURL(ConfigurationReader.getUrl());
        loginPage = new LogInPage(newDriver.getDriver());
    }

    @When("Click Login")
    public void clickLogin() {
        loginPage.clickLogIn();
    }

    @And("Enter {string} and {string} in popup")
    public void enterAndInPopup(String email, String password) {
        loginPage.signIn(email, password);
    }

    @And("Click Login in popup")
    public void clickLoginInPopup() throws InterruptedException {
        loginPage.clickOnEntrance();
    }

    @Then("validate logged in")
    public void validateLoggedIn() {
        loginPage = new LogInPage(newDriver.getDriver());
        assertTrue(loginPage.validateLogIn());
        // CLEAN UP
        newDriver.closeDriver();
    }
}
