package WebDriver_Pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleCheck {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(1000);
		
		String expectedtitle="Downloads | Selenium";
		String actualtitle = driver.getTitle();
		
		System.out.println("Expected title: " + expectedtitle);
		System.out.println("Actual title: " + actualtitle);

		if(expectedtitle.equals(actualtitle)) {
		    System.out.println("Title validation pass");
		} else {
		    System.out.println("Title validation fail");
		}

		Thread.sleep(1000);
		driver.close();
	}
}
