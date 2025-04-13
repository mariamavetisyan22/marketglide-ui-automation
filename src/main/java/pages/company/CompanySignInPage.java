package pages.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.company.companyResetPassword.CompanyRecoveryPage;
import utils.BaseUtils;

public class CompanySignInPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logo;

    @FindBy(xpath = "//h2[text()='Welcome back']")
    private WebElement pageTitle;

    @FindBy(className = "FirstAuth_PrimaryText__wyiYM")
    private WebElement pageDescriptionText;

    @FindBy(xpath = "//span[text()='Raise & Scale']")
    private WebElement companyLabel;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "Login_ForgotPassword__z_8Go")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text()='Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[text()='Email is a required field']")
    private WebElement emailInputValidation;

    @FindBy(xpath = "//p[text()='Please enter a Password.']")
    private WebElement passwordInputValidation;

    @FindBy(xpath = "//p[@class='ErrorMessage']")
    private WebElement InvalidPasswordErrorMessage;

    @FindBy(xpath = "//p[text()='Please enter a valid email address.']")
    private WebElement invalidEmailInputValidation;

    @FindBy(xpath = "//p[text()='Email must contain a domain with a valid extension.']")
    private WebElement emailInputWithoutExtValidation;

    @FindBy(xpath = "//div[contains(@data-tooltip-id,'companyReg')]")
    private WebElement companyTooltipText;

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
        return baseUtils.getText(companyLabel);
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

    public CompanyRecoveryPage clickToResetPassword() {
        baseUtils.click(forgotPasswordButton);
        return new CompanyRecoveryPage(driver);
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

    public String getCompanyToolTipText() {
        return baseUtils.getHoverItemText(companyTooltipText, "data-tooltip-html");
    }
}
