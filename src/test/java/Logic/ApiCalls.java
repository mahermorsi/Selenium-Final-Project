package Logic;

import Infrastructure.API.HttpFacade;
import Infrastructure.API.HttpMethod;
import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;
import Logic.Enum.Products;
import Utils.DateTimeFormat;

import java.io.IOException;
import java.util.HashMap;

import static Utils.ApiResponseParser.getAddressJsonData;
import static Utils.ApiResponseParser.getItemJsonData;

public class ApiCalls {
    private final String BASE_URL = ConfigurationReader.getUrl();

    public ApiCalls() {
    }
    public WrapApiResponse addItemsToCart(String jsonBody) throws IOException {
        String url = BASE_URL + "/api/v2/cart";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Ecomtoken", ConfigurationReader.getEcomToken());
        return HttpFacade.sendHttpRequest(url,HttpMethod.POST,null,headers,jsonBody);
    }
    public WrapApiResponse addAddress(String jsonBody) throws IOException {
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Ecomtoken", ConfigurationReader.getEcomToken());
        return HttpFacade.sendHttpRequest(url, HttpMethod.POST,null,headers,jsonBody);
    }
    public static void main(String[] args) throws IOException {
        // Use the method from the DateTimeFormatterUtil class
        ConfigurationReader.initializeConfig("config.json");
        ApiCalls apiCalls = new ApiCalls();
        WrapApiResponse<AddressApiResponse> addressResult = null;
        WrapApiResponse<ItemApiResponse> itemResult = null;
        String store = "279";
        int isClub = 0;
        String supplyAt = DateTimeFormat.getCurrentDateTime();
        HashMap<String,String> items = new HashMap<>();
        items.put(Products.FINISH.getId(), "2.00");
        items.put(Products.TEA.getId(),"3.00");
        items.put("164854","1.00");
        ItemBodyRequest jsonBody = new ItemBodyRequest(store,isClub,supplyAt,items,null);
        itemResult= apiCalls.addItemsToCart(jsonBody.toString());
        itemResult.setData(getItemJsonData(itemResult.getData()));
        System.out.println(itemResult.getData().getItems().get(1).getPrice());

        // CALL ADDRESS API REQUEST
        String city = "עכברה";
        int city_id = 1337;
        String floor = "12";
        String street = "12";
        String street_number = "12";
        String zip="";
        String apartment="12";
        AddressBodyRequest address = new AddressBodyRequest(null,city_id,city,street,street_number,zip,apartment,null,floor);
        addressResult = apiCalls.addAddress(address.toString());
        addressResult.setData(getAddressJsonData(addressResult.getData()));
        System.out.println(addressResult.getData().getData().getAllAddresses());


    }
}