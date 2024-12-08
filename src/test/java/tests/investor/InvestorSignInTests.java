package tests.investor;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.investor.InvestorSignInPage;
import steps.SignInSteps;
import tests.BaseTests;

public class InvestorSignInTests extends BaseTests {
    private WebDriver driver;
    private InvestorSignInPage investorSignInPage;
    private SignInSteps signInSteps;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        investorSignInPage = new InvestorSignInPage(driver);
        signInSteps = new SignInSteps(driver);
    }
}
