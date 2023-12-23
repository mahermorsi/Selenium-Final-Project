package Logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponse {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("error")
    private String error;



    @JsonCreator
    public ApiResponse(@JsonProperty("success") boolean success,
                       @JsonProperty("error") String error) {
        this.success=success;
        this.error=error;

    }
}
