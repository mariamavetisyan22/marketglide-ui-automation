package pages.company.companyResetPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class CompanyResetPasswordLinkPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logoHeader;

    @FindBy(xpath = "//h2[normalize-space()='Check your Email for the link.']")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[normalize-space()='Return to Homepage']")
    private WebElement returnToHomepageButton;

    public CompanyResetPasswordLinkPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public void clickOnLogo() {
        baseUtils.click(logoHeader);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void clickOnReturnToHomepage() {
        baseUtils.click(returnToHomepageButton);
    }
}
