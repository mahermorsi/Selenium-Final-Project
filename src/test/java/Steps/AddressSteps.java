package Steps;

import Infrastructure.ConfigurationReader;
import Infrastructure.UI.BasePage;
import Infrastructure.UI.DriverSetup;
import Logic.Hooks;
import Logic.Pages.AddressPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddressSteps extends BasePage {
    private AddressPage addressPage;
    private DriverSetup newDriver;
    private final String URL = "https://www.rami-levy.co.il/he/dashboard/addresses";

    private Hooks hooks;

    public AddressSteps(WebDriver driver) {
        super(driver);
        this.hooks = new Hooks(newDriver);
    }


    @Given("logged in")
    public void loggedIn() {
        //log in
    }

    @And("navigate to address page")
    public void navigateToAddressPage() {
        newDriver.navigateToURL(URL);
        addressPage = new AddressPage(driver);
    }

    @When("add the following addresses:")
    public void addAddresses(DataTable dataTable) throws IOException {
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

            addressPage.addAddress(name, cityId, city, street, streetNumber, zipCode, apartment, entrance, floor);
        }
    }

    @Then("validate {string} added")
    public void validateAdded(String addressId) {
        assert(addressPage.checkAddressAdded(addressId));
    }

    @And("delete {string}")
    public void delete(String addressId) {
        addressPage.checkAddressDeleted(addressId);
    }

    @Then("validate {string} deleted")
    public void validateDeleted(String a) {
        addressPage.checkAddressAdded()
    }
}
