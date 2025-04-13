package pages.investor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUtils;

public class InvestorDashboardPage {
    private BaseUtils baseUtils;
    private WebDriver driver;

    public InvestorDashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        baseUtils = new BaseUtils(driver);
    }

    @FindBy(xpath = "//span[text()='Connection Requests']")
    private WebElement connectionRequestsText;

    public String getRequestsText() {
        return baseUtils.getText(connectionRequestsText);
    }
}
