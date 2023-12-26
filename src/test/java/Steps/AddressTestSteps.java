package Steps;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.BrowserWrapper;
import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Logic.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import java.util.List;
import java.io.IOException;
import java.util.Map;

import static Utils.AddressResponseMethod.getAddressId;
import static Utils.AddressResponseMethod.getAddressesCount;
import static Utils.ApiResponseParser.getAddressJsonData;
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
        addressPage = browserWrapper.createPage(AddressPage.class, url);
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
        result.setData(getAddressJsonData(result.getData()));
    }

    @Then("Verify the given address is added to the list of addresses")
    public void verifyTheGivenAddressIsAddedToTheListOfAddresses() {
        int addressesCount = getAddressesCount(result);
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        addressPage = browserWrapper.getCurrentPage();
        int retries=0;
        while(addressesCount!=(addressPage.getAddressListCount()) && retries < 5){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            retries++;
        }
        assertEquals(addressesCount,addressPage.getAddressListCount());
    }

    @When("I add the same address twice")
    public void iAddTheSameAddressTwice(DataTable dataTable) throws IOException {
        List<Map<String, String>> addressData = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = addressData.getFirst();
        address = new AddressBodyRequest(null,Integer.parseInt(row.get("city_id")),row.get("city"),row.get("street"),row.get("street_number"),row.get("zip"),row.get("apartment"),null,row.get("floor"));
        ApiCalls apiCalls = new ApiCalls();
        result = apiCalls.addAddress(address.toString());
        result=apiCalls.addAddress(address.toString());
        result.setData(getAddressJsonData(result.getData()));
        String addedAddressId2 = getAddressId(result);
        context.put("addressID2",addedAddressId2);
        int count = getAddressesCount(result);
        context.put("AddressListCount",count);

    }

    @And("I remove the same address once")
    public void iRemoveTheSameAddressOnce() throws IOException {
        ApiCalls apiCalls = new ApiCalls();
        String addressID = context.get("addressID2");
        WrapApiResponse DeleteResult = apiCalls.deleteAddress(addressID);
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        addressPage = browserWrapper.createPage(AddressPage.class);


    }
    @Then("Validate the address list contains one address")
    public void validateTheAddressListContainsOneAddress() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        addressPage = browserWrapper.getCurrentPage();
        int updatedCount = addressPage.getAddressListCount();
        int previousCount = context.get("AddressListCount");
        int retries=0;
        while(previousCount-1!=(updatedCount) && retries < 5){
            try {
                addressPage.refreshPage();
                addressPage.maximize();
                Thread.sleep(1000);
                updatedCount = addressPage.getAddressListCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            retries++;
        }
        assertEquals(previousCount-1,updatedCount);
    }
}
