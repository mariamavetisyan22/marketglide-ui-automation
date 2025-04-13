package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.company.CompanySignInPage;
import pages.investor.InvestorSignInPage;

public class ResetPasswordSteps {
    private WebDriver driver;
    private final HomePage homePage;
    private final InvestorSignInPage investorSignInPage;
    private final CompanySignInPage companySignInPage;

    public ResetPasswordSteps(final WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        investorSignInPage = new InvestorSignInPage(driver);
        companySignInPage = new CompanySignInPage(driver);
    }

    public void openCompanyResetPasswordPage() throws InterruptedException {
        homePage.clickToSignInPage();
        companySignInPage.clickToCompany();
        companySignInPage.clickToResetPassword();
        Thread.sleep(1000);
    }
}
