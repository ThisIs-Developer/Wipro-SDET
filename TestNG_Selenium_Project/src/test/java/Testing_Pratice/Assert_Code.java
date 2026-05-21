package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Assert_Code {
	WebDriver driver;
	
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/");
  }
  
  @Test
  public void Hard_Assert() {
	 String expected = "Selenium dev";
	 String actual = driver.getTitle();
	 Assert.assertEquals(actual, expected, "Faild Title, ");
	 
	 String expectedURL = "https://www.selenium.dev/";
	 String actualURL = driver.getCurrentUrl();
	 Assert.assertEquals(actualURL, expectedURL, "Faild URL, ");
  }
  
  @Test
  public void Soft_Assert() {
	  SoftAssert soft = new SoftAssert();
	  String expected = "Selenium dev";
	  String actual = driver.getTitle();
	  soft.assertEquals(actual, expected, "Faild Title, ");
	  
	  String expectedURL = "https://www.selenium.dev/";
	  String actualURL = driver.getCurrentUrl();
	  soft.assertEquals(actualURL, expectedURL, "Faild URL, ");
  }
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
