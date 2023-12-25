package Utils;

import Logic.AddressApiResponse;
import Logic.ItemApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static AddressApiResponse parseAddressJson(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, AddressApiResponse.class);
        } catch (Exception e) {
               e.printStackTrace();
            return null;
        }
    }
    public static AddressApiResponse getAddressJsonData(Object data){
        String jsonData=String.valueOf(data);
        return ApiResponseParser.parseAddressJson(String.valueOf(jsonData));
    }
    public static ItemApiResponse parseItemJson(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, ItemApiResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ItemApiResponse getItemJsonData(Object data){
        String jsonData=String.valueOf(data);
        return ApiResponseParser.parseItemJson(String.valueOf(jsonData));
    }


}
