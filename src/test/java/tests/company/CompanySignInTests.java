package tests.company;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;
import steps.SignInSteps;
import tests.BaseTests;

public class CompanySignInTests extends BaseTests {
    private WebDriver driver;
    private SignInPage signInPage;
    private SignInSteps signInSteps;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        signInPage = new SignInPage(driver);
        signInSteps = new SignInSteps(driver);
    }

    @Test(description = "MRKTGLD-12 / Check click on Sign In opens Sign In page with Company Switch")
    public void clickOnSignIn() {
        signInSteps.OpensCompanySignInPage();
        signInPage.clickToCompany();
        Assert.assertEquals(signInPage.getCompanyElementSelected(), "Company");
    }

    @Test(description = "MRKTGLD-13 / Check Sign In Page Title")
    public void CheckSignInTitle() {
        signInSteps.OpensCompanySignInPage();
        Assert.assertEquals(signInPage.getPageTitle(), "Welcome back");
    }

    @Test(description = "MRKTGLD-21 / Check page description text under page title")
    public void CheckPageDescriptionText() {
        signInSteps.OpensCompanySignInPage();
        Assert.assertEquals(signInPage.getPageDescription(), "Sed urna massa adipiscing egestas accumsan");
    }
}
