package WebDriver_Pack;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

// Demonstration of:
// 1. Implicit Wait
// 2. Explicit Wait
// 3. Fluent Wait

public class Wait_Code {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        // 1. IMPLICIT WAIT
        // Global wait applicable for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Element will wait up to 10 sec automatically
        WebElement searchBox1 =
                driver.findElement(By.id("twotabsearchtextbox"));

        searchBox1.sendKeys("Laptop");

        System.out.println("Implicit Wait Executed");

        // 2. EXPLICIT WAIT
        // Wait for specific element condition
        WebDriverWait explicitWait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("nav-search-submit-button"))
        );

        searchButton.click();

        System.out.println("Explicit Wait Executed");

        // 3. FLUENT WAIT
        // Custom wait with polling frequency
        Wait<WebDriver> fluentWait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(30)) // Maximum wait
                        .pollingEvery(Duration.ofSeconds(5)) // Check every 5 sec
                        .ignoring(NoSuchElementException.class);

        WebElement element = fluentWait.until(
                new Function<WebDriver, WebElement>() {

                    public WebElement apply(WebDriver driver) {

                        return driver.findElement(
                                By.id("twotabsearchtextbox"));
                    }
                });

        element.clear();
        element.sendKeys("Mobile");

        System.out.println("Fluent Wait Executed");

        // Close browser
        driver.quit();
    }
}