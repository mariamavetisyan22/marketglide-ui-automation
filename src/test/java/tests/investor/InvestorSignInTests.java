package tests.investor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;
import steps.SignInSteps;
import tests.BaseTests;

public class InvestorSignInTests extends BaseTests {
    private WebDriver driver;
    private SignInPage signInPage;
    private SignInSteps signInSteps;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        signInPage = new SignInPage(driver);
        signInSteps = new SignInSteps(driver);
    }
}
