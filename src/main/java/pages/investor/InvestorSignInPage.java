package pages.investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.BaseUtils;

public class InvestorSignInPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logo;

    @FindBy(xpath = "//h2[text()='Welcome back']")
    private WebElement pageTitle;

    @FindBy(className = "FirstAuth_PrimaryText__wyiYM")
    private WebElement pageDescriptionText;

    @FindBy(xpath = "//span[text()='Discover & Engage']")
    private WebElement investorLabel;

    @FindBy(className = "GridViewBtn_Right__RuVr6")
    private WebElement slideRight;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//p[text()='Email is a required field']")
    private WebElement emailInputValidation;

    @FindBy(xpath = "//p[text()='Password is a required field']")
    private WebElement passwordInputValidation;

    @FindBy(xpath = "//p[@class='ErrorMessage']")
    private WebElement InvalidPasswordErrorMessage;

    @FindBy(xpath = "//p[text()='Email must be in a valid format']")
    private WebElement invalidEmailError;

    @FindBy(xpath = "//p[text()='Email must contain a domain with a valid extension']")
    private WebElement emailInputWithoutExtValidation;

    @FindBy(className = "Login_ForgotPassword__z_8Go")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text()='Sign Up']")
    private WebElement signUpButton;

    public InvestorSignInPage(final WebDriver driver) {
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

    public String getInvestorElementSelected() {
        return baseUtils.getText(investorLabel);
    }

    public void clickToInvestor() { baseUtils.click(investorLabel); }

    public InvestorSignInPage sendEmail(final String email) {
        baseUtils.sendText(emailInput, email);
        return this;
    }

    public InvestorSignInPage sendPassword(final String password) {
        baseUtils.sendText(passwordInput, password);
        return this;
    }

    public String getEmailValidation() { return baseUtils.getText(emailInputValidation); }

    public String getPasswordValidation() { return baseUtils.getText(passwordInputValidation); }

    public String getInvalidPasswordErrorMessage() { return baseUtils.getText(InvalidPasswordErrorMessage); }

    public String getInvalidEmailError() { return baseUtils.getText(invalidEmailError); }

    public String getEmailInputWithoutExtValidation() { return baseUtils.getText(emailInputWithoutExtValidation); }

    public void clickToSignIn() { baseUtils.click(signInButton); }

    public InvestorForgotPasswordPage clickToResetPassword() {
        baseUtils.click(resetPasswordButton);
        return new InvestorForgotPasswordPage(driver);
    }

    public InvestorRegistrationPage clickToSignUp() {
        baseUtils.click(signUpButton);
        return new InvestorRegistrationPage(driver);
    }
}
