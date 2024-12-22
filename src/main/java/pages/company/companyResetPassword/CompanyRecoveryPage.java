package pages.company.companyResetPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.company.CompanySignInPage;
import utils.BaseUtils;

public class CompanyRecoveryPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//h2[normalize-space()='Recovery Password']")
    private WebElement pageTitle;

    @FindBy(className = "FirstAuth_PrimaryText__wyiYM")
    private WebElement pageDescription;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[normalize-space()='Next']")
    private WebElement nextButton;

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[@class='ErrorMessage']")
    private WebElement emptyInputMessage;

    public CompanyRecoveryPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public String getPageTitle() {
        return baseUtils.getText(pageTitle);
    }

    public String getPageDescription() {
        return baseUtils.getText(pageDescription);
    }

    public void sendEmail(final String password) {
        baseUtils.sendText(emailInput, password);
    }

    public CompanySignInPage clickToCancelButton() {
        baseUtils.click(cancelButton);
        return new CompanySignInPage(driver);
    }

    public void clickToNextButton() {
        baseUtils.click(nextButton);
    }

    public void clickToSignUpButton() {
        baseUtils.click(signUpButton);
    }

    public String getEmptyInputMessage() {
        return baseUtils.getText(emptyInputMessage);
    }
}
