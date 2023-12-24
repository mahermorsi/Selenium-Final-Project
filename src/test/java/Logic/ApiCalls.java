package Logic;

import Infrastructure.API.HttpFacade;
import Infrastructure.API.HttpMethod;
import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;
import Logic.Enum.Products;
import Utils.DateTimeFormat;

import java.io.IOException;
import java.util.HashMap;

public class ApiCalls {
    private final String BASE_URL = ConfigurationReader.getUrl();

    public ApiCalls() {
    }
    public WrapApiResponse addItemsToCart(String jsonBody) throws IOException {
        String url = BASE_URL + "/api/v2/cart";
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("Ecomtoken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3d3dy1hcGkucmFtaS1sZXZ5LmNvLmlsIiwiYXVkIjoiaHR0cHM6Ly93d3ctYXBpLnJhbWktbGV2eS5jby5pbCIsImlhdCI6MTcwMzQyMDA2My41ODk3NjksIm5iZiI6MTcwMzQyMDEyMy41ODk3NjksImV4cCI6MTcwODYwNDA2My41ODk3NjksImlkIjo5MjEwODMsImVtYWlsIjoibWFoZXJtb3JzaUBnbWFpbC5jb20iLCJjaWQiOiI5OTAwMTU3OTMwOSJ9.8FmaaEWNDXAaoCXPtjScU-AlY3TlcB4eduRdyQQRRO8");
        return HttpFacade.sendHttpRequest(url,HttpMethod.POST,null,tokenMap,jsonBody);
    }
//    public static void main(String[] args) throws IOException {
//        // Use the method from the DateTimeFormatterUtil class
//        ConfigurationReader.initializeConfig("config.json");
//        ApiCalls apiCalls = new ApiCalls();
//        WrapApiResponse<ApiResponse> result = null;
//        String store = "279";
//        int isClub = 0;
//        String supplyAt = DateTimeFormat.getCurrentDateTime();
//        HashMap<String,String> items = new HashMap<>();
//        items.put("164854","1.00");
//        items.put(Products.TEA.getId(),"3.00");
//        items.put(Products.FINISH.getId(), "1.00");
//        BodyRequest jsonBody = new BodyRequest(store,isClub,supplyAt,items,null);
//        System.out.println(jsonBody);
//        result= apiCalls.addItemsToCart(jsonBody.toString());
//        System.out.println(result);
//
//    }
}