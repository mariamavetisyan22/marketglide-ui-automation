package tests;

import configs.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class BaseTests {

    @Getter
    private static WebDriver driver;

    private static String demoUrl;

    @BeforeTest
    public void loadConfiguration() {
        Configuration.loadPropertyFile();
        demoUrl = Configuration.getWebUrl();
    }

    @BeforeMethod(groups = {"homepage", "company sign in", "investor sign in"})
    public void setUp() {
        switch (Configuration.BROWSER.toLowerCase()) {
            case Configuration.FIREFOX_BROWSER:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case Configuration.EDGE_BROWSER:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case Configuration.SAFARI_BROWSER:
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        goToUrl();
    }

    protected void goToUrl() {
        driver.get(demoUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
