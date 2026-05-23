package eBay;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_eBay {
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    
    public POM_eBay (WebDriver driver, WebDriverWait wait) {
    	this.driver=driver;
    	this.wait=wait;
    }
    
    // Register
	By findRegisterBtn = By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/span/span/a");
	By captchaform = By.id("captcha_form");
	By accType = By.id("personalaccount-radio");
	By firstname = By.id("firstname");
	By lastname = By.id("lastname");
	By mail = By.id("Email");
	By pass = By.id("password");
	By suubmitBtn = By.id("EMAIL_REG_FORM_SUBMIT");
	
	// Login
	By findLoginBtn = By.linkText("Sign in to existing account");
	By loginPass = By.id("pass");
	By loginBtn = By.id("sgnBt");
	By noOTP = By.id("smsWithCode-radio-btn-label");
	By noOTPBtn = By.id("send-button");
	By passkeyscancelBtn = By.id("passkeys-cancel-btn");
	
	// Search
	By searchBar = By.id("gh-ac");
  
	public void register(String fname, String lname, String email, String password) {
		try {
			driver.findElement(findRegisterBtn).click();
			try {
				if (driver.findElement(captchaform).isDisplayed()) {
		            Thread.sleep(20000);
					System.out.println("Solve captcha manually");
	            }
	        } catch (Exception e) {
	            System.out.println("Captcha not displayed");
	        }
			driver.findElement(accType).click();
			driver.findElement(firstname).click();
			driver.findElement(firstname).sendKeys(fname);
			driver.findElement(lastname).click();
			driver.findElement(lastname).sendKeys(lname);
			driver.findElement(mail).click();
			driver.findElement(mail).sendKeys(email);
			driver.findElement(pass).click();
			driver.findElement(pass).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(suubmitBtn).click();
		} catch (Exception e) {
			System.out.println("POM: Error Register TestCase");
		}
	}
	
	public void login(String password) {
		try {
			driver.findElement(findLoginBtn).click();
			Thread.sleep(500);
			driver.findElement(loginPass).click();
			driver.findElement(loginPass).sendKeys(password);
			driver.findElement(loginBtn).click();
			driver.findElement(noOTP).click();
			driver.findElement(noOTPBtn).click();
			Thread.sleep(11000);
			Thread.sleep(5000);
			driver.findElement(passkeyscancelBtn).click();
		}catch (Exception e) {
			System.out.println("POM: Error Login TestCase");
		}
	}
	
	public void search(String items) {
        try {
            driver.findElement(searchBar).click();
            driver.findElement(searchBar).sendKeys(Keys.CONTROL + "a");
            driver.findElement(searchBar).sendKeys(Keys.DELETE);
            driver.findElement(searchBar).sendKeys(items);
            driver.findElement(searchBar).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        } catch (Exception e) {
        	System.out.println("POM: Error Serach TestCase");
        }
    }
	
}
