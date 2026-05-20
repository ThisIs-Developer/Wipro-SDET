package WebDriver_Pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_Verify {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
//        driver.get("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.get("https://www.amazon.in/");
        
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement email = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("ap_email_login"))
        );
        email.sendKeys("baivabsarkar@gmail.com");
        email.sendKeys(Keys.ENTER);

        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("");
        password.sendKeys(Keys.ENTER);
		
        Thread.sleep(11000);
        WebElement otpsubmit = driver.findElement(By.id("auth-signin-button"));
        otpsubmit.sendKeys(Keys.ENTER);
        
        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
		search.click();
		search.sendKeys("Laptop");
		search.sendKeys(Keys.ENTER);
		
		WebElement brand = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_123/308445\"]/span/a")));
		brand.click();

//		WebElement hp = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[1]/a")));
//		hp.click();
		
		WebElement addcart = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/span/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[4]/div/div/div/div[2]/div/form/div/div/span/div/span/span/button")));
		addcart.click();
		
		Thread.sleep(5000);
		WebElement gocart = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]")));
		gocart.click();
				
		WebElement buyBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.name("proceedToRetailCheckout")));
		buyBtn.click();
	}
}
