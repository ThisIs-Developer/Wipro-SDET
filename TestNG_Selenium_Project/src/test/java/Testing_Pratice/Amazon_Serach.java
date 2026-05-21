package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Amazon_Serach {
   WebDriver driver;
   JavascriptExecutor js;
	
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
  }
  
  @DataProvider (name="items")
  public Object[][] items(){
	  return new Object[][] {
		  {"Skin Prodcuts"},
		  {"HP"},
		  {"Product under 100"},
		  {"3.8 Star products"},
		  {"+,.@$#%#"},
		  {"Bluetooth"},
		  {"Microoven"}
	  };
  }
  @Test (dataProvider = "items")
  public void search_Engine(String item) throws InterruptedException {
	  WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
      search.click();
      search.sendKeys(Keys.CONTROL + "a");
      search.sendKeys(Keys.DELETE);
      search.sendKeys(item);
      search.sendKeys(Keys.ENTER);
      js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0, 600)");
      Thread.sleep(2000);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
