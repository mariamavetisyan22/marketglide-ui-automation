package pages;

import java.lang.Thread;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class HomePage {

    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='Title']")
    WebElement pageTitle;

    @FindBy(xpath = "//a[normalize-space()='Join as Investor']")
    WebElement joinInvestorButton;

    @FindBy(xpath = "//a[normalize-space()='Join as Company']")
    WebElement joinCompanyButton;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButton;

    @FindBy(xpath = "//div[normalize-space()='Option 1']")
    WebElement CompanySignInButton;

    @FindBy(xpath = "//div[normalize-space()='Option 2']")
    WebElement InvestorSignInButton;

    public HomePage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public String getPageTitle() {
        return baseUtils.getText(pageTitle);
    }

    public InvestorRegistrationPage clickJoinInvestorButton() {
        joinInvestorButton.click();
        return new InvestorRegistrationPage(driver);
    }

    public CompanyRegistrationPage clickJoinCompanyButton() {
        joinCompanyButton.click();
        return new CompanyRegistrationPage(driver);
    }

    public CompanySignInPage OpenCompanySignInPage() throws InterruptedException {
        signInButton.click();
        CompanySignInButton.click();
        Thread.sleep(5);
        return new CompanySignInPage(driver);
    }

    public InvestorSignInPage OpenInvestorSignInPage() throws InterruptedException {
        signInButton.click();
        InvestorSignInButton.click();
        Thread.sleep(5);
        return new InvestorSignInPage(driver);
    }
}
