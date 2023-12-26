package Steps;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Logic.AddressApiResponse;
import Logic.AddressBodyRequest;
import Logic.AddressPage;
import Logic.ApiCalls;
import Utils.FullLoginProcess;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static Utils.AddressResponseMethod.getAddressId;
import static Utils.AddressResponseMethod.getAddressesCount;
import static org.testng.AssertJUnit.assertEquals;

public class AddressTestSteps {
    public DriverSetup newDriver;
    public TestContext context;
    private AddressBodyRequest address=null;
    private  WrapApiResponse<AddressApiResponse> result = null;

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
        address = new AddressBodyRequest(null,Integer.parseInt(city_id),city,street,street_number,zip,apartment,null,floor);
        context.put("addressObject",address);
    }

    @And("I send a POST request with the address instance json")
    public void addAnAddress() throws IOException {
        ApiCalls apiCalls = new ApiCalls();
        result = apiCalls.addAddress(address.toString());
    }

    @Then("Verify the given address is added to the list of addresses")
    public void verifyTheGivenAddressIsAddedToTheListOfAddresses() {
        int addressesCount = getAddressesCount(result);
        AddressPage addressPage = new AddressPage(newDriver.getDriver());

        assertEquals(addressesCount,addressPage.getAddressListCount());
    }

    @When("I add the same address twice")
    public void iAddTheSameAddressTwice() throws IOException {
        ApiCalls apiCalls = new ApiCalls();
        result = apiCalls.addAddress(address.toString());
        String addedAddressId = getAddressId(result);
        result=apiCalls.addAddress(address.toString());
        String addedAddressId2 = getAddressId(result);
        context.put("addressID2",addedAddressId2);
    }

    @And("I remove the same address once")
    public void iRemoveTheSameAddressOnce() throws IOException {
        ApiCalls apiCalls = new ApiCalls();
        String addressID = context.get("addressID2");
        WrapApiResponse DeleteResult = apiCalls.deleteAddress(addressID);

    }
    @Then("Validate the address list contains one address")
    public void validateTheAddressListContainsOneAddress() {

    }
}
