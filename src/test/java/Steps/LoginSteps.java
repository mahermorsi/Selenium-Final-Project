//package Steps;
//
//import Infrastructure.ConfigurationReader;
//import Infrastructure.TestContext;
//import Infrastructure.UI.DriverSetup;
//import Logic.Hooks;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import Logic.LogInPage;
//
//import static org.junit.Assert.assertTrue;
//
//public class LoginSteps {
//
//    public DriverSetup newDriver;
//    private LogInPage loginPage = null;
//    public TestContext context;
//
//    public LoginSteps(TestContext context) {
//        this.context = context;
//    }
//
//    @Given("Rami-Levy home page")
//    public void ramiLevyHomePage() {
//        this.newDriver= new DriverSetup();
//        this.newDriver.setupDriver("chrome");
//        context.put("driver",newDriver);
//        newDriver.navigateToURL(ConfigurationReader.getUrl());
//        newDriver.getDriver().manage().window().fullscreen();
//    }
//
//    @When("Click Login")
//    public void clickLogin() {
//        loginPage = new LogInPage(newDriver.getDriver());
//        loginPage.clickLogIn();
//    }
//
//    @And("Enter {string} and {string} in popup")
//    public void enterAndInPopup(String email, String password) {
//        loginPage.signIn(email, password);
//    }
//
//    @And("Click Login in popup")
//    public void clickLoginInPopup() {
//        loginPage.clickOnEntrance();
//    }
//
//    @Then("validate logged in")
//    public void validateLoggedIn() {
//        loginPage = new LogInPage(newDriver.getDriver());
//        assertTrue(loginPage.validateLogIn());
//        // CLEAN UP
//        //newDriver.closeDriver();
//    }
//}

package Steps;

import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Logic.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginSteps {


    private final String VALIDATE_USER_ELEMENT = "//span[contains(text(),'maher')]";
    private DriverSetup newDriver;
    private LogInPage loginPage;
    public TestContext context;

    public LoginSteps(TestContext context) {
        this.context = context;
    }

    @Given("a logged-in user with credentials {string} and {string}")
    public void loggedInUser(String email, String password) {
        newDriver = new DriverSetup();
        newDriver.setupDriver("chrome");
        context.put("driver", newDriver);
        // Navigate to the home page and log in
        newDriver.navigateToURL(ConfigurationReader.getUrl());
        newDriver.getDriver().manage().window().fullscreen(); // Use fullscreen instead of maximize

        loginPage = new LogInPage(newDriver.getDriver());
        loginPage.clickLogIn();
        loginPage.signIn(email, password);
        loginPage.clickOnEntrance();
        WebDriverWait wait = new WebDriverWait(newDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VALIDATE_USER_ELEMENT)));

        // Save the context for later use
        context.put("loggedInUser", email);
        context.put("loggedInPassword", password);
        context.put("loginPage", loginPage);
    }

    @Then("validate logged in")
    public void validateLoggedIn() {
        assertTrue(loginPage.validateLogIn());
    }
}


