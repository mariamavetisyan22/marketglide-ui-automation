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

    @FindBy(xpath = "//a[normalize-space()='Discover & Engage']")
    private WebElement joinInvestorButton;

    @FindBy(className = "Tooltip")
    private WebElement investorToolTipText;

    @FindBy(xpath = "//div[contains(@data-tooltip-id,'companyReg')]")
    private WebElement companyTooltipText;

    @FindBy(xpath = "//a[normalize-space()='Raise & Scale']")
    private WebElement joinCompanyButton;

    @FindBy(xpath = "//button[text()='Sign In']")
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
        baseUtils.click(joinInvestorButton);
        return new InvestorRegistrationPage(driver);
    }

    public CompanyRegistrationPage clickJoinCompanyButton() {
        baseUtils.click(joinCompanyButton);
        return new CompanyRegistrationPage(driver);
    }

    public CompanySignInPage clickToSignInPage() {
        baseUtils.click(signInButton);
        return new CompanySignInPage(driver);
    }

    public String getInvestorToolTipText() {
       return baseUtils.getHoverItemText(investorToolTipText, "data-tooltip-html");
    }

    public String getCompanyTooltipText() {
        return baseUtils.getHoverItemText(companyTooltipText, "data-tooltip-html");
    }
}
