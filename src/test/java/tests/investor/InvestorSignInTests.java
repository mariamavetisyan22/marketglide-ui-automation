package tests.investor;

import configs.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.investor.InvestorDashboardPage;
import pages.investor.InvestorSignInPage;
import steps.SignInSteps;
import tests.BaseTests;

public class InvestorSignInTests extends BaseTests {
    private WebDriver driver;
    private InvestorSignInPage investorSignInPage;
    private InvestorDashboardPage investorDashboardPage;
    private SignInSteps signInSteps;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        investorSignInPage = new InvestorSignInPage(driver);
        investorDashboardPage = new InvestorDashboardPage(driver);
        signInSteps = new SignInSteps(driver);
    }

    @Test(description = "MRKTGLD-24 / Check Click on Sign In opens Sign In page with Investor Switch", groups = {"investor sign in"})
    public void checkInvestorSignInSwitch() {
        signInSteps.OpensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getInvestorElementSelected(), "Investor");
    }

    @Test(description = "MRKTGLD-25 / Check Sign In Page Title", groups = {"investor sign in"})
    public void checkInvestorSignInPageTitle() {
        signInSteps.OpensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getPageTitle(), "Welcome back");
    }

    @Test(description = "MRKTGLD-26 / Check Investor Sign In with valid credentials", groups = {"investor sign in"})
    public void checkInvestorValidSignIn() {
        signInSteps.OpensInvestorSignInPage();

        investorSignInPage.sendEmail(Configuration.INVESTOR_EMAIL)
                .sendPassword(Configuration.PASSWORD)
                .clickToSignIn();
        Assert.assertTrue(investorDashboardPage.getInvestorName().contains("Welcome to Dashboard"));
    }

    @Test(description = "MRKTGLD-27 / Check validation messages on empty Sign In", groups = {"investor sign in"})
    public void checkInvestorEmptySignIn() {
        signInSteps.OpensInvestorSignInPage();

        investorSignInPage.clickToSignIn();
        Assert.assertEquals(investorSignInPage.getEmailValidation(), "Email is a required field");
        Assert.assertEquals(investorSignInPage.getPasswordValidation(), "Password is a required field");
    }

    @Test(description = "MRKTGLD-28 / Check validation message  valid email and invalid password", groups = {"investor sign in"})
    public void checkInvestorInvalidPassword() {
        signInSteps.OpensInvestorSignInPage();

        investorSignInPage.sendEmail(Configuration.INVESTOR_EMAIL)
                .sendPassword("Qwerty2@")
                .clickToSignIn();

        Assert.assertEquals(investorSignInPage.getInvalidPasswordErrorMessage(), "Investor with provided data was not found.");
    }
}
