package pages.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class CompanyForgotPasswordPage {

    private BaseUtils baseUtils;
    private WebDriver driver;

    public CompanyForgotPasswordPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }
}
