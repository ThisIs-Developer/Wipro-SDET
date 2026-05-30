package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import utilities.WaitUtils;

public class LoginPage {
    
    private WebDriver browser;

    private By locEmail = By.name("email");
    private By locPass = By.name("password");
    private By btnSubmit = By.cssSelector("button[type='submit']");
    private By headerDash = By.xpath("//h1[contains(text(), 'Dashboard')]");
    private By alertError = By.xpath("//div[contains(@class, 'alert-danger')]");
    private By btnDismissPopup = By.xpath("//button[contains(text(), 'I Understand')]");

    public LoginPage(WebDriver driver) {
        this.browser = driver;
    }

    public void enterUsername(String userEmail) {
        WebElement emailInput = WaitUtils.waitForVisible(browser, locEmail, 20);
        emailInput.clear(); 
        
        if(userEmail != null && !userEmail.isEmpty()) {
            emailInput.sendKeys(userEmail);
        }
    }

    public void enterPassword(String userPass) {
        WebElement passInput = WaitUtils.waitForVisible(browser, locPass, 10);
        passInput.clear();
        
        if(userPass != null && !userPass.isEmpty()) {
            passInput.sendKeys(userPass);
        }
    }

    public void clickLogin() {
        WebElement loginNode = WaitUtils.waitForClickable(browser, btnSubmit, 10);
        ((JavascriptExecutor) browser).executeScript("arguments[0].click();", loginNode);
    }

    public boolean isDashboardDisplayed() {
        try {
            WebDriverWait dynamicWait = new WebDriverWait(browser, Duration.ofSeconds(10));
            return dynamicWait.until(ExpectedConditions.urlContains("dashboard"));
        } catch (Exception ex) {
            System.out.println("Validation error: Dashboard not found. URL is: " + browser.getCurrentUrl());
            return false;
        }
    }
    
    public boolean isErrorMessageDisplayed() {
        try {
            return WaitUtils.waitForVisible(browser, alertError, 5).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public void closeDemoPopupIfPresent() {
        try {
            WebElement dismissNode = WaitUtils.waitForClickable(browser, btnDismissPopup, 4);
            ((JavascriptExecutor) browser).executeScript("arguments[0].click();", dismissNode);
            System.out.println("Welcome popup dismissed.");
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println("No welcome popup detected on screen.");
        }
    }
}