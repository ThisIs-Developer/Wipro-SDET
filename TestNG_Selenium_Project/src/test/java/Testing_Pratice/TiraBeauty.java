package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TiraBeauty {
	 WebDriver driver;
	 WebDriverWait wait;
	 JavascriptExecutor js;

	 @BeforeTest (alwaysRun = true)
	 public void beforeTest() {
		 driver = new ChromeDriver();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		 driver.get("https://www.tirabeauty.com/");
	 }
	 
	 @Test (priority= 1, groups = "Smoke")
	 public void loginUser() throws InterruptedException {
		 POM_Tira p = new POM_Tira(driver);
		 p.login();
	 }
	 
  @AfterTest (alwaysRun = true)
  public void afterTest() {
	  driver.quit();
  }

}
