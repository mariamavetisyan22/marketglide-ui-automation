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
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Registration for Companies");
    }

    @Test(description = "MRKTGLD-3 / Check the click to Join as Investor")
    public void checkJoinAsInvestor() {
        homePage.clickJoinInvestorButton();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Registration for Investors");
    }

    @Test(description = "Check navigation to company sign in page")
    public void checkCompanySignIn() throws InterruptedException {
        final String urlPart = "login";
        homePage.OpenSignInPage();
//        Assert.assertTrue(signInPage.getSignInPageUrl().contains(urlPart));
        Assert.assertEquals(signInPage.getCompanyElementSelected(), "Company");
    }

    @Test(description = "Check navigation to investor sign in page")
    public void checkInvestorSignIn() throws InterruptedException {
        final String urlPart = "login";
        homePage.OpenSignInPage();
        signInPage.clickToCompany();
        Assert.assertTrue(signInPage.getSignInPageUrl().contains(urlPart));
    }

    @Test(description = "Check from the Company registration page click on the logo navigate to the homepage")
    public void checkCompanyRegistrationLogoPage() {
        homePage.clickJoinCompanyButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Registration for Companies");
        companyRegistrationPage.clickToLogoHeader();
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }

    @Test(description = "Check from the Investor registration page click on the logo navigate to the homepage")
    public void checkInvestorRegistrationLogoPage() {
        homePage.clickJoinInvestorButton();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Registration for Investors");
        investorRegistrationPage.clickToLogoHeader();
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }

    @Test(description = "Check from the Company login page click on the logo navigate to the homepage")
    public void checkCompanyLoginLogoPage() throws InterruptedException {
        String urlPart = "company";
        homePage.OpenSignInPage();
        Assert.assertTrue(signInPage.getSignInPageUrl().contains(urlPart));
        signInPage.clickToLogo();
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }

    @Test(description = "Check from the Investor login page click on the logo navigate to the homepage")
    public void checkInvestorLoginLogoPage() throws InterruptedException {
        String urlPart = "investor";
        homePage.OpenSignInPage();
        Assert.assertTrue(signInPage.getSignInPageUrl().contains(urlPart));
        signInPage.clickToLogo();
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
    }
}
