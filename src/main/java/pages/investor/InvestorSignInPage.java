package pages.investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class InvestorSignInPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logo;

    @FindBy(xpath = "//h2[normalize-space()='Welcome back']")
    private WebElement pageTitle;

    @FindBy(className = "FirstAuth_PrimaryText__wyiYM")
    private WebElement pageDescriptionText;

    @FindBy(xpath = "//div[text()='Investor']")
    private WebElement investorLabel;

    @FindBy(className = "GridViewBtn_Right__RuVr6")
    private WebElement slideRight;

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

    public InvestorSignInPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public void clickToLogo() { logo.click(); }

    public String getPageTitle() {
        return baseUtils.getText(pageTitle);
    }

    public String getPageDescription() { return baseUtils.getText(pageDescriptionText); }

    public String getInvestorElementSelected() {
        return baseUtils.getText(slideRight);
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

    public void clickToSignIn() { signInButton.click(); }

    public void clickToResetPassword() { signUpButton.click(); }

    public void clickToSignUp() { signUpButton.click(); }
}
