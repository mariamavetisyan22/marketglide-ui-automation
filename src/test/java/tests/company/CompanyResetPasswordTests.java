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
        resetPasswordSteps.openCompanyResetPasswordPage();
        Assert.assertEquals(companyRecoveryPage.getPageTitle(), "Recovery Password");
    }

    @Test(description = "MRKTGLD-42 / Check Company Reset Password page description text", groups = {"company reset password"})
    public void checkCompanyResetPasswordPageDescription() throws InterruptedException {
        resetPasswordSteps.openCompanyResetPasswordPage();
        Assert.assertEquals(companyRecoveryPage.getPageDescription(), "Enter the email address associated with your MarketGlide account.");
    }

    @Test(description = "MRKTGLD-43 / Reset Password page click to [Cancel] navigates to Sign in page of Company", groups = {"company reset password"})
    public void clickCancelResetPasswordPage() throws InterruptedException {
        resetPasswordSteps.openCompanyResetPasswordPage();
        companyRecoveryPage.clickToCancelButton();
        Assert.assertEquals(companySignInPage.getPageTitle(), "Welcome back");
    }

    @Test(description = "MRKTGLD-44 / Reset Password Page click to [Sign Up] navigates to Company Registration page", groups = {"company reset password"})
    public void clickSignUpPage() throws InterruptedException {
        resetPasswordSteps.openCompanyResetPasswordPage();

        companyRecoveryPage.clickToSignUpButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Join to Raise");
    }

    @Test(description = "MRKTGLD-45 / Check Company Reset Password page click to [Next] without any entry", groups = {"company reset password"})
    public void checkCompanyClickNextWithoutEntry() throws InterruptedException {
        resetPasswordSteps.openCompanyResetPasswordPage();
        companyRecoveryPage.clickToNextButton();
        Assert.assertEquals(companyRecoveryPage.getEmptyInputMessage(), "Email is a required field");
    }

    @Test(description = "MRKTGLD-46 / Check Company Reset Password page with valid email", groups = {"company reset password"})
    public void checkCompanyClickValidEmail() throws InterruptedException {
        resetPasswordSteps.openCompanyResetPasswordPage();
        companyRecoveryPage.sendEmail(Configuration.COMPANY_EMAIL);
        companyRecoveryPage.clickToNextButton();

        Assert.assertEquals(companyResetPasswordLinkPage.getPageTitle(), "Check your Email for the link.");
    }

    @Test(description = "MRKTGLD-47 / Check Company Reset Password page enter not registered email", groups = {"company reset password"})
    public void checkNotRegisteredEmailResetPassword() throws InterruptedException {
        resetPasswordSteps.openCompanyResetPasswordPage();

        companyRecoveryPage.sendEmail("notregistered@email.com");
        companyRecoveryPage.clickToNextButton();
        Assert.assertEquals(companyRecoveryPage.getEmptyInputMessage(), "Company with provided email was not found");
    }

    @Test(description = "MRKTGLD-48 / Check Company Reset Password enter email without '@' symbol", groups = {"company reset password"})
    public void checkEmailEntryWithoutSymbol() throws InterruptedException {
        resetPasswordSteps.openCompanyResetPasswordPage();

        companyRecoveryPage.sendEmail("notregistered");
        companyRecoveryPage.clickToNextButton();
        Assert.assertEquals(companyRecoveryPage.getEmptyInputMessage(), "Invalid email address");
    }
}
