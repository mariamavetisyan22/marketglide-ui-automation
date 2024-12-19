package pages.investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class InvestorForgotPasswordPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    public InvestorForgotPasswordPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }
}
