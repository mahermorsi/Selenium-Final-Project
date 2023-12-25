package Logic;
import Infrastructure.ConfigurationReader;
import Infrastructure.UI.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    public DriverSetup newDriver;

    public Hooks(DriverSetup newDriver) {
        this.newDriver = newDriver;
    }

    public DriverSetup getNewDriver() {
        return newDriver;
    }
    @Before
    public void setUp() {
        this.newDriver= new DriverSetup();
        this.newDriver.setupDriver("chrome");
        this.newDriver.navigateToURL(ConfigurationReader.getUrl());
    }

    @After
    public void tearDown() {
        // Code to close the browser
        if (newDriver != null) {
            newDriver.closeDriver();
        }
    }
}


