package WebDriver_Pack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SerachInput {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.name("q")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Baivab Sarkar");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
//		driver.close();
	}
}
