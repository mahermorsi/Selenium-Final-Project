package Logic;

import Infrastructure.API.HttpFacade;
import Infrastructure.API.HttpMethod;
import Infrastructure.API.WrapApiResponse;
import Infrastructure.ConfigurationReader;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.HashMap;

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

    public HttpResponse removeAllItemsFromCart() throws IOException, InterruptedException {
        String url = "https://www-api.rami-levy.co.il/api/v2/site/cart/delete";
        return HttpFacade.patchRequest(url, null, ConfigurationReader.getEcomToken());
    }

    public HttpResponse UpdatePersonalInformation(String jsonBody) throws IOException, InterruptedException {
        String url = "https://www-api.rami-levy.co.il/api/v2/site/clubs/customer/921083";
        return HttpFacade.putRequest(url, jsonBody, ConfigurationReader.getEcomToken());
    }
}

