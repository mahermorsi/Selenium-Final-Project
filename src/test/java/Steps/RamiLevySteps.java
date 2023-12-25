package Steps;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Logic.Hooks;
import Logic.LogInPage;
import Logic.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RamiLevySteps {
    private final TestContext context;
    private DriverSetup newDriver;
    public Hooks hooks;
    //public static DriverSetup newDriver;


    public RamiLevySteps(TestContext context, Hooks hooks) {
        this.context = context;
        if (context.get("driver") != null) {
            newDriver = context.get("driver");
        } else {
            // If the driver is not present in the context, it means login has not occurred.
            // Handle this case accordingly.
            // For simplicity, you may want to throw an exception or log an error.
            throw new IllegalStateException("Driver not found in the context. Login might not have occurred.");
        }
    }

    @Given("On Rami-Levy home page")
    public void onRamiLevyHomePage() {
        MainPage mainPage = new MainPage(newDriver.getDriver());
    }

    @And("Logged in {string} and {string}")
    public void loggedIn(String userName, String password) {
        LogInPage logInPage = new LogInPage(newDriver.getDriver());
        logInPage.clickLogIn();
        logInPage.signIn(userName, password);
        logInPage.clickOnEntrance();
    }

    @When("I add item")
    public void iAddItem(DataTable datatable) {
    }

    @Then("validate cart have 3 items")
    public void validateCartHaveItems(String arg0) {
    }

    @And("Delete one item")
    public void deleteOneItem() {
    }

    @Then("validate item removed")
    public void validateItemRemoved() {
    }

    @And("Get price of item")
    public void getPriceOfItem(DataTable dataTable) {
    }

    @And("Get cart total price")
    public void getCartTotalPrice() {
    }

    @Then("Validate sum equals total")
    public void validateSumEqualsTotal() {
    }

    @And("delete cart")
    public void deleteCart() {
    }

    @Then("validate cart deleted")
    public void validateCartDeleted() {
    }
}
