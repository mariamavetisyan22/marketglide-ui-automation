package tests.company;

import configs.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.company.CompanyRegistrationPage;
import pages.company.CompanySignInPage;
import pages.company.companyResetPassword.CompanyCreateNewPasswordPage;
import pages.company.companyResetPassword.CompanyRecoveryPage;
import pages.company.companyResetPassword.CompanyResetPasswordLinkPage;
import steps.ResetPasswordSteps;
import steps.SignInSteps;
import tests.BaseTests;

public class CompanyResetPasswordTests extends BaseTests {
    private WebDriver driver;
    private SignInSteps signInSteps;
    private ResetPasswordSteps resetPasswordSteps;
    private CompanySignInPage companySignInPage;
    private CompanyRecoveryPage companyRecoveryPage;
    private CompanyCreateNewPasswordPage companyCreateNewPasswordPage;
    private CompanyRegistrationPage companyRegistrationPage;
    private CompanyResetPasswordLinkPage companyResetPasswordLinkPage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        signInSteps = new SignInSteps(driver);
        resetPasswordSteps = new ResetPasswordSteps(driver);
        companySignInPage = new CompanySignInPage(driver);
        companyRecoveryPage = new CompanyRecoveryPage(driver);
        companyCreateNewPasswordPage = new CompanyCreateNewPasswordPage(driver);
        companyRegistrationPage = new CompanyRegistrationPage(driver);
        companyResetPasswordLinkPage = new CompanyResetPasswordLinkPage(driver);
    }

    @Test(description = "MRKTGLD-40 / MRKTGLD-41 - Check click to [Reset Password] opens the Company Recovery Password page", groups = {"company reset password"})
    public void clickResetPasswordRecoveryPage() throws InterruptedException {
        signInSteps.OpensCompanySignInPage();

        companySignInPage.clickToResetPassword();
        Assert.assertEquals(companyRecoveryPage.getPageTitle(), "Recovery Password");
    }

    @Test(description = "MRKTGLD-42 / Check Company Reset Password page description text", groups = {"company reset password"})
    public void CheckCompanyResetPasswordPageDescription() throws InterruptedException {
        signInSteps.OpensCompanySignInPage();

        companySignInPage.clickToResetPassword();
        Assert.assertEquals(companyRecoveryPage.getPageDescription(), "Enter the email address associated with your MarketGlide account.");
    }

    @Test(description = "MRKTGLD-43 / Reset Password page click to [Cancel] navigates to Sign in page of Company", groups = {"company reset password"})
    public void clickCancelResetPasswordPage() throws InterruptedException {
        signInSteps.OpensCompanySignInPage();
        companySignInPage.clickToResetPassword();
        companyRecoveryPage.clickToCancelButton();
        Assert.assertEquals(companySignInPage.getPageTitle(), "Welcome back");
    }

    @Test(description = "MRKTGLD-44 / Reset Password Page click to [Sign Up] navigates to Company Registration page", groups = {"company reset password"})
    public void clickSignUpPage() throws InterruptedException {
        signInSteps.OpensCompanySignInPage();
        companySignInPage.clickToResetPassword();

        companyRecoveryPage.clickToSignUpButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Join as a Company Seeking Funding");
    }

    @Test(description = "MRKTGLD-45 / Check Company Reset Password page click to [Next] without any entry", groups = {"company reset password"})
    public void CheckCompanyClickNextWithoutEntry() throws InterruptedException {
        signInSteps.OpensCompanySignInPage();
        companySignInPage.clickToResetPassword();
        companyRecoveryPage.clickToNextButton();
        Assert.assertEquals(companyRecoveryPage.getEmptyInputMessage(), "Email is a required field");
    }

    @Test(description = "MRKTGLD-46 / Check Company Reset Password page with valid email", groups = {"company reset password"})
    public void CheckCompanyClickValidEmail() throws InterruptedException {
        signInSteps.OpensCompanySignInPage();
        companySignInPage.clickToResetPassword();
        companyRecoveryPage.sendEmail(Configuration.COMPANY_EMAIL);
        companyRecoveryPage.clickToNextButton();

        Assert.assertEquals(companyResetPasswordLinkPage.getPageTitle(), "Check your Email for the link.");
    }
}
