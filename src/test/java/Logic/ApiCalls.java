package Logic;

import Infrastructure.API.HttpFacade;
import Infrastructure.API.HttpMethod;
import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;
import Logic.Enum.Products;
import Utils.AddressResponseMethod;
import Utils.DateTimeFormat;

import java.io.IOException;
import java.net.http.HttpResponse;
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
        return HttpFacade.sendHttpRequest(url, HttpMethod.POST, null, headers, jsonBody);
    }

    public WrapApiResponse addAddress(String jsonBody) throws IOException {
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses";
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Ecomtoken", ConfigurationReader.getEcomToken());
        return HttpFacade.sendHttpRequest(url, HttpMethod.POST, null, headers, jsonBody);
    }

    public WrapApiResponse deleteAddress(String addressID) throws IOException {
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/addresses/" + addressID;
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Ecomtoken", ConfigurationReader.getEcomToken());
        return HttpFacade.sendHttpRequest(url, HttpMethod.DELETE, null, headers, null);

    }

    public HttpResponse removeAllItemsFromCart(String string) throws IOException, InterruptedException {
        String url = "https://www-api.rami-levy.co.il/api/v2/site/cart/delete";
        return HttpFacade.patchRequest(url, null, ConfigurationReader.getEcomToken());
    }

    public HttpResponse UpdatePersonalInformation(String jsonBody) throws IOException, InterruptedException {
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/customer/921083";
        return HttpFacade.putRequest(url, jsonBody, ConfigurationReader.getEcomToken());
    }

//    public static void main(String[] args) throws IOException, InterruptedException {
//        ConfigurationReader.initializeConfig("config.json");
//        ApiCalls apiCalls = new ApiCalls();
//        // UPDATE PERSONAL INFORMATION
//        PersonalInformationObject person = new PersonalInformationObject("tzahi","andigar","054-3343434",null,1,"1980-10-23");
//        HttpResponse response = apiCalls.UpdatePersonalInformation(person.toString());
//        System.out.println(response);

//        WrapApiResponse<ItemApiResponse> itemResult;
//        String store = "279";
//        int isClub = 0;
//        String supplyAt = DateTimeFormat.getCurrentDateTime();
//        HashMap<String,String> items = new HashMap<>();
//        //items.put(Products.FINISH.getId(), "2.00");
//        items.put(Products.TEA.getId(),"3.00");
//        items.put("164854","1.00");
//        ItemBodyRequest jsonBody = new ItemBodyRequest(store,isClub,supplyAt,items,null);
//        itemResult= apiCalls.addItemsToCart(jsonBody.toString());
//        itemResult.setData(getItemJsonData(itemResult.getData()));
//        System.out.println("sum prices of 2 FINISH and 3 TEA is: "+ getSumOfProductsPrices(itemResult));

////       //  CALL ADDRESS API REQUEST
//        WrapApiResponse<AddressApiResponse> addressResult;
//
//        String city = "עכברה";
//        int city_id = 1337;
//        String floor = "12";
//        String street = "12";
//        String street_number = "12";
//        String zip = "";
//        String apartment = "12";
//
//        AddressBodyRequest address = new AddressBodyRequest(null, city_id, city, street, street_number, zip, apartment, null, floor);
//        addressResult = apiCalls.addAddress(address.toString());
//        addressResult.setData(getAddressJsonData(addressResult.getData()));
//        int count=AddressResponseMethod.getAddressesCount(addressResult);
//        System.out.println("addresses count is :"+ count );
//        Object[] arr = addressResult.getData().getData().getAllAddresses().keySet().toArray();
//        System.out.println("created address with id" + (String) arr[0]);
//
//        // DELETE A GIVEN ADDRESS
//        WrapApiResponse result;
//        result= apiCalls.deleteAddress((String) arr[arr.length-1]);
//        System.out.println(result.getData());
//
////
//        // EMPTY CART
//        HttpResponse emptyItemResult=apiCalls.removeAllItemsFromCart();
//        System.out.println(emptyItemResult);
    //}
}

