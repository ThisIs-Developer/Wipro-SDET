package Testing_Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_Tira {
  WebDriver driver;
  
  // login
  By goLogin = By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[2]/div[1]/div/div[4]/div/a/div/img");
  By phone = By.id("mobile-number-input");
  By tc = By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div/div/div/div[1]/div[2]/div/div");
  By sendOtp = By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div/div/div/div[2]/button");
  By otpBtn = By.xpath("//*[@id=\"main-content\"]/div[2]/div[2]/div/div/div/div[2]/button");
  
  public POM_Tira(WebDriver driver) {
	  this.driver=driver;
  }
  
  public void login() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(goLogin).click();
	  driver.findElement(phone).click();
	  driver.findElement(phone).sendKeys("8961428548");
	  Thread.sleep(1000);
	  driver.findElement(tc).click();
	  Thread.sleep(1000);
	  driver.findElement(sendOtp).click();
	  Thread.sleep(10000);
	  driver.findElement(otpBtn).click();
	  Thread.sleep(2000);
  }
}
