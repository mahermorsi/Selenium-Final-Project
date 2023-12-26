package Logic;
import Infrastructure.BrowserWrapper;
import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import com.beust.jcommander.FuzzyMap;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;


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
    public void tearDown(){
        BrowserWrapper browserWrapper = context.get("BrowserWrapper");
        browserWrapper.close();
        System.out.println("Scenario ENDED, closing driver");
    }
}


