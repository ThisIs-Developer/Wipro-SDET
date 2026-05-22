package Testing_Pratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_Amazon {
	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    
    // registration
    By loginC = By.xpath("//*[@id=\"nav-link-accountList\"]/a");
    By emailC = By.id("ap_email_login");
    By crtBtnC = By.xpath("//*[@id=\"intention-submit-button\"]/span/input");
    By phoneNoC = By.id("ap_phone_number");
    By nameC = By.id("ap_customer_name");
    By passwordC = By.id("ap_password");
    By continueBtnC = By.id("continue");
	By checkboxC = By.xpath("//*[@id=\"proceed-with-mobile-conflict\"]/div/div[1]/label/i");
	By verifyNoC = By.xpath("//*[@id=\"auth-create-account-btn\"]/span/input");
	
	// logini
	By emailL = By.id("ap_email_login");
	By passwordL = By.id("ap_password");
	By whatsappOTPL = By.xpath("//*[@id=\"auth-send-code\"]/span/input");
	By otpSubmitL = By.id("auth-signin-button");
	
	//Search
	By searchA = By.id("twotabsearchtextbox");
	
	//Add cart
	By addCartA = By.id("a-autoid-3-announce");
	By goCartA = By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]");
	
	// view pro
	By totalProductsA = By.cssSelector("span.a-truncate-cut");
	By productsA = By.cssSelector("span.a-truncate-cut");
	
	//Delete
	By deleteBtnA = By.xpath("//input[@value='Delete']");
	
	// update A
	By procedbtnA = By.name("proceedToRetailCheckout");
	By changeAddressLinkA = By.xpath("/html/body/div[5]/div[1]/div/div/div[2]/div/div[4]/div[2]/div/div[2]/span/a");
	By useThisAddressBtnA = By.xpath("//input[contains(@id, 'checkout-primary-continue-button')] | //*[@id='checkout-primary-continue-button-id']//input");
	
	
	public POM_Amazon(WebDriver driver, WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
	}
	
	public void registration() {
		try {
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(loginC));
            login.click();

            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(emailC));
            email.sendKeys("baivabbandel@gmail.com");
            email.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            WebElement crtBtn = wait.until(ExpectedConditions.elementToBeClickable(crtBtnC));
            crtBtn.click();
            Thread.sleep(1000);

            WebElement phoneNo = wait.until(ExpectedConditions.elementToBeClickable(phoneNoC));
            phoneNo.sendKeys("9876543210");
            phoneNo.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            WebElement name = wait.until(ExpectedConditions.elementToBeClickable(nameC));
            name.sendKeys("Hello Testing");
            name.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            try {
                WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordC));
                password.sendKeys("Hello@123");
            } catch (Exception e) {
                System.out.println("Password field not found");
            }
            Thread.sleep(1000);

            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtnC));
            continueBtn.click();
            Thread.sleep(20000);

            try {
                WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxC));
                checkbox.click();

                WebElement verifyNo = wait.until(ExpectedConditions.elementToBeClickable(verifyNoC));
                verifyNo.click();
            } catch (Exception e) {
                System.out.println("Verification option not found");
            }
        } catch (Exception e) {
            System.out.println("Registration failed : " + e.getMessage());
        }
	}
	
	public void login() {
		try {
            driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(emailL));
            email.sendKeys("baivabsarkar@gmail.com");
            email.sendKeys(Keys.ENTER);
            Thread.sleep(2000);

            WebElement password = wait.until(ExpectedConditions.elementToBeClickable(passwordL));
            password.sendKeys("baivab@bandel");
            password.sendKeys(Keys.ENTER);

            try {
                Thread.sleep(2000);
                WebElement whatsappOTP = wait.until(ExpectedConditions.elementToBeClickable(whatsappOTPL));
                whatsappOTP.click();
            } catch (Exception e) {
                System.out.println("WhatsApp OTP option not found");
            }
            Thread.sleep(15000);

            try {
                WebElement otpSubmit = wait.until(ExpectedConditions.elementToBeClickable(otpSubmitL));
                otpSubmit.sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("OTP submit button not found");
            }
        } catch (Exception e) {
            System.out.println("Login failed : " + e.getMessage());
        }
	}
	
	public void serachEng() {
		String[] products = {
                "wireless headphones",
                "Kitchen Product",
                "Party Product"
        };

        for (String item : products) {
            try {
                WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchA));
                search.click();
                search.sendKeys(Keys.CONTROL + "a");
                search.sendKeys(Keys.DELETE);
                search.sendKeys(item);
                search.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Search failed for : " + item);
            }
        }
	}
	
	public void add_to_cart() {
		String[] products = {
                "wireless headphones",
                "laptop",
                "smart watch"
        };
        for (String item : products) {
            try {
                WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchA));
                search.click();
                search.sendKeys(Keys.CONTROL + "a");
                search.sendKeys(Keys.DELETE);
                search.sendKeys(item);
                search.sendKeys(Keys.ENTER);
                Thread.sleep(2000);
                
                WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable(addCartA));
                addCart.click();
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("Unable to add product : " + item);
            }
        }

        try {
            WebElement goCart = wait.until(ExpectedConditions.visibilityOfElementLocated(goCartA));
            goCart.click();

        } catch (Exception e) {
            System.out.println("Cart button not found");
        }
	}
	
	public void viewProduct() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
        int totalProducts = driver.findElements(totalProductsA).size();
        
        for (int i = 0; i < totalProducts; i++) {
            List<WebElement> products = driver.findElements(productsA);

            WebElement product = products.get(i);
            product.click();
            Thread.sleep(3000);

            for (String window : driver.getWindowHandles()) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            Thread.sleep(3000);
            driver.close();
            driver.switchTo().window(parentWindow);
            Thread.sleep(2000);
        }
	}
	
	public void remove_from_cart() {
		try {
            WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(deleteBtnA));
            deleteBtn.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Delete button not found");
        }
	}
	
	public void updateAddress() {
		WebElement procedbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(procedbtnA));
    	procedbtn.click();

        try {
        	WebElement changeAddressLink = wait.until(ExpectedConditions.elementToBeClickable(
                    changeAddressLinkA
                ));
                changeAddressLink.click();
                Thread.sleep(3000);
                
                WebElement clickableLabel = driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div/div[2]/div/div[4]/div[2]/div[2]/form/div/fieldset/div[3]/div[2]/span/div/label/i"));
                clickableLabel.click();
                Thread.sleep(2000); 
                    
                WebElement useThisAddressBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    useThisAddressBtnA
                ));
                
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", useThisAddressBtn);
                Thread.sleep(1000);
                    
                useThisAddressBtn.click();
        } catch (Exception e) {

            System.out.println("Address update failed");
        }
	}
}
