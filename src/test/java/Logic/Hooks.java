package Logic;
import Infrastructure.BrowserWrapper;
import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Utils.AddressResponseMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;


public class Hooks {
    public TestContext context;

    public Hooks(TestContext context) {
        this.context=context;
    }
    @Before
    public void setUp() {
        System.out.println("Starting a Scenario");
        ConfigurationReader.initializeConfig("config.json");
        BrowserWrapper browserWrapper = new BrowserWrapper();
        context.put("BrowserWrapper", browserWrapper);
    }
    @After
    public void tearDown() throws IOException, InterruptedException {
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        ApiCalls apiCalls = new ApiCalls();
        apiCalls.removeAllItemsFromCart();
        AddressResponseMethods.deleteAllAddresses(context.get("addressResponse"));
        System.out.println("Scenario ENDED, cleaning environment and closing driver");
        browserWrapper.close();
    }
}


