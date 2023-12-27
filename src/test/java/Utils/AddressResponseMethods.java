package Utils;

import Infrastructure.API.WrapApiResponse;
import Logic.AddressApiResponse;
import Logic.ApiCalls;

import java.io.IOException;
import java.util.Set;

public class AddressResponseMethods {
    public static String getAddressId(WrapApiResponse<AddressApiResponse> addressResult){
        Object[] arr= addressResult.getData().getData().getAllAddresses().keySet().toArray();
        return (String) arr[arr.length-1];
    }
    public static int getAddressesCount(WrapApiResponse<AddressApiResponse> addressResult) {
        return addressResult.getData().getData().getAllAddresses().keySet().size();
    }
    public static void deleteAllAddresses(Set<String> addressList) {
        if (!addressList.isEmpty()) {
            ApiCalls apiCalls = new ApiCalls();
            addressList.forEach(key -> {
                try {
                    apiCalls.deleteAddress(key);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
