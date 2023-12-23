package Infrastructure.UI;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public void refreshPage(){
        driver.navigate().refresh();

    }
}
