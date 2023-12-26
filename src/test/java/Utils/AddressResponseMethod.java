package Utils;

import Infrastructure.API.WrapApiResponse;
import Logic.AddressApiResponse;
import java.util.Map;

public class AddressResponseMethod {
    public static String getAddressId(WrapApiResponse<AddressApiResponse> addressResult){
        Object[] arr= addressResult.getData().getData().getAllAddresses().keySet().toArray();
        return (String) arr[arr.length-1];
    }
    public static int getAddressesCount(WrapApiResponse<AddressApiResponse> addressResult) {
        Map<String, AddressApiResponse.AddressDetails> addressMap = (Map<String, AddressApiResponse.AddressDetails>) addressResult.getData().getData().getAllAddresses().keySet();
        return addressMap.values().toArray().length;
    }

}