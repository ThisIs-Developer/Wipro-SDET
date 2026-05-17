package WebDriver_Pack;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class DemoQA {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		
		WebElement fname = driver.findElement(By.id("firstName"));
		fname.sendKeys("Hello");
		
		WebElement lname = driver.findElement(By.id("lastName"));
		lname.sendKeys("Hi");
		
		WebElement email = driver.findElement(By.id("userEmail"));
		email.sendKeys("exmaple@gmail.com");
		
		driver.findElement(By.id("gender-radio-1")).click();
		
		WebElement phno = driver.findElement(By.id("userNumber"));
		phno.sendKeys("9876543210");
		
		driver.findElement(By.id("dateOfBirthInput")).click();
		WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
		WebElement month = driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
		
		Select yselect = new Select(year);
		yselect.selectByIndex(102);
		
		Select mselect = new Select(month);
		mselect.selectByValue("9");
		
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[4]/div[6]")).click();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 900)"); // Scroll Down
//		js.executeScript("window.scrollBy(0, -300)"); // Scroll Up
//		js.executeScript("window.scrollBy(300, 0)"); // Scroll Right
//		js.executeScript("window.scrollBy(-300, 0)"); // Scroll Left
		
		WebElement subject = driver.findElement(By.id("subjectsInput"));
		subject.sendKeys("Com");
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ENTER);
		
		subject.sendKeys("H");
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ENTER);
		
		subject.sendKeys("H");
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_DOWN);
		subject.sendKeys(Keys.ARROW_UP);
		subject.sendKeys(Keys.ARROW_UP);
		subject.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("hobbies-checkbox-1")).click();
		driver.findElement(By.id("hobbies-checkbox-2")).click();
		
		WebElement image = driver.findElement(By.id("uploadPicture"));
		image.sendKeys("C:\\Users\\User\\Downloads\\latex_test_suite.md");
		
		WebElement address = driver.findElement(By.id("currentAddress"));
		address.sendKeys("Kolkata, WB,712123");
		
		WebElement state = driver.findElement(By.xpath("//*[@id=\"react-select-3-input\"]"));
		state.click();
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ARROW_UP);
		state.sendKeys(Keys.ENTER);
		
		WebElement city = driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
		city.click();
		city.sendKeys(Keys.ARROW_DOWN);
		city.sendKeys(Keys.ARROW_DOWN);
		city.sendKeys(Keys.ARROW_UP);
		city.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("submit")).click();
				
		TakesScreenshot ss =(TakesScreenshot)driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		   
		File save = new File("DemoQAform.png");
		FileHandler.copy(file, save);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
