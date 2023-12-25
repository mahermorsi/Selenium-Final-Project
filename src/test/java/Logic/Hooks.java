package Logic;
import Infrastructure.ConfigurationReader;
import Infrastructure.TestContext;
import Infrastructure.UI.DriverSetup;
import Steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;


public class Hooks {
    public DriverSetup newDriver;

    public Hooks() {

    }

    public DriverSetup getNewDriver() {
        return this.newDriver;
    }
//    @BeforeAll
//    public void beforeAll(){
//
//    }
    @Before
    public void setUp() {
        System.out.println("Test has started");

    }
    @After
    public void tearDown(){
        System.out.println("Test has ENDED");
    }

//    @AfterAll
//    public void cleanEnvironmentAndCloseDriver() {
//        // Code to close the browser
//        if (newDriver != null) {
//            newDriver.closeDriver();
//        }
//    }
}


