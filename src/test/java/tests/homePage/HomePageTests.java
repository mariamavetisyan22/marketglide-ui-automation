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
    private SignInPage signInPage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        homePage = new HomePage(driver);
        investorRegistrationPage = new InvestorRegistrationPage(driver);
        companyRegistrationPage = new CompanyRegistrationPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test(description = "MRKTGLD-1 / Open Home Page")
    public void openHomePage() {
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }

    @Test(description = "MRKTGLD-2 / Check the click to Join as Company")
    public void checkJoinAsCompany() {
        homePage.clickJoinCompanyButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Join as a Company Seeking Funding");
    }

    @Test(description = "MRKTGLD-3 / Check the click to Join as Investor")
    public void checkJoinAsInvestor() {
        homePage.clickJoinInvestorButton();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Join as an Investor");
    }

    @Test(description = "MRKTGLD-4 / Check navigation to company sign in page")
    public void checkCompanySignIn() {
        homePage.ClickToSignInPage();
        signInPage.clickToCompany();
        Assert.assertEquals(signInPage.getCompanyElementSelected(), "Company");
    }

    @Test(description = "MRKTGLD-5 / Check navigation to investor sign in page")
    public void checkInvestorSignIn() {
        homePage.ClickToSignInPage();
        signInPage.clickToInvestor();
        Assert.assertEquals(signInPage.getInvestorElementSelected(), "Investor");
    }

    @Test(description = "MRKTGLD-6 / Check from Company registration page click on logo navigate to homepage")
    public void checkCompanyRegistrationLogoPage() {
        homePage.clickJoinCompanyButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Join as a Company Seeking Funding");
        companyRegistrationPage.clickToLogoHeader();
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }

    @Test(description = "MRKTGLD-7 / Check from Investor registration page click on logo navigate to homepage")
    public void checkInvestorRegistrationLogoPage() {
        homePage.clickJoinInvestorButton();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Join as an Investor");
        investorRegistrationPage.clickToLogoHeader();
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }

    @Test(description = "MRKTGLD-8 / Check from login page click on logo navigate to homepage")
    public void checkCompanyLoginLogoPage() {
        homePage.ClickToSignInPage();
        Assert.assertEquals(signInPage.getPageTitle(), "Welcome back");
        signInPage.clickToLogo();
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }
}
