package pages.company.companyResetPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class CompanyCreateNewPasswordPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    public CompanyCreateNewPasswordPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }
}
