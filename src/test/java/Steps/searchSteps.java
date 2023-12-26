package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchSteps {


    @When("I search for product")
    public void iSearchForProduct() {
    }
    @Then("I see the search results for the product")
    public void iSeeTheSearchResultsForTheProduct() {

    }
    @And("validate that URL contains product category")
    public void validateThatURLContainsProductCategory() {
    }

    @When("I click on the {string} category")
    public void iClickOnTheDairyCategory() {
    }

    @Then("validate we are navigated to {string}")
    public void validateWeAreNavigatedTo(String arg0) {
    }
}
