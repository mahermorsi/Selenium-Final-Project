package Logic.Pages;

import Infrastructure.UI.BasePage;
import Logic.AddressBodyRequest;
import Logic.ApiCalls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AddressPage extends BasePage {

    private final String FLEX_DIV_XPATH = "//div[contains(@class, 'wrap-addresses')]";
    private WebElement address;
    private ApiCalls apiCalls;
    private WebElement flexDiv;

    public AddressPage(WebDriver driver) {
        super(driver);
        this.apiCalls = new ApiCalls();
        this.flexDiv = driver.findElement(By.xpath(FLEX_DIV_XPATH));
    }
    public void addAddress(String name, int cityId, String city, String street, String streetNumber, String zipCode, String apartment, String entrance, String floor) throws IOException {
        apiCalls.addAddress(new AddressBodyRequest(name,cityId,city,street,streetNumber, zipCode,apartment,entrance,floor).toString());
    }
    public void de
    public boolean checkAddressAdded(String addressID){
        String path = "//label[@for='address_"+addressID+"']";
        try{
            address = flexDiv.findElement(By.xpath(path));
        }catch(Exception e){
            e.printStackTrace();;
        }
        return address!= null;

    }
    public boolean checkAddressDeleted(String addressID){
        String path = "//label[@for='address_"+addressID+"']";
        address = flexDiv.findElement(By.xpath(path));
        try{
            apiCalls.deleteAddress(addressID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return address == null;
    }
}
