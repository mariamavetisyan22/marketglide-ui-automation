package pages.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.BaseUtils;

import javax.smartcardio.CommandAPDU;

public class CompanySignInPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logo;

    @FindBy(xpath = "//h2[normalize-space()='Welcome back']")
    private WebElement pageTitle;

    @FindBy(className = "FirstAuth_PrimaryText__wyiYM")
    private WebElement pageDescriptionText;

    @FindBy(xpath = "//div[text()='Company']")
    private WebElement companyLabel;

    @FindBy(className = "GridViewBtn_Left__GaSJN")
    private WebElement slideLeft;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "Login_ForgotPassword__z_8Go")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[normalize-space()='Email is a required field']")
    private WebElement emailInputValidation;

    @FindBy(xpath = "//p[normalize-space()='Password is a required field']")
    private WebElement passwordInputValidation;

    @FindBy(xpath = "//p[@class='ErrorMessage']")
    private WebElement InvalidPasswordErrorMessage;

    @FindBy(xpath = "//p[normalize-space()='Email must be in a valid format']")
    private WebElement invalidEmailInputValidation;

    @FindBy(xpath = "//p[normalize-space()='Email must contain a domain with a valid extension']")
    private WebElement emailInputWithoutExtValidation;

    public CompanySignInPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public HomePage clickToLogo() {
        baseUtils.click(logo);
        return new HomePage(driver);
    }

    public String getPageTitle() {
        return baseUtils.getText(pageTitle);
    }

    public String getPageDescription() { return baseUtils.getText(pageDescriptionText); }

    public String getCompanyElementSelected() {
        return baseUtils.getText(slideLeft);
    }

    public void clickToCompany() {
        baseUtils.click(companyLabel);
    }

    public CompanySignInPage sendEmail(final String email) {
        baseUtils.sendText(emailInput, email);
        return new CompanySignInPage(driver);
    }

    public CompanySignInPage sendPassword(final String password) {
        baseUtils.sendText(passwordInput, password);
        return new CompanySignInPage(driver);
    }

    public void clickToSignIn() { baseUtils.click(signInButton); }

    public CompanyForgotPasswordPage clickToResetPassword() {
        baseUtils.click(forgotPasswordButton);
        return new CompanyForgotPasswordPage(driver);
    }

    public CompanyRegistrationPage clickToSignUp() {
        baseUtils.click(signUpButton);
        return new CompanyRegistrationPage(driver);
    }

    public String getEmailValidation() { return baseUtils.getText(emailInputValidation); }

    public String getPasswordValidation() { return baseUtils.getText(passwordInputValidation); }

    public String getInvalidPasswordErrorMessage() { return baseUtils.getText(InvalidPasswordErrorMessage); }

    public String getInvalidEmailEntryErrorMessage() { return baseUtils.getText(invalidEmailInputValidation); }

    public String getEmailValidationWithoutExt() { return baseUtils.getText(emailInputWithoutExtValidation); }
}
