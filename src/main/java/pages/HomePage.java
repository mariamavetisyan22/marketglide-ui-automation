package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.company.CompanyRegistrationPage;
import pages.company.CompanySignInPage;
import pages.investor.InvestorRegistrationPage;
import utils.BaseUtils;

public class HomePage {

    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='Title']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[normalize-space()='Join as Investor']")
    private WebElement joinInvestorButton;

    @FindBy(xpath = "//a[normalize-space()='Join as Company']")
    private WebElement joinCompanyButton;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    private WebElement signInButton;

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

    public CompanySignInPage ClickToSignInPage() {
        signInButton.click();
        return new CompanySignInPage(driver);
    }
}
