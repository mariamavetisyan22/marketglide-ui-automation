package configs;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {

    public static final String CHROME_BROWSER = "chrome";
    public static final String FIREFOX_BROWSER = "firefox";
    public static final String EDGE_BROWSER = "edge";
    public static final String SAFARI_BROWSER = "safari";

    public static final String DEMO = "demo";
    public static final String PROD = "prod";

    public static final String BROWSER = System.getProperty("browser", CHROME_BROWSER);

    public static final String WEB_PROP_PATH = "src/main/resources/configs/demo.properties";

    private static final Properties properties = new Properties();

    @Getter
    public static String COMPANY_EMAIL;
    @Getter
    public static String INVESTOR_EMAIL;
    @Getter
    public static String PASSWORD;
    @Getter
    private static String webUrl;

    @SneakyThrows
    public static void loadPropertyFile() {
        try (InputStream inputStream = Files.newInputStream(Paths.get(WEB_PROP_PATH))) {
            properties.load(inputStream);
            webUrl = properties.getProperty("demo.url");
            COMPANY_EMAIL = properties.getProperty("company.email");
            INVESTOR_EMAIL = properties.getProperty("investor.email");
            PASSWORD = properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }
}
