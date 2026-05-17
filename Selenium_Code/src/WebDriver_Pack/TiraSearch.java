package WebDriver_Pack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TiraSearch {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tirabeauty.com/");
		Thread.sleep(500);
		driver.findElement(By.id("search")).click();
		driver.findElement(By.id("search")).sendKeys("Skin");
		driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.close();
	}
}
