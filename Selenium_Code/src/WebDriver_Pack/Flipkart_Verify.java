package WebDriver_Pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart_Verify {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
//		WebElement clsoeBtn = wait.until(
//				ExpectedConditions.elementToBeClickable(
//						By.cssSelector("input[class=\"b3wTlE\"]")));
		WebElement clsoeBtn = driver.findElement(By.className("b3wTlE"));
		clsoeBtn.click();
				
		WebElement searchBox = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.cssSelector("input[class=\"nw1UBF v1zwn25\"]")));
		searchBox.click();
		searchBox.sendKeys("Laptop");
		searchBox.sendKeys(Keys.ENTER);
		
	}

}
