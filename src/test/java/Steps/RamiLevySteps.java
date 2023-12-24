package Steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RamiLevySteps {
    @Given("On Rami-Levy home page")
    public void onRamiLevyHomePage() {
    }

    @And("Logged in")
    public void loggedIn(DataTable dataTable) {
    }

    @When("I add item")
    public void iAddItem() {
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
