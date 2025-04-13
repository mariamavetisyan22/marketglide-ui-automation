package pages.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class CompanyRegistrationPage {

    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(className = "Title")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='DesktopHeader_Logo__ZuxHu']//img[@alt='Logo Header']")
    private WebElement logoHeader;

    @FindBy(className = "Description")
    private WebElement pageDescription;

    @FindBy(id = "email")
    private WebElement emailInputField;

    public CompanyRegistrationPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public String getCompanyRegistrationPageTitle() {
        return baseUtils.getText(pageTitle);
    }

    public void clickToLogoHeader() {
        logoHeader.click();
    }

    public String getPageDescription() {
        return baseUtils.getText(pageDescription);
    }

    public CompanyRegistrationPage sendTextToEmailInputField(final String email) {
        baseUtils.sendText(emailInputField, email);
        return this;
    }
}
