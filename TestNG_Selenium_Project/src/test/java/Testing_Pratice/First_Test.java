package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
 
public class First_Test {
	
	 WebDriver driver;
	 WebDriverWait wait ;
	 JavascriptExecutor js;
	  
	 @BeforeTest
	  public void browsersetup() {
		  driver = new ChromeDriver();
	      wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      driver.get("https://testautomationpractice.blogspot.com/");
	  }
	 
  @Test (priority = 10)
  public void unit1() {
	  js = (JavascriptExecutor) driver;
 
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Baivab");
      driver.findElement(By.id("email")).sendKeys("test@gmail.com");
      driver.findElement(By.id("phone")).sendKeys("9876543210");
      driver.findElement(By.id("textarea")).sendKeys("Pune");
 
      driver.findElement(By.id("female")).click();
      driver.findElement(By.id("monday")).click();WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Hello Hola");
		
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("exmaple.@gmail.com");
		
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9876543210");
		
		WebElement address = driver.findElement(By.xpath("//*[@id=\"textarea\"]"));
		address.sendKeys("Kolkata, WB, 712123");
		
		driver.findElement(By.id("male")).click();
  }
  
  @Test
  public void unit2()
  {
	  driver.findElement(By.id("monday")).click();
		driver.findElement(By.id("thursday")).click();
		driver.findElement(By.id("saturday")).click();
		
		WebElement country = driver.findElement(By.id("country"));
		Select cselect = new Select(country);
		cselect.selectByValue("india");
		
		WebElement colors = driver.findElement(By.id("colors"));
		Select clselect = new Select(colors);
		clselect.selectByValue("yellow");
		
		WebElement animals = driver.findElement(By.id("animals"));
		Select alselect = new Select(animals);
		alselect.selectByValue("elephant");
		
		WebElement date1 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		date1.sendKeys("10/25/2002");
		
		driver.findElement(By.xpath("//*[@id=\"txtDate\"]")).click();
		WebElement year = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
		Select yselect = new Select(year);
		yselect.selectByValue("2020");
		WebElement month = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
		Select mselect = new Select(month);
		mselect.selectByIndex(9);
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[1]/a")).click();
		
		WebElement sdate = driver.findElement(By.id("start-date"));
		sdate.sendKeys("25/10/2002");
		
		WebElement edate = driver.findElement(By.id("end-date"));
		edate.sendKeys("25/10/2026");
  }
  
  @Test
  public void unit3() {
	  	driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[8]/button")).click();
		
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 400)");
		
		WebElement suplode = driver.findElement(By.id("singleFileInput"));
		suplode.sendKeys("C:\\Users\\User\\Downloads\\latex_test_suite.md");
		
		WebElement muplode = driver.findElement(By.id("multipleFilesInput"));
		muplode.sendKeys("C:\\Users\\User\\Downloads\\latex_test_suite.md");
		muplode.sendKeys("C:\\Users\\User\\Downloads\\mermaid_test_suite.md");
  }
 
  @AfterTest
  public void afterTest() {
	  System.out.println("Successfully done");
	  driver.close();
  }
 
}