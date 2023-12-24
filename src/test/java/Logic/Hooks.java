package Logic;
import Infrastructure.UI.DriverSetup;

public class Hooks {
    public DriverSetup newDriver;

    public Hooks(DriverSetup newDriver) {
        this.newDriver = newDriver;
    }

    public DriverSetup getNewDriver() {
        return newDriver;
    }

    public void setUp() {
        this.newDriver= new DriverSetup();
        this.newDriver.setupDriver("chrome");
        this.newDriver.navigateToURL("https://www.nba.com/stats/leaders");
    }


    public void tearDown() {
        // Code to close the browser
        if (newDriver != null) {
            newDriver.closeDriver();
        }
    }

    public DriverSetup getDriver() {
        return newDriver;
    }


}


