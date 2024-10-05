package tests.homePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import tests.BaseTests;

public class HomePageTests extends BaseTests {

    private WebDriver driver;
    private HomePage homePage;
    private InvestorRegistrationPage investorRegistrationPage;
    private CompanyRegistrationPage companyRegistrationPage;
    private CompanySignInPage companySignInPage;
    private InvestorSignInPage investorSignInPage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        homePage = new HomePage(driver);
        investorRegistrationPage = new InvestorRegistrationPage(driver);
        companyRegistrationPage = new CompanyRegistrationPage(driver);
        companySignInPage = new CompanySignInPage(driver);
        investorSignInPage = new InvestorSignInPage(driver);
    }

    @Test(description = "Open Home Page")
    public void openHomePage() {
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }

    @Test(description = "Check the click to Join as Investor")
    public void checkJoinAsInvestor() {
        homePage.clickJoinInvestorButton();
        String title = investorRegistrationPage.getInvestorRegistrationPageTitle();
        Assert.assertEquals(title, "Registration for Investors");
    }

    @Test(description = "Check the click to Join as Company")
    public void checkJoinAsCompany() {
        homePage.clickJoinCompanyButton();
        String title = companyRegistrationPage.getCompanyRegistrationPageTitle();
        Assert.assertEquals(title, "Registration for Companies");
    }

    @Test(description = "Check navigation to company sign in page")
    public void checkCompanySignIn() throws InterruptedException {
        String urlPart = "company";
        homePage.OpenCompanySignInPage();
        Assert.assertTrue(companySignInPage.getSignInPageUrl().contains(urlPart));
    }

    @Test(description = "Check navigation to investor sign in page")
    public void checkInvestorSignIn() throws InterruptedException {
        String urlPart = "investor";
        homePage.OpenInvestorSignInPage();
        Assert.assertTrue(investorSignInPage.getSignInPageUrl().contains(urlPart));
    }
}
