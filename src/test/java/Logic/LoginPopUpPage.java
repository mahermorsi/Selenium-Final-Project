package Logic;

import Infrastructure.UI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPopUpPage extends BasePage {
    Duration timeout = Duration.ofSeconds(5);

    private static final By EMAIL_FEILD = By.xpath("//*[@id=\"email\"]");
    private static final By PASSWORD_FEILD = By.xpath("//*[@id=\"password\"]");
    private static final String ENTRANCE_BTN = "//button[@aria-label='כניסה']";



    public LoginPopUpPage(WebDriver driver) {
        super(driver);
    }


    public void enterUserName(String name) {
        new WebDriverWait(this.driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(EMAIL_FEILD)).sendKeys(name);
    }

    public void enterPassword(String password) {
        new WebDriverWait(this.driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FEILD)).sendKeys(password);

    }

    public void signIn(String userName, String Password) {
        this.enterUserName(userName);
        this.enterPassword(Password);
    }

    public void clickOnEntrance() {
        new WebDriverWait(this.driver, timeout)
                .until(ExpectedConditions
                        .elementToBeClickable(By.xpath(ENTRANCE_BTN))).click();
        driver.findElement((PASSWORD_FEILD)).sendKeys(Keys.ENTER);
    }

    public void performLogin(String username,String password){
        enterUserName(username);
        enterPassword(password);
        clickOnEntrance();
    }


}