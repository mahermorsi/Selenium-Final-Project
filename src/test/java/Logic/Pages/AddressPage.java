package Logic.Pages;

import Infrastructure.API.WrapApiResponse;
import Infrastructure.UI.BasePage;
import Logic.AddressApiResponse;
import Logic.AddressBodyRequest;
import Logic.ApiCalls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AddressPage extends BasePage {

    private final String FLEX_DIV_XPATH = "//div[contains(@class, 'add-address')]";
    private WebElement address;
    private ApiCalls apiCalls;
    private WebElement flexDiv;
    private WrapApiResponse<AddressApiResponse> result;

    public AddressPage(WebDriver driver) {
        super(driver);
        this.apiCalls = new ApiCalls();
        //this.flexDiv = driver.findElement(By.xpath(FLEX_DIV_XPATH));
    }
    public WrapApiResponse<AddressApiResponse> addAddress(String name, int cityId, String city, String street, String streetNumber, String zipCode, String apartment, String entrance, String floor) throws IOException {
        result = apiCalls.addAddress(new AddressBodyRequest(
                name,cityId,city,street,streetNumber, zipCode,apartment,entrance,floor)
                .toString());
        return result;

        //System.out.println("Add Result: "+result.getData().toString());

    }

    public boolean checkAddressAdded(String addressID){
        String path = "//label[@for='address_"+addressID+"']";
        try{
            address = flexDiv.findElement(By.xpath(path));
        }catch(Exception e){
            e.printStackTrace();;
        }
        return address!= null;

    }
    public void deleteAddress(String addressID) throws IOException {
        result = apiCalls.deleteAddress(addressID);
        System.out.println("Delete Result: "+result.getData().toString());
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
