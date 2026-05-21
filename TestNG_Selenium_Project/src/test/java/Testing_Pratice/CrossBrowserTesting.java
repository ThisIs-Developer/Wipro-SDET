package Testing_Pratice;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowserTesting {
  WebDriver driver;
		
  @Test (groups = {"Smoke"})
  public void chrome() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/");
	  Thread.sleep(2000);
  }
  
  @Test (groups = {"Regression"})
  public void edge() throws InterruptedException {
	  driver = new EdgeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/"); 
	  Thread.sleep(2000);
  }
  
  @Test (groups = {"Smoke"})
  public void firefox() throws InterruptedException {
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.selenium.dev/"); 
	  Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
