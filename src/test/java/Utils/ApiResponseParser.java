package Utils;

import Logic.ApiResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ApiResponse parseJson(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, ApiResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ApiResponse getJsonData(Object data){
        String jsonData=String.valueOf(data);
        return ApiResponseParser.parseJson(String.valueOf(jsonData));
    }
}
