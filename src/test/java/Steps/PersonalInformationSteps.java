package Steps;

import Infrastructure.BrowserWrapper;
import Infrastructure.TestContext;
import Logic.ApiCalls;
import Logic.DashboardPage;
import Logic.PersonalInformationObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertTrue;

public class PersonalInformationSteps {
    public TestContext context;
    private static DashboardPage dashboardPage;

    public PersonalInformationSteps(TestContext context){
        this.context=context;
    }
    @And("I navigated to {string}")
    public void NavigatedToDashboard(String url) {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");

        dashboardPage=browserWrapper.createPage(DashboardPage.class,url);
    }
    @When("I send API request to change my personal information")
    public void sendRequestToUpdatePersonalInformation(DataTable dataTable) throws IOException, InterruptedException {
        List<Map<String, String>> personData = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = personData.getFirst();
        PersonalInformationObject person = new PersonalInformationObject(row.get("first_name"),row.get("last_name"),row.get("phone"),null,Integer.parseInt(row.get("sex_id")),row.get("birthday_date"));
        ApiCalls apiCalls = new ApiCalls();
        HttpResponse response= apiCalls.UpdatePersonalInformation(person.toString());
    }
    @Then("Validate name is updated to {string}")
    public void validateFirstName(String name){
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        dashboardPage=browserWrapper.getCurrentPage();

        int retries=0;
        do {
            try {
                dashboardPage.refreshPage();
                dashboardPage.maximize();
                Thread.sleep(1000);
                retries++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        while(!dashboardPage.isFirstNameUpdated(name) && retries < 5);
        assertTrue(dashboardPage.isFirstNameUpdated(name));

    }
    @And("last name is updated to {string}")
    public void validateLastName(String lastName){
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        dashboardPage=browserWrapper.getCurrentPage();
        assertTrue(dashboardPage.isLastNameUpdated(lastName));

    }
}
