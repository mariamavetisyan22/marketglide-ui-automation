package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class SignInPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    @FindBy(xpath = "//h2[normalize-space()='Welcome back']")
    private WebElement pageTitle;

    @FindBy(xpath = "//img[@alt='Logo Header']")
    private WebElement logo;

    @FindBy(xpath = "//div[text()='Company']")
    private WebElement companyLabel;

    @FindBy(xpath = "//div[text()='Investor']")
    private WebElement investorLabel;

    @FindBy(className = "GridViewBtn_Left__GaSJN")
    private WebElement slideLeft;

    @FindBy(className = "GridViewBtn_Right__RuVr6")
    private WebElement slideRight;

    public SignInPage(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    public String getPageTitle() {
        return baseUtils.getText(pageTitle);
    }

    public void clickToLogo() {
        logo.click();
    }

    public String getCompanyElementSelected() {
        return baseUtils.getText(slideLeft);
    }

    public String getInvestorElementSelected() {
        return baseUtils.getText(slideRight);
    }

    public void clickToCompany() {
        companyLabel.click();
    }

    public void clickToInvestor() { companyLabel.click(); }
}
