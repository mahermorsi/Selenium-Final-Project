package Infrastructure.API;
public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    PATCH("PATCH");

    private final String method;

HttpMethod(String method) {
    this.method = method;
}

public String getMethod() {
    return method;
}
}
