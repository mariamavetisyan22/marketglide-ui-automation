package tests.investor;

import configs.Configuration;
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

    @Test(description = "MRKTGLD-39 / Check click to logo navigates to home page", groups = {"investor sign in"})
    public void checkInvestorHomePage() {
        signInSteps.opensInvestorSignInPage();
        investorSignInPage.clickToLogo();

        Assert.assertEquals(homePage.getPageTitle(), "The Premier Global Investor Network");
    }

    @Test(description = "MRKTGLD-25 / Check Sign In Page Title", groups = {"investor sign in"})
    public void checkInvestorSignInPageTitle() {
        signInSteps.opensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getPageTitle(), "Welcome back");
    }

    @Test(description = "MRKTGLD-33 / Check page description text under page title", groups = {"investor sign in"})
    public void checkInvestorPageDescription() {
        signInSteps.opensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getPageDescription(), "Log in to access your personalized dashboard and stay connected.");
    }

    @Test(description = "MRKTGLD-24 / Check Click on Sign In opens Sign In page with Investor Switch", groups = {"investor sign in"})
    public void checkInvestorSignInSwitch() {
        signInSteps.opensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getInvestorElementSelected(), "Discover & Engage");
    }

    @Test(description = "MRKTGLD-88 / Check the Investor Label tooltip", groups = {"homepage"})
    public void checkInvestorSignInTooltip() {
        signInSteps.opensInvestorSignInPage();

        Assert.assertEquals(investorSignInPage.getInvestorToolTipText(), "For professional investors, advisors, " +
                "and market participants exploring vetted private market opportunities.<br/>Select this account " +
                "if you are on the buy-side or simply want to be part of our global community" +
                " (not currently fundraising).");
    }

    @Test(description = "MRKTGLD-26 / Check Investor Sign In with valid credentials", groups = {"investor sign in"})
    public void checkInvestorValidSignIn() {
        signInSteps.opensInvestorSignInPage();

        investorSignInPage.sendEmail(Configuration.INVESTOR_EMAIL)
                .sendPassword(Configuration.PASSWORD)
                .clickToSignIn();
        Assert.assertTrue(investorDashboardPage.getInvestorName().contains("Connection Requests"));
    }

    @Test(description = "MRKTGLD-27 / Check validation messages on empty Sign In", groups = {"investor sign in"})
    public void checkInvestorEmptySignIn() {
        signInSteps.opensInvestorSignInPage();
        investorSignInPage.clickToSignIn();
        Assert.assertEquals(investorSignInPage.getEmailValidation(), "Email is a required field");
        Assert.assertEquals(investorSignInPage.getPasswordValidation(), "Please enter a Password.");
    }

    @Test(description = "MRKTGLD-28 / Check validation message valid email and invalid password", groups = {"investor sign in"})
    public void checkInvestorInvalidPassword() {
        signInSteps.opensInvestorSignInPage();

        investorSignInPage.sendEmail(Configuration.INVESTOR_EMAIL)
                .sendPassword("Qwerty2@")
                .clickToSignIn();
        Assert.assertEquals(investorSignInPage.getInvalidPasswordErrorMessage(), "No investor found with the provided details.");
    }

    @Test(description = "MRKTGLD-29 / Check invalid email validation", groups = {"investor sign in"})
    public void checkInvestorInvalidEmail() {
        signInSteps.opensInvestorSignInPage();

        investorSignInPage.sendEmail("investortestemail").
                clickToSignIn();

        Assert.assertEquals(investorSignInPage.getInvalidEmailError(), "Please enter a valid email address.");
    }

    @Test(description = "MRKTGLD-30 / Check validation of email without extension", groups = {"investor sign in"})
    public void checkInvestorInvalidExtension() {
        signInSteps.opensInvestorSignInPage();

        investorSignInPage.sendEmail("investor@harkirimail")
                .clickToSignIn();

        Assert.assertEquals(investorSignInPage.getEmailInputWithoutExtValidation(), "Email must contain a domain with a valid extension.");
    }

    @Test(description = "MRKTGLD-35 / Check Sign In of non-existing investor credentials", groups = {"investor sign in"})
    public void checkInvestorSignInNonExistingInvestor() {
        signInSteps.opensInvestorSignInPage();

        investorSignInPage.sendEmail("investorUser@harkirimail.com")
                .sendPassword("Qwerty2!")
                .clickToSignIn();

        Assert.assertEquals(investorSignInPage.getInvalidPasswordErrorMessage(), "No investor found with the provided details.");
    }

    @Test(description = "MRKTGLD-34 / Check click on Sign Up navigates to Investor Registration page", groups = {"investor sign in"})
    public void checkInvestorSignUp() {
        signInSteps.opensInvestorSignInPage();

        investorSignInPage.clickToSignUp();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Join Our Global Community");
    }
}