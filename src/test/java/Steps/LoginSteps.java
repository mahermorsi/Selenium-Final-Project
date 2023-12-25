package Steps;

import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Logic.LogInPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    public DriverSetup newDriver;
    private LogInPage loginPage = null;
    public TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am in Rami-Levy home page")
    public void ramiLevyHomePage() {
        this.newDriver= new DriverSetup();
        this.newDriver.setupDriver("chrome");
        context.put("driver",newDriver);
        newDriver.navigateToURL(ConfigurationReader.getUrl());
        newDriver.getDriver().manage().window().fullscreen();
    }

    @When("Click Login")
    public void clickLogin() {
        loginPage = new LogInPage(newDriver.getDriver());
        loginPage.clickLogIn();
    }

    @And("Enter {string} and {string} in popup")
    public void enterAndInPopup(String email, String password) {
        loginPage.signIn(email, password);
    }

    @And("Click Login in popup")
    public void clickLoginInPopup() {
        loginPage.clickOnEntrance();
    }

    @Then("validate logged in")
    public void validateLoggedIn() {
        loginPage = new LogInPage(newDriver.getDriver());
        assertTrue(loginPage.validateLogIn());
        // CLEAN UP
        //newDriver.closeDriver();
    }
}



