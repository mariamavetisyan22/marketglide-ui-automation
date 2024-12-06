package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class SignInPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logo;

    @FindBy(xpath = "//div[text()='Company']")
    private WebElement companyLabel;

    @FindBy(className = "GridViewBtn_SlideLeft__5fZ0p")
    private WebElement slideLeft;

    @FindBy(className = "GridViewBtn_SlideRight__PMb7J")
    private WebElement slideRight;

    public SignInPage(final WebDriver driver) {
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

    public String getCompanyElementSelected() throws InterruptedException {
        Thread.sleep(5);
        return baseUtils.getText(slideLeft);
    }

    public String getInvestorElementSelected() {
        return baseUtils.getText(slideRight);
    }

    public void clickToCompany() {
        companyLabel.click();
    }
}
