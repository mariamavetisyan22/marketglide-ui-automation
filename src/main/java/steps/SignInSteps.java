package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.company.CompanySignInPage;
import pages.investor.InvestorSignInPage;

public class SignInSteps {
    private WebDriver driver;
    private final HomePage homePage;
    private final InvestorSignInPage investorSignInPage;
    private final CompanySignInPage companySignInPage;

    public SignInSteps(final WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        investorSignInPage = new InvestorSignInPage(driver);
        companySignInPage = new CompanySignInPage(driver);
    }

    public void opensCompanySignInPage() {
        homePage.clickToSignInPage();
        companySignInPage.clickToCompany();
    }

    public void opensInvestorSignInPage() {
        homePage.clickToSignInPage();
        investorSignInPage.clickToInvestor();
    }
}
