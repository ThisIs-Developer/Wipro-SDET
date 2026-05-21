package Testing_Pratice;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserTesting {
  WebDriver driver;
		
  @Test
  public void chrome() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/"); 
  }
  
  @Test
  public void edge() {
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/"); 
  }
  
  @Test
  public void firefox() {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/"); 
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
