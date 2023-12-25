package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class manageCartSteps {
    @Given("i am logged in the website of Rami levi")
    public void iAmLoggedInTheWebsiteOfRamiLevi() {
    }

    @When("i send a POST request to add three products")
    public void iSendAPOSTRequestToAddThreeProducts() {
    }

    @Then("the cart should contain three products")
    public void theCartShouldContainThreeProducts() {
    }

    @And("validate the product count from the UI")
    public void validateTheProductCountFromTheUI() {
    }

    @When("i send a Post request to add two products")
    public void iSendAPostRequestToAddTwoProducts() {
    }

    @And("i calculate the sum of these products")
    public void iCalculateTheSumOfTheseProducts() {
    }

    @Then("validate the total sum element from the page to the calculated sum")
    public void validateTheTotalSumElementFromThePageToTheCalculatedSum() {
    }

    @When("i send a delete request")
    public void iSendADeleteRequest() {
    }

    @Then("validate that the cart is empty")
    public void validateThatTheCartIsEmpty() {
    }
}
