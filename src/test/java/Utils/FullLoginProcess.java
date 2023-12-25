package Utils;

import Infrastructure.ConfigurationReader;
import Infrastructure.UI.DriverSetup;
import Logic.LogInPage;

public class FullLoginProcess {

    public DriverSetup performFullLogin(String username, String password) throws InterruptedException {
        DriverSetup newDriver = new DriverSetup();
        newDriver.setupDriver("chrome");
        newDriver.navigateToURL(ConfigurationReader.getUrl());
        newDriver.getDriver().manage().window().fullscreen();
        LogInPage loginPage = new LogInPage(newDriver.getDriver());
        loginPage.fullProcessLogin(username, password);
        Thread.sleep(5000);

        return newDriver;
    }
}
