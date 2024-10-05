package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class CompanySignInPage {

    private BaseUtils baseUtils;
    private WebDriver driver;

    public CompanySignInPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public String getSignInPageUrl() {
        return baseUtils.getPageUrl();
    }
}
