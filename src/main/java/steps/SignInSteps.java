package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class SignInSteps {
    private WebDriver driver;
    private final HomePage homePage;

    public SignInSteps(final WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void OpensCompanySignInPage() {
        homePage.ClickToSignInPage();
    }
}
