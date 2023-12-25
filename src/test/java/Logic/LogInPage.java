package Logic;

import Infrastructure.UI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogInPage extends BasePage {
    Duration timeout = Duration.ofSeconds(5);
    private final String LOGIN_BUTTON = "//div[@id='login-user']";
    private final String EMAIL_FEILD = "//*[@id=\"email\"]";
    private final String PASSWORD_FEILD = "//*[@id=\"password\"]";
    private final String ENTRANCE_BTN = "//button[@aria-label='כניסה']";

    private final By VALIDATE_USER_ELEMENT = By.xpath("//span[contains(text(),'maher')]");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogIn() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
    public void enterUserName(String name) {
        driver.findElement(By.xpath(EMAIL_FEILD)).sendKeys(name);
    }

    public void enterPassword(String password) {
        driver.findElement(By.xpath(PASSWORD_FEILD)).sendKeys(password);

    }

    public void signIn(String userName, String Password) {
        this.enterUserName(userName);
        this.enterPassword(Password);
    }

    public void clickOnEntrance() {
        driver.findElement(By.xpath(ENTRANCE_BTN)).click();
    }

    public boolean validateLogIn() {
        driver.manage().window().fullscreen();
        return new WebDriverWait(this.driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(VALIDATE_USER_ELEMENT)).isDisplayed();
    }
}