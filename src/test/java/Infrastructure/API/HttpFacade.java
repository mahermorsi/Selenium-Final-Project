package Infrastructure.API;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpFacade {
    public static WrapApiResponse sendHttpRequest(String url, HttpMethod method,
                                                  Map<String, String> queryParams,
                                                  String requestBody) throws IOException {
        // create connection
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.getMethod());
       // connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");

//        // set headers
//        for (Map.Entry<String, String> entry : headers.entrySet()) {
//            connection.setRequestProperty(entry.getKey(), entry.getValue());
//        }
        connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
        // set query parameters
        if (queryParams != null) {
            String queryString = queryParams.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining("&"));
            url += "?" + queryString;
        }

            if (requestBody != null && !requestBody.isEmpty()) {
                connection.setDoOutput(true);
                OutputStream os = connection.getOutputStream();
                os.write(requestBody.getBytes());
                os.flush();
                os.close();
            }

        // send request and handle response
        int status = connection.getResponseCode();
        String body = new String(connection.getInputStream().readAllBytes());
        Map<String, String> responseHeaders = connection.getHeaderFields().entrySet()
                .stream()
                .filter(entry -> entry.getKey() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getFirst()));

        return new WrapApiResponse(status, responseHeaders, body);
    }
    public static HttpResponse patchRequest(String url,String jsonBody) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    }
}


