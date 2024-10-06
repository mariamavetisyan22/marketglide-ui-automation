package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class InvestorRegistrationPage {

    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "/html/body/main/div/h2")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='DesktopHeader_Logo__ZuxHu']//img[@alt='Logo Header']")
    WebElement logoHeader;

    public InvestorRegistrationPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public String getInvestorRegistrationPageTitle() {
        return baseUtils.getText(pageTitle);
    }

    public void clickToLogoHeader() {
        logoHeader.click();
    }
}
