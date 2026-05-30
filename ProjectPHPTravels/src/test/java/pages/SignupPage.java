package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utilities.WaitUtils;

public class SignupPage {

    private WebDriver webAppDriver;

    private By btnUnderstand = By.xpath("//button[contains(text(), 'I Understand')]");
    private By locFName = By.name("first_name");
    private By locLName = By.name("last_name");
    private By locMail = By.name("email"); 
    private By locPass = By.name("password");
    private By locPassConfirm = By.xpath("//input[@placeholder='Confirm Password']"); 

    private By locCaptchaText = By.xpath("//input[@placeholder='Enter the answer']");
    private By chkTerms = By.xpath("//input[@type='checkbox']");
    private By btnRegister = By.cssSelector("button[type='submit']");

    public SignupPage(WebDriver driver) {
        this.webAppDriver = driver;
    }

    public void closeDemoPopupIfPresent() {
        try {
            WebElement overlayBtn = WaitUtils.waitForClickable(webAppDriver, btnUnderstand, 3);
            ((JavascriptExecutor) webAppDriver).executeScript("arguments[0].click();", overlayBtn);
            System.out.println("Registration overlay dismissed.");
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println("Registration overlay not detected.");
        }
    }

    public void enterPersonalDetails(String firstName, String lastName) {
        WaitUtils.waitForVisible(webAppDriver, locFName, 10).sendKeys(firstName);
        webAppDriver.findElement(locLName).sendKeys(lastName);
    }

    public void enterAccountDetails(String userEmail, String userSecret) {
        try {
            webAppDriver.findElement(locMail).sendKeys(userEmail);
        } catch (NoSuchElementException nse) {
            webAppDriver.findElement(By.name("user_email")).sendKeys(userEmail);
        }
        
        webAppDriver.findElement(locPass).sendKeys(userSecret);
        webAppDriver.findElement(locPassConfirm).sendKeys(userSecret); 
    }

    public void waitForManualCaptchaSolve() {
        System.out.println("WAITING: Please resolve the Captcha. 30 second timeout...");
        try {
            WebDriverWait customWait = new WebDriverWait(webAppDriver, Duration.ofSeconds(30));
            
            customWait.until(browser -> {
                String inputStatus = browser.findElement(locCaptchaText).getAttribute("value");
                return inputStatus != null && !inputStatus.trim().isEmpty();
            });
            
            System.out.println("Captcha resolved successfully. Continuing flow.");
            Thread.sleep(1000); 
        } catch (Exception ex) {
            System.out.println("Timeout: Captcha was not resolved in time.");
        }
    }

    public void clickSignup() {
        JavascriptExecutor executor = (JavascriptExecutor) webAppDriver;
        
        WebElement termsNode = WaitUtils.waitForPresence(webAppDriver, chkTerms, 5);
        executor.executeScript("arguments[0].click();", termsNode);
        
        WebElement registerNode = WaitUtils.waitForClickable(webAppDriver, btnRegister, 5);
        executor.executeScript("arguments[0].click();", registerNode);
    }
}