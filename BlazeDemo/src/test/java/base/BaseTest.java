package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ConfigReader;
import utilities.Log;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setup() {

        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {
        case "chrome":
        	driver = new ChromeDriver();
            Log.info("Launching Browser : " + browser);
            break;

        case "firefox":
            driver = new FirefoxDriver();
            Log.info("Launching Browser : " + browser);
            break;
            
        case "edge":
            driver = new EdgeDriver();
            Log.info("Launching Browser : " + browser);
            break;

        default:
            Log.error("Unsupported Browser : " + browser);
            throw new RuntimeException("Unsupported Browser : " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getProperty("url"));
        Log.info("Application Opened");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
        	Log.info("Closing Browser");
            driver.quit();
        }
    }
}