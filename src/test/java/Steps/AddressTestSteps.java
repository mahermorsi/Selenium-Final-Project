package Steps;

import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Logic.AddressBodyRequest;
import Utils.FullLoginProcess;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressTestSteps {
    public DriverSetup newDriver;
    public TestContext context;

    public AddressTestSteps(TestContext context){
        this.context=context;
    }

    @Given("user logged in with credentials {string} and {string}")
    public void userLoggedInWithCredentials(String username,String password) throws InterruptedException {
        FullLoginProcess fullLoginProcess = new FullLoginProcess();
        newDriver = fullLoginProcess.performFullLogin(username, password);
        context.put("driver",newDriver);
        context.put("driver",newDriver);
    }

    @And("navigated to {string}")
    public void navigatedToAddressPage(String url) {
        newDriver.navigateToURL(url);
    }

    @When("I initialize an Address instance with the following fields: {string} {string} {string} {string} {string} {string} {string}")
    public void initializeAddressObject(String city_id,String city,String street,String street_number,String zip,String apartment,String floor) {
        AddressBodyRequest address = new AddressBodyRequest(null,Integer.parseInt(city_id),city,street,street_number,zip,apartment,null,floor);
        context.put("addressObject",address);
    }

    @And("I send a POST request with the address instance json")
    public void addAnAddress() {
        AddressBodyRequest address = context.get("addressObject");
        

    }

    @Then("Verify the given address is added to the list of addresses")
    public void verifyTheGivenAddressIsAddedToTheListOfAddresses() {
    }

    @When("I add the same address twice")
    public void iAddTheSameAddressTwice() {
    }

    @And("I remove the same address once")
    public void iRemoveTheSameAddressOnce() {
    }

    @Then("Validate the address list contains one address")
    public void validateTheAddressListContainsOneAddress() {
    }
}
