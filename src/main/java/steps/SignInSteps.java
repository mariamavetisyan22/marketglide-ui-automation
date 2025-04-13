package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.investor.InvestorSignInPage;

public class SignInSteps {
    private WebDriver driver;
    private final HomePage homePage;
    private final InvestorSignInPage investorSignInPage;

    public SignInSteps(final WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        investorSignInPage = new InvestorSignInPage(driver);
    }

    public void OpensCompanySignInPage() {
        homePage.clickToSignInPage();
    }

    public void OpensInvestorSignInPage() {
        homePage.clickToSignInPage();
        investorSignInPage.clickToInvestor();
    }
}
