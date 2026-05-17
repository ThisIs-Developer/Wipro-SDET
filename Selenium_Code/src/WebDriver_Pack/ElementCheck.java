package WebDriver_Pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementCheck {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\Selenium JAR\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(3000);
		driver.findElement(By.id("Layer_1")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
