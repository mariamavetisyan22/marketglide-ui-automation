package tests.company;

import configs.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.company.CompanyDashboardPage;
import pages.company.CompanySignInPage;
import steps.SignInSteps;
import tests.BaseTests;

public class CompanySignInTests extends BaseTests {
    private WebDriver driver;
    private CompanySignInPage companySignInPage;
    private SignInSteps signInSteps;
    private CompanyDashboardPage companyDashboardPage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        companySignInPage = new CompanySignInPage(driver);
        signInSteps = new SignInSteps(driver);
        companyDashboardPage = new CompanyDashboardPage(driver);
    }

    @Test(description = "MRKTGLD-12 / Check click on Sign In opens Sign In page with Company Switch")
    public void clickOnSignIn() {
        signInSteps.OpensCompanySignInPage();
        companySignInPage.clickToCompany();
        Assert.assertEquals(companySignInPage.getCompanyElementSelected(), "Company");
    }

    @Test(description = "MRKTGLD-13 / Check Sign In Page Title")
    public void CheckSignInTitle() {
        signInSteps.OpensCompanySignInPage();
        Assert.assertEquals(companySignInPage.getPageTitle(), "Welcome back");
    }

    @Test(description = "MRKTGLD-21 / Check page description text under page title")
    public void CheckPageDescriptionText() {
        signInSteps.OpensCompanySignInPage();
        Assert.assertEquals(companySignInPage.getPageDescription(), "Sed urna massa adipiscing egestas accumsan");
    }

    @Test(description = "MRKTGLD-14 / Check Company Sign In with valid credentials")
    public void CheckCompanySignIn() {
        signInSteps.OpensCompanySignInPage();

        companySignInPage.sendEmail(Configuration.COMPANY_EMAIL)
                .sendPassword(Configuration.PASSWORD)
                .clickToSignIn();
        Assert.assertTrue(companyDashboardPage.getCompanyName().contains("Welcome to Dashboard"));
    }
}
