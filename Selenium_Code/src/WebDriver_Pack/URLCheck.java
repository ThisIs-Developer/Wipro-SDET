package WebDriver_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URLCheck {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(1000);
		
		String expectedURL="https://www.selenium.dev/downloads/";
		String actualURL = driver.getCurrentUrl();
		
		System.out.println("Expected URL: " + expectedURL);
		System.out.println("Actual URL: " + actualURL);

		if(expectedURL.equals(actualURL)) {
		    System.out.println("URL validation pass");
		} else {
		    System.out.println("URL validation fail");
		}

		Thread.sleep(1000);
		driver.close();
	}
}
