package WebDriver_Pack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonFilter2 {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
			
		WebElement search = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")));
		search.click();
		search.sendKeys("wireless headphones");
		search.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 1500)");
		
		TakesScreenshot ss = (TakesScreenshot)driver;
		File file = ss.getScreenshotAs(OutputType.FILE);
		File save = new File("Amazon/NoFilter_Result.jpg");
		FileHandler.copy(file,save);
		
		WebElement boat = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"p_123/214020\"]/span")));
		boat.click();
		
//		WebElement jbl = driver.findElement(By.xpath("//*[@id=\"p_123/233043\"]/span/a"));
//		jbl.click();
//		WebElement noise = driver.findElement(By.xpath("//*[@id=\"p_123/42717\"]/span/a"));
//		noise.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 1500)");
		TakesScreenshot ss2 = (TakesScreenshot)driver;
		File file2 = ss2.getScreenshotAs(OutputType.FILE);
		File save2 = new File("Amazon/BrandFilter_Result.jpg");
		FileHandler.copy(file2,save2);
		
		
		WebElement bluetooth = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"p_n_feature_six_browse-bin/212371788031\"]/span")));
		bluetooth.click();

		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 1500)");
		TakesScreenshot ss3 = (TakesScreenshot)driver;
		File file3 = ss3.getScreenshotAs(OutputType.FILE);
		File save3 = new File("Amazon/TechnologyFilter_Result.jpg");
		FileHandler.copy(file3,save3);
		
		
		WebElement discount = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"p_n_pct-off-with-tax/27060457031\"]/span")));
		discount.click();

		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 1500)");
		TakesScreenshot ss4 = (TakesScreenshot)driver;
		File file4 = ss4.getScreenshotAs(OutputType.FILE);
		File save4 = new File("Amazon/DiscountFilter_Result.jpg");
		FileHandler.copy(file4,save4);
		
		WebElement colour = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/span/div/div[3]/div[12]/ul/span/span[1]/li")));
		colour.click();
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, 300)");
		TakesScreenshot ss5 = (TakesScreenshot)driver;
		File file5 = ss5.getScreenshotAs(OutputType.FILE);
		File save5 = new File("Amazon/ColourFilter_Result.jpg");
		FileHandler.copy(file5,save5);
		
		Thread.sleep(4000);
		driver.quit();
		
	}
}
