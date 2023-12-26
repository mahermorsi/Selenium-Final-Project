package Logic;
import Infrastructure.UI.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {
    public DriverSetup newDriver;

    public Hooks() {

    }

    public DriverSetup getNewDriver() {
        return this.newDriver;
    }

//    @BeforeAll
//    public void beforeAll(){
//        ConfigurationReader.initializeConfig("config.json");
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


