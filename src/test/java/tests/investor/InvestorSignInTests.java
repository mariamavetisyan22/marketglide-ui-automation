package tests.investor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SignInPage;
import tests.BaseTests;

public class InvestorSignInTests extends BaseTests {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
    }
}
