package Logic;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.UI.BasePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static Utils.ApiResponseParser.getAddressJsonData;

public class AddressPage extends BasePage {
    // LOCATORS

    public AddressPage(WebDriver driver) {
        super(driver);
    }


}
