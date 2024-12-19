package tests.investor;

import configs.Configuration;
import jdk.jfr.TransitionTo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.investor.InvestorDashboardPage;
import pages.investor.InvestorRegistrationPage;
import pages.investor.InvestorSignInPage;
import steps.SignInSteps;
import tests.BaseTests;

public class InvestorSignInTests extends BaseTests {
    private WebDriver driver;
    private InvestorSignInPage investorSignInPage;
    private InvestorDashboardPage investorDashboardPage;
    private InvestorRegistrationPage investorRegistrationPage;
    private SignInSteps signInSteps;
    private HomePage homePage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        investorSignInPage = new InvestorSignInPage(driver);
        investorDashboardPage = new InvestorDashboardPage(driver);
        investorRegistrationPage = new InvestorRegistrationPage(driver);
        signInSteps = new SignInSteps(driver);
        homePage = new HomePage(driver);
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

    @Test(description = "MRKTGLD-29 / Check invalid email validation", groups = {"investor sign in"})
    public void checkInvestorInvalidEmail() {
        signInSteps.OpensInvestorSignInPage();

        investorSignInPage.sendEmail("investortestemail").
                clickToSignIn();

        Assert.assertEquals(investorSignInPage.getInvalidEmailError(), "Email must be in a valid format");
    }

    @Test(description = "MRKTGLD-30 / Check validation of email without extension", groups = {"investor sign in"})
    public void checkInvestorInvalidExtension() {
        signInSteps.OpensInvestorSignInPage();

        investorSignInPage.sendEmail("investor@harkirimail")
                .clickToSignIn();

        Assert.assertEquals(investorSignInPage.getEmailInputWithoutExtValidation(), "Email must contain a domain with a valid extension");
    }

    @Test(description = "MRKTGLD-33 / Check page description text under page title", groups = {"investor sign in"})
    public void checkInvestorPageDescription() {
        signInSteps.OpensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getPageDescription(), "Sed urna massa adipiscing egestas accumsan");
    }

    @Test(description = "MRKTGLD-34 / Check click on Sign Up navigates to Investor Registration page", groups = {"investor sign in"})
    public void checkInvestorSignUp() {
        signInSteps.OpensInvestorSignInPage();

        investorSignInPage.clickToSignUp();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Join as an Investor");
    }

    @Test(description = "MRKTGLD-35 / Check Sign In of non-existing investor credentials", groups = {"investor sign in"})
    public void checkInvestorSignInNonExistingInvestor() {
        signInSteps.OpensInvestorSignInPage();

        investorSignInPage.sendEmail("investorUser@harkirimail.com")
                .sendPassword("Qwerty2!")
                .clickToSignIn();

        Assert.assertEquals(investorSignInPage.getInvalidPasswordErrorMessage(), "Investor with provided data was not found.");
    }

    @Test(description = "MRKTGLD-39 / Check click to logo navigates to home page", groups = {"investor sign in"})
    public void checkInvestorHomePage() {
        signInSteps.OpensInvestorSignInPage();
        investorSignInPage.clickToLogo();

        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }
}
