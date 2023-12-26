package Steps;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Logic.AddressApiResponse;
import Logic.ApiCalls;
import Logic.Pages.AddressPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static Utils.ApiResponseParser.getAddressJsonData;
import static org.junit.Assert.assertTrue;

public class outdated_addressSteps {
    private final String URL = "https://www.rami-levy.co.il/he/dashboard/addresses";
    private final String WRAP_ADDRESSES = "//div[contains(@class,\"wrap-addresses\")]";
    public TestContext context;
    private DriverSetup newDriver;
    private AddressPage addressPage;
    private WebElement wrapAddresses;

    public outdated_addressSteps(TestContext context) {
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

    @And("navigate to address page")
    public void navigateToAddressPage() throws InterruptedException {
        this.newDriver.navigateToURL(URL);
        // Ensure the driver is fullscreen or maximized as needed
        this.newDriver.getDriver().manage().window().fullscreen(); // or maximize()

        // Create the addressPage instance
        this.addressPage = new AddressPage(newDriver.getDriver());
    }

    @When("add the following addresses:")
    public void addAddresses(io.cucumber.datatable.DataTable dataTable) throws IOException {
        List<Map<String, String>> addresses = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> address : addresses) {
            String name = address.get("Name");
            int cityId = Integer.parseInt(address.get("CityId"));
            String city = address.get("City");
            String street = address.get("Street");
            String streetNumber = address.get("StreetNumber");
            String zipCode = address.get("ZipCode");
            String apartment = address.get("Apartment");
            String entrance = address.get("Entrance");
            String floor = address.get("Floor");

            WrapApiResponse<AddressApiResponse> response = addressPage.addAddress(
                    name, cityId, city, street, streetNumber, zipCode, apartment, entrance, floor);
            response.setData(getAddressJsonData(response.getData()));
            System.out.println("Address added: "+response.getData());
            context.put("AddAddressResponse", response);
        }
    }

    @Then("validate address added")
    public void validateAddressAdded() {
        wrapAddresses = newDriver.getDriver().findElement(By.xpath(WRAP_ADDRESSES));
        assertTrue(wrapAddresses.isDisplayed());
    }


    @And("delete added address")
    public void deleteAddedAddress() throws IOException {
        addressPage.refreshPage();
        WebDriverWait wait = new WebDriverWait(newDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WRAP_ADDRESSES)));
        AddressApiResponse added = context.get("addAddressResponse");
        System.out.println("added= "+added.getData().toString());
        Object[] addresses = added.getData().getAllAddresses().keySet().toArray();
        ApiCalls apiCalls = new ApiCalls();
        apiCalls.deleteAddress((String)addresses[addresses.length-1]);
    }
}
