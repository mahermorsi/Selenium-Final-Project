package Infrastructure;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ConfigurationReader {
    private static ObjectNode configuration;

    public static void initializeConfig(String configFile) {
        try {
            // Read configuration file
            String configContent = new String(Files.readAllBytes(Paths.get(configFile)));

            // Parse JSON content
            ObjectMapper objectMapper = new ObjectMapper();
            configuration = objectMapper.readValue(configContent, ObjectNode.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ObjectNode getConfiguration() {
        if (configuration == null) {
            throw new IllegalStateException("Configuration has not been initialized. Call initializeConfig first.");
        }
        return configuration;
    }
    public static String getUrl() {
        JsonNode urlNode = getConfiguration().get("url");

        if (urlNode == null || urlNode.isNull()) {
            throw new IllegalStateException("URL configuration is missing or null.");
        }

        return urlNode.asText();
    }
    public static String getChromePath() {
        JsonNode chromePathNode = getConfiguration().get("chromePath");

        if (chromePathNode == null || chromePathNode.isNull()) {
            throw new IllegalStateException("Chrome path configuration is missing or null.");
        }

        return chromePathNode.asText();
    }
    public static String getEcomToken() {
        JsonNode ecomToken = getConfiguration().get("Ecomtoken");

        if (ecomToken == null || ecomToken.isNull()) {
            throw new IllegalStateException("Chrome path configuration is missing or null.");
        }

        return ecomToken.asText();
    }

}

