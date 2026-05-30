package utilities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static WebElement waitForClickable(WebDriver activeDriver, By elementLocator, int secondsToWait) {
        WebDriverWait explicitWait = new WebDriverWait(activeDriver, Duration.ofSeconds(secondsToWait));
        return explicitWait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public static WebElement waitForVisible(WebDriver activeDriver, By elementLocator, int secondsToWait) {
        WebDriverWait explicitWait = new WebDriverWait(activeDriver, Duration.ofSeconds(secondsToWait));
        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public static WebElement waitForPresence(WebDriver activeDriver, By elementLocator, int secondsToWait) {
        WebDriverWait explicitWait = new WebDriverWait(activeDriver, Duration.ofSeconds(secondsToWait));
        return explicitWait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    public static void waitForAlert(WebDriver activeDriver, int secondsToWait) {
        WebDriverWait explicitWait = new WebDriverWait(activeDriver, Duration.ofSeconds(secondsToWait));
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitForFrame(WebDriver activeDriver, By frameLocator, int secondsToWait) {
        WebDriverWait explicitWait = new WebDriverWait(activeDriver, Duration.ofSeconds(secondsToWait));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }
    
    public static List<WebElement> waitForAllVisible(WebDriver activeDriver, By elementsLocator, int secondsToWait) {
        WebDriverWait explicitWait = new WebDriverWait(activeDriver, Duration.ofSeconds(secondsToWait));
        return explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementsLocator));
    }
}