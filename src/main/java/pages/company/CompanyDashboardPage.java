package pages.company;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class CompanyDashboardPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    public CompanyDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    @FindBy(css = "div[class='Dashboard_Dashboard__R9qty'] h1")
    private WebElement companyName;

    public String getCompanyName() {
        return companyName.getText();
    }
}
