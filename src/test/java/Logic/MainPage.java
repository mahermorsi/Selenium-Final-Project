package Logic;

import Infrastructure.UI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends BasePage {
  // private static final By TABLE_TAG = By.xpath("//tbody");
   // private WebElement tableElement;


    public MainPage(WebDriver driver) {
        super(driver);
        //this.tableElement = this.driver.findElement(TABLE_TAG);

    }
}