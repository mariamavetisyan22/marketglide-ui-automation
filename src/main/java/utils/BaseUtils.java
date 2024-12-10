package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class BaseUtils {

    private WebDriverWait wait;
    private final WebDriver driver;

    public BaseUtils(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public String getText(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.getText();
    }

    public void click(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForInVisibility(final By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void sendText(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(text);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
