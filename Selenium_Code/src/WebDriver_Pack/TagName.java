package WebDriver_Pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		
		List<WebElement> ele = driver.findElements(By.tagName("text"));
		for(WebElement element : ele) {
			System.out.println(element.getAttribute("type"));
		}
	}

}
