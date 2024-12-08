package tests.company;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.company.CompanyRegistrationPage;
import pages.company.CompanySignInPage;
import tests.BaseTests;

public class CompanyRegistrationTests extends BaseTests {

    private WebDriver driver;
    private HomePage homePage;
    private CompanyRegistrationPage companyRegistrationPage;
    private CompanySignInPage companySignInPage;

    @BeforeMethod()
    public void beforeInit() {
        driver = getDriver();
        homePage = new HomePage(driver);
        companyRegistrationPage = new CompanyRegistrationPage(driver);
        companySignInPage = new CompanySignInPage(driver);
    }

    @Test(description = "Check the successfully registration of company with all filled data")
    public void companyRegistrationWithAllFields() {
        Assert.assertEquals(homePage.getPageTitle(), "Connecting Investors with\n" +
                "Opportunities in Emerging Markets");
        homePage.clickJoinCompanyButton();
        Assert.assertEquals(companyRegistrationPage.getCompanyRegistrationPageTitle(), "Registration for Companies");
//        companyRegistrationPage.sendTextToEmailInputField("m.avetis22" + )
    }

}
