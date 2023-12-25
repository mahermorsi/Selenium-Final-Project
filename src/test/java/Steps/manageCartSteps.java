package Steps;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Logic.Enum.Products;
import Logic.ItemApiResponse;
import Logic.LogInPage;
import Logic.MainPage;
import Utils.FullLoginProcess;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class manageCartSteps {
    public DriverSetup newDriver;
    public TestContext context;
    public manageCartSteps(TestContext context) {
        this.context = context;
    }
    @Given("i am logged in the website of Rami levi with credentials {string} and {string}")
    public void iAmLoggedInTheWebsiteOfRamiLevi(String username, String password) throws InterruptedException {
          FullLoginProcess fullLoginProcess = new FullLoginProcess();
          newDriver = fullLoginProcess.performFullLogin(username, password);
          context.put("driver",newDriver);
    }

    @When("i send a POST request to add three products")
    public void iSendAPOSTRequestToAddThreeProducts() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage(newDriver.getDriver());
        List<Products> items = new ArrayList<>(Arrays.asList(Products.FINISH, Products.TEA, Products.CHEESE));
        WrapApiResponse<ItemApiResponse> result = mainPage.addProductsToCart(items);
        context.put("sumOfProducts",result.getData().getItems().size());
        Thread.sleep(3000);
    }

    @Then("the cart should contain three products")
    public void theCartShouldContainThreeProducts() throws IOException, InterruptedException {
        MainPage mainPage = new MainPage(newDriver.getDriver());
        int sum = context.get("sumOfProducts");
        assertEquals(mainPage.validateProductCount(),sum);
        // CLEAN UP
        mainPage.removeAllProductFromCart();
        newDriver.closeDriver();

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
