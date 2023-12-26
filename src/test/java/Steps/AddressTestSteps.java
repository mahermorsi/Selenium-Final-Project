package Steps;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.BrowserWrapper;
import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Logic.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static Utils.AddressResponseMethod.getAddressId;
import static Utils.AddressResponseMethod.getAddressesCount;
import static org.testng.AssertJUnit.assertEquals;

public class AddressTestSteps {

    public TestContext context;
    private AddressBodyRequest address=null;
    private  WrapApiResponse<AddressApiResponse> result = null;
    private static AddressPage addressPage;

    public AddressTestSteps(TestContext context){
        this.context=context;
    }

    @And("navigated to {string}")
    public void navigatedToAddressPage(String url) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        addressPage = browserWrapper.createPage(AddressPage.class, ConfigurationReader.getUrl());
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
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        addressPage = browserWrapper.getCurrentPage();
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
