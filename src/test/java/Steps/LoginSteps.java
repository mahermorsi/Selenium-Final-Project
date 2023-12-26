package Steps;

import Infrastructure.BrowserWrapper;
import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Logic.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Logic.LoginPopUpPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    public TestContext context;
    private static MainPage ramiLevyPage;
    private static LoginPopUpPage loginPage;


    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("I am in Rami-Levy home page")
    public void ramiLevyHomePage() {
        ConfigurationReader.initializeConfig("config.json");
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
        ramiLevyPage = browserWrapper.createPage(MainPage.class, ConfigurationReader.getUrl());
        ramiLevyPage.fullScreen();
    }

    @When("Click Login")
    public void clickLogin() {
        ramiLevyPage.clickLogIn();
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        browserWrapper.createPage(LoginPopUpPage.class);
    }

    @And("Enter {string} and {string} in popup")
    public void enterAndInPopup(String email, String password) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        loginPage = browserWrapper.getCurrentPage();
        loginPage.signIn(email, password);
    }

    @And("Click Login in popup")
    public void clickLoginInPopup() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        loginPage.clickOnEntrance();
        browserWrapper.createPage(MainPage.class);
    }

    @Then("validate logged in")
    public void validateLoggedIn() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        ramiLevyPage = browserWrapper.getCurrentPage();
        assertTrue(ramiLevyPage.validateLogIn());
        // CLEAN UP
        //newDriver.closeDriver();
    }
}



