package test.java.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private String propertyFilePath = System.getProperty("user.dir") + "/src/test/resources/configuration.properties";
    private String baseUrl;
    private String requestUrl;

    private PropertyManager() {}

    private static class PropertyManagerHelper {
        private static final PropertyManager INSTANCE = new PropertyManager();
    }

    // Create a Singleton instance. We need only one instance of Property Manager
    public static PropertyManager getInstance() {

        instance = PropertyManagerHelper.INSTANCE;
        instance.loadData();
        return instance;
    }

    // load data from config file
    private void loadData() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }

        baseUrl = prop.getProperty("baseUrl");
        requestUrl = prop.getProperty("requestUrl");
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getRequestUrl() {
        return requestUrl;
    }
}
