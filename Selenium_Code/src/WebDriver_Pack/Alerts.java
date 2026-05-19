package WebDriver_Pack;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Simple alert
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		//timer alert
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(7000);
		driver.switchTo().alert().accept();
		
		//Confirm box alert
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
		//Prompt box alert
		driver.findElement(By.id("promtButton")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hola");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		
		driver.quit();
	}
}
