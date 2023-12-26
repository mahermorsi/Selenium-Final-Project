package Steps;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.BrowserWrapper;
import Infrastructure.TestContext;
import static Utils.ItemResponseMethods.getSumOfProductsPrices;
import Logic.Enum.Products;
import Logic.ItemApiResponse;
import Logic.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class manageCartSteps {

    public TestContext context;
    private static MainPage mainPage;
    public manageCartSteps(TestContext context) {
        this.context = context;
    }

    @When("i send a POST request to add three products")
    public void iSendAPOSTRequestToAddThreeProducts() throws IOException, InterruptedException {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        mainPage = browserWrapper.getCurrentPage();
        List<Products> items = new ArrayList<>(Arrays.asList(Products.FINISH, Products.TEA, Products.CHEESE));
        WrapApiResponse<ItemApiResponse> result = mainPage.addProductsToCart(items);
        context.put("productCount",result.getData().getItems().size());
        Thread.sleep(2000);
        mainPage.refreshPage();
        browserWrapper.createPage(MainPage.class);
    }

    @Then("the cart should contain three products")
    public void theCartShouldContainThreeProducts() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        mainPage = browserWrapper.getCurrentPage();
        int sum = context.get("productCount");
        int retries = 0;
        while(sum!=(mainPage.validateProductCount()) && retries < 7){
            try {
                mainPage.refreshPage();
                mainPage.maximize();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            retries++;
        }
        assertEquals(mainPage.validateProductCount(),sum);
    }

    @When("i send a Post request to add two products")
    public void iSendAPostRequestToAddTwoProducts() throws IOException, InterruptedException {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        mainPage = browserWrapper.getCurrentPage();
        List<Products> items = new ArrayList<>(Arrays.asList(Products.FINISH, Products.TEA));
        WrapApiResponse<ItemApiResponse> result = mainPage.addProductsToCart(items);
        context.put("addTwoProductResponse",result);
        browserWrapper.createPage(MainPage.class);
    }

    @And("i calculate the sum of these products")
    public void iCalculateTheSumOfTheseProducts() {
        double totalSum = getSumOfProductsPrices(context.get("addTwoProductResponse"));
        context.put("totalPrice",totalSum);
    }

    @Then("validate the total sum element from the page to the calculated sum")
    public void validateTheTotalSumElementFromThePageToTheCalculatedSum() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        double totalSum = context.get("totalPrice");
        mainPage = browserWrapper.getCurrentPage();
        double UItotalPrice = mainPage.getTotalPrice();
        int retries = 0;
        while(totalSum!=(UItotalPrice) && retries < 5){
            try {
                mainPage.refreshPage();
                mainPage.maximize();
                Thread.sleep(2000);

                UItotalPrice = mainPage.getTotalPrice();
            } catch (InterruptedException e) {
               throw new RuntimeException(e);
            }
            retries++;
        }
        assertEquals(UItotalPrice,totalSum);
    }


    @When("i send a delete request")
    public void iSendADeleteRequest() throws IOException, InterruptedException {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        mainPage = browserWrapper.getCurrentPage();
        HttpResponse result = mainPage.removeAllProductsFromCart();
        context.put("removedProductsResponse",result);
    }

    @Then("validate that the cart is empty")
    public void validateThatTheCartIsEmpty() {
        HttpResponse result = context.get("removedProductsResponse");
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        mainPage = browserWrapper.getCurrentPage();
        assertEquals(200,result.statusCode());
        int retries = 0;
        while(!mainPage.checkIfCartIsEmpty() && retries < 5){
            try {
                mainPage.refreshPage();
                mainPage.maximize();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            retries++;
        }
        assertTrue(mainPage.checkIfCartIsEmpty());
    }
}
