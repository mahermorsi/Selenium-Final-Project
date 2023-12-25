package Logic;

import Infrastructure.UI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogInPage extends BasePage {
    Duration timeout = Duration.ofSeconds(5);
    private final By LOGIN_BUTTON = By.xpath("//div[@id='login-user']");
    private final By EMAIL_FEILD = By.xpath("//*[@id=\"email\"]");
    private final By PASSWORD_FEILD = By.xpath("//*[@id=\"password\"]");
    private final String ENTRANCE_BTN = "//button[@aria-label='כניסה']";

    private final By VALIDATE_USER_ELEMENT = By.xpath("//span[contains(text(),'maher')]");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogIn() {
        new WebDriverWait(this.driver, timeout)
                .until(ExpectedConditions
                        .elementToBeClickable(LOGIN_BUTTON)).click();
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

    public void fullProcessLogin(String username,String password){
        clickLogIn();
        enterUserName(username);
        enterPassword(password);
        clickOnEntrance();
    }

    public boolean validateLogIn() {
        driver.manage().window().fullscreen();
        return new WebDriverWait(this.driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(VALIDATE_USER_ELEMENT)).isDisplayed();
    }
}