package tests.investor;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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

    @Test(description = "MRKTGLD-24 / Check Click on Sign In opens Sign In page with Investor Switch", groups = {"investor sign in"})
    public void checkInvestorSignInSwitch() {
        signInSteps.OpensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getInvestorElementSelected(), "Investor");
    }
}
