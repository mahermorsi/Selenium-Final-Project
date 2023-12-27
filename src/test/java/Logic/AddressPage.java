package Logic;

import Infrastructure.UI.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddressPage extends BasePage {
    // LOCATORS
    private static final By ADDRESS_LIST_ELEMENTS = By.xpath("//div[@class='d-flex flex-wrap py-3 px-5 px-md-3 wrap-addresses']/div");
    Duration timeout = Duration.ofSeconds(10);
    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public int getAddressListCount(){
        return new WebDriverWait(this.driver,timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ADDRESS_LIST_ELEMENTS)).size();
    }

}
