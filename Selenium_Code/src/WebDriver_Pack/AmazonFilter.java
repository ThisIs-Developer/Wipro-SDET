package WebDriver_Pack;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class AmazonFilter {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		
		WebElement search = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
		search.click();
		search.sendKeys("wireless headphones");
		search.sendKeys(Keys.ENTER);
		
		TakesScreenshot ss = (TakesScreenshot)driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		File save = new File("Amazon/NoFilter_Result.jpg");
		FileHandler.copy(file,save);
		
		
		
		Thread.sleep(4000);
		driver.quit();
		
	}
}
