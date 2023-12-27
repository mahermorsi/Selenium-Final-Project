package Steps;

import Infrastructure.BrowserWrapper;
import Infrastructure.TestContext;
import Logic.SearchPom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class searchSteps {
    public TestContext context;

    public searchSteps(TestContext context){
        this.context=context;
    }
    @Given("I navigated to {string}")
    public void openWebsite(String url) {
        BrowserWrapper browserWrapper =context.get("BrowserWrapper");
        browserWrapper.maximize();
        SearchPom searchPom = browserWrapper.createPage(SearchPom.class, url);
    }

    @When("I search for bread")
    public void iSearchForProduct() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchPom searchPom = browserWrapper.getCurrentPage();
        searchPom.searchForAProduct();
    }

    @And("validate that the page contains bread category")
    public void validateThatURLContainsProductCategory() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchPom searchPom = browserWrapper.getCurrentPage();
        Assert.assertTrue(searchPom.checkElement());
    }

    @When("I click on the Dairy category")
    public void iClickOnTheDairyCategory() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchPom searchPom = browserWrapper.getCurrentPage();
        searchPom.navigateToDairy();
    }

    @Then("validate we are navigated to the correct section")
    public void validateWeAreNavigatedTo() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchPom searchPom = browserWrapper.getCurrentPage();
        Assert.assertTrue(searchPom.checkDairyUrl());
    }

    @When("i search for bread products")
    public void iSearchForAProduct() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchPom searchPom = browserWrapper.getCurrentPage();
        searchPom.searchForAProduct();
    }

    @And("i filter by the brand fitness")
    public void iFilterByBrand() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchPom searchPom = browserWrapper.getCurrentPage();
        searchPom.filterByBrand();
    }

    @Then("validate that the products are filtered accordingly")
    public void validateThatTheProductsAreFilteredAccordingly() {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        SearchPom searchPom = browserWrapper.getCurrentPage();
        searchPom.validateFilterResult();
    }
}
