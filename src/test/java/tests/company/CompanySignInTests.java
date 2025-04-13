package tests.company;

import configs.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.company.CompanyDashboardPage;
import pages.company.CompanyRegistrationPage;
import pages.company.CompanySignInPage;
import steps.SignInSteps;
import tests.BaseTests;

public class CompanySignInTests extends BaseTests {
    private WebDriver driver;
    private SignInSteps signInSteps;
    private CompanySignInPage companySignInPage;
    private CompanyDashboardPage companyDashboardPage;
    private CompanyRegistrationPage companyRegistrationPage;
    private HomePage homePage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        signInSteps = new SignInSteps(driver);
        companySignInPage = new CompanySignInPage(driver);
        companyDashboardPage = new CompanyDashboardPage(driver);
        companyRegistrationPage = new CompanyRegistrationPage(driver);
        homePage = new HomePage(driver);
    }

    @Test(description = "MRKTGLD-12 / Check click on Sign In opens Sign In page with Company Switch", groups = {"company sign in"})
    public void clickOnSignIn() {
        signInSteps.opensCompanySignInPage();
        companySignInPage.clickToCompany();

        Assert.assertEquals(companySignInPage.getCompanyElementSelected(), "Raise & Scale");
    }

    @Test(description = "MRKTGLD-38 / Check click to logo navigates to home page", groups = {"company sign in"})
    public void checkCompanyHomePage() {
        signInSteps.opensCompanySignInPage();
        companySignInPage.clickToLogo();

        Assert.assertEquals(homePage.getPageTitle(), "The Premier Global Investor Network");
    }

    @Test(description = "MRKTGLD-13 / Check Sign In Page Title", groups = {"company sign in"})
    public void checkSignInTitle() {
        signInSteps.opensCompanySignInPage();

        Assert.assertEquals(companySignInPage.getPageTitle(), "Welcome back");
    }

    @Test(description = "MRKTGLD-21 / Check page description text under page title", groups = {"company sign in"})
    public void checkPageDescriptionText() {
        signInSteps.opensCompanySignInPage();

        Assert.assertEquals(companySignInPage.getPageDescription(), "Log in to access your personalized dashboard and stay connected.");
    }

    @Test(description = "MRKTGLD-89 / Check the Company Label tooltip", groups = {"homepage"})
    public void checkInvestorSignInTooltip() {
        signInSteps.opensInvestorSignInPage();

        Assert.assertEquals(companySignInPage.getCompanyToolTipText(), "For companies, fund managers, and deal " +
                "originators seeking capital or strategic buyers.<br/>Select this account only if you " +
                "are on the sell-side looking to raise capital for your company or fund.");
    }

    @Test(description = "MRKTGLD-14 / Check Company Sign In with valid credentials", groups = {"company sign in"})
    public void checkCompanySignIn() {
        signInSteps.opensCompanySignInPage();

        companySignInPage.sendEmail(Configuration.COMPANY_EMAIL)
                .sendPassword(Configuration.PASSWORD)
                .clickToSignIn();
        Assert.assertTrue(companyDashboardPage.getRequestsText().contains("Connection Requests"));
    }

    @Test(description = "MRKTGLD-15 / Check validation messages on empty Sign In", groups = {"company sign in"})
    public void checkValidationMessages() {
        signInSteps.opensCompanySignInPage();

        companySignInPage.clickToSignIn();
        Assert.assertEquals(companySignInPage.getEmailValidation(), "Email is a required field");
        Assert.assertEquals(companySignInPage.getPasswordValidation(), "Please enter a Password.");
    }

    @Test(description = "MRKTGLD-16 / Check validation message on valid email and invalid password entry", groups = {"company sign in"})
    public void checkInvalidPasswordValidation() {
        signInSteps.opensCompanySignInPage();

        companySignInPage.sendEmail(Configuration.COMPANY_EMAIL)
                .sendPassword("Qwerty2@")
                .clickToSignIn();
        Assert.assertEquals(companySignInPage.getInvalidPasswordErrorMessage(), "No company found with the provided details.");
    }

    @Test(description = "MRKTGLD-23 / Check Sign In of non-existing company credentials", groups = {"company sign in"})
    public void checkNonExistingCompanySignIn() {
        signInSteps.opensCompanySignInPage();

        companySignInPage.sendEmail("company_test@harakirimail.com")
                .sendPassword("Qwerty2@")
                .clickToSignIn();
        Assert.assertEquals(companySignInPage.getInvalidPasswordErrorMessage(), "No company found with the provided details.");
    }

    @Test(description = "MRKTGLD-17 / Check invalid email validation", groups = {"company sign in"})
    public void checkInvalidEmailValidation() {
        signInSteps.opensCompanySignInPage();

        companySignInPage.sendEmail("companytestharakirimailcom")
                .clickToSignIn();
        Assert.assertEquals(companySignInPage.getInvalidEmailEntryErrorMessage(), "Please enter a valid email address.");
    }

    @Test(description = "MRKTGLD-18 / Check validation of email without extension", groups = {"company sign in"})
    public void checkWithoutExtEmailValidation() {
        signInSteps.opensCompanySignInPage();

        companySignInPage.sendEmail("company@harakirimail")
                .clickToSignIn();
        Assert.assertEquals(companySignInPage.getEmailValidationWithoutExt(), "Email must contain a domain with a valid extension.");
    }

    @Test(description = "MRKTGLD-22 / Check click on Sign Up navigates to Company Registration page")
    public void checkSignUpFromCompanySignIn() {
        signInSteps.opensCompanySignInPage();

        companySignInPage.clickToSignUp();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Join to Raise");
    }
}
