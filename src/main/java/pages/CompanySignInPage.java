package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class CompanySignInPage {

    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logo;

    public CompanySignInPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public String getSignInPageUrl() {
        return baseUtils.getPageUrl();
    }

    public void clickToLogo() {
        logo.click();
    }
}
