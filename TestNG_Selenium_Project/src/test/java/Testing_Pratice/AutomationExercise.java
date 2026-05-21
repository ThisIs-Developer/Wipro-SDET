package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class AutomationExercise {
	WebDriver driver;
	WebDriverWait wait;
	
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.manage().window().maximize();
	  driver.get("https://automationexercise.com/");
  }
  
  @Test (priority=1)
  public void RegisterUser() {
	  String exceptedTitle = "Automation Exercise";
	  String actualTitle;
	  try {
		  actualTitle = driver.getTitle();
		  if(exceptedTitle.equals(actualTitle));
		  System.out.println("Home Page Verified");
	  } catch(Exception e) {
		  System.out.println("Home Page Not loaded");
	  }
	  try {
		  WebElement findBtn = driver.findElement(By.cssSelector(""));
		  findBtn.click();
	  }catch (Exception e) {
		  System.out.println("Log");
	  }
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
