package tests.homePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.company.CompanyRegistrationPage;
import pages.company.CompanySignInPage;
import pages.investor.InvestorRegistrationPage;
import pages.investor.InvestorSignInPage;
import tests.BaseTests;

public class HomePageTests extends BaseTests {

    private HomePage homePage;
    private InvestorRegistrationPage investorRegistrationPage;
    private CompanyRegistrationPage companyRegistrationPage;
    private CompanySignInPage companySignInPage;
    private InvestorSignInPage investorSignInPage;

    @BeforeMethod(groups = {"homepage", "company sign in", "investor sign in"})
    public void beforeInit() {
        final WebDriver driver = getDriver();
        homePage = new HomePage(driver);
        investorRegistrationPage = new InvestorRegistrationPage(driver);
        companyRegistrationPage = new CompanyRegistrationPage(driver);
        companySignInPage = new CompanySignInPage(driver);
        investorSignInPage = new InvestorSignInPage(driver);
    }

    @Test(description = "MRKTGLD-1 / Open Home Page", groups = {"homepage"})
    public void openHomePage() {
        Assert.assertEquals(homePage.getPageTitle(), "The Premier Global Investor Network");
    }

    @Test(description = "MRKTGLD-87 / Check the Company Registration tooltip", groups = {"homepage"})
    public void checkCompanyTooltip() {
        Assert.assertEquals(homePage.getCompanyTooltipText(), "For companies, fund managers, and deal " +
                "originators seeking capital or strategic buyers.<br/>Select this account only if you are on " +
                "the sell-side looking to raise capital for your company or fund.");
    }

    @Test(description = "MRKTGLD-2 / Check the click to [Raise & Scale]", groups = {"homepage"})
    public void checkJoinAsCompany() {
        homePage.clickJoinCompanyButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Join to Raise");
        Assert.assertEquals(companyRegistrationPage.getPageDescription(), "Create an account " +
                "to showcase your investment opportunity to a global network of investors and strategic partners. " +
                "Whether you’re raising capital for your company or fund, MarketGlide helps you " +
                "connect with the right people to connect & grow.");
    }

    @Test(description = "MRKTGLD-86 / Check the Investor Registration tooltip", groups = {"homepage"})
    public void checkInvestorTooltip() {
        Assert.assertEquals(homePage.getInvestorToolTipText(), "For professional investors, advisors, " +
                "and market participants exploring vetted private market opportunities.<br/>Select this account " +
                "if you are on the buy-side or simply want to be part of our global community" +
                " (not currently fundraising).");
    }

    @Test(description = "MRKTGLD-3 / Check the click to [Discover & Engage]", groups = {"homepage"})
    public void checkJoinAsInvestor() {
        homePage.clickJoinInvestorButton();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Join Our Global Community");
        Assert.assertEquals(investorRegistrationPage.getPageDescription(), "Create an account to explore " +
                "vetted opportunities and connect with top professionals. Whether you’re actively investing or simply " +
                "looking to be a member of our global community, MarketGlide gives you exclusive " +
                "access to insights and opportunities.");
    }

    @Test(description = "MRKTGLD-4 / Check navigation to company sign in page", groups = {"homepage"})
    public void checkCompanySignIn() {
        homePage.clickToSignInPage();
        companySignInPage.clickToCompany();
        Assert.assertEquals(companySignInPage.getPageTitle(), "Welcome back");
        Assert.assertEquals(companySignInPage.getCompanyElementSelected(), "Raise & Scale");
    }

    @Test(description = "MRKTGLD-5 / Check navigation to investor sign in page", groups = {"homepage"})
    public void checkInvestorSignIn() {
        homePage.clickToSignInPage();
        investorSignInPage.clickToInvestor();
        Assert.assertEquals(investorSignInPage.getPageTitle(), "Welcome back");
        Assert.assertEquals(investorSignInPage.getInvestorElementSelected(), "Discover & Engage");
    }

    @Test(description = "MRKTGLD-6 / Check from Company registration page click on logo navigate to homepage", groups = {"homepage"})
    public void checkCompanyRegistrationLogoPage() {
        homePage.clickJoinCompanyButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Join to Raise");
        companyRegistrationPage.clickToLogoHeader();
        Assert.assertEquals(homePage.getPageTitle(), "The Premier Global Investor Network");
    }

    @Test(description = "MRKTGLD-7 / Check from Investor registration page click on logo navigate to homepage", groups = {"homepage"})
    public void checkInvestorRegistrationLogoPage() {
        homePage.clickJoinInvestorButton();
        Assert.assertEquals(investorRegistrationPage.getInvestorRegistrationPageTitle(), "Join Our Global Community");
        investorRegistrationPage.clickToLogoHeader();
        Assert.assertEquals(homePage.getPageTitle(), "The Premier Global Investor Network");
    }

    @Test(description = "MRKTGLD-8 / Check from login page click on logo navigate to homepage", groups = {"homepage"})
    public void checkCompanyLoginLogoPage() {
        homePage.clickToSignInPage();
        Assert.assertEquals(companySignInPage.getPageTitle(), "Welcome back");
        companySignInPage.clickToLogo();
        Assert.assertEquals(homePage.getPageTitle(), "The Premier Global Investor Network");
    }
}