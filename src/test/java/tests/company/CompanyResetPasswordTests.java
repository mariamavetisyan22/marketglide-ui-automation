package tests.company;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import tests.BaseTests;

public class CompanyResetPasswordTests extends BaseTests {
    private WebDriver driver;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
    }
}
