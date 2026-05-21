package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Data_Provider {
	WebDriver driver;
	
	@DataProvider(name = "browsers")
	public Object[][] dp() {
	    return new Object[][] {
	        {"chrome"},
	        {"firefox"},
	        {"edge"}
	    };
	}

	@Test(dataProvider = "browsers")
	public void crossbrowser_test(String browser) {

	    if (browser.equalsIgnoreCase("chrome")) {

	        driver = new ChromeDriver();

	    } else if (browser.equalsIgnoreCase("firefox")) {

	        driver = new FirefoxDriver();

	    } else if (browser.equalsIgnoreCase("edge")) {

	        driver = new EdgeDriver();

	    } else {

	        System.out.println("Invalid browser");
	    }
	    driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("Title: "+driver.getTitle());
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
