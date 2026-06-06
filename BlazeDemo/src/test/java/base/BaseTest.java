package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger = LogManager.getLogger(this.getClass());

    @BeforeClass(alwaysRun = true)
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        logger.info("Launching Browser : "+ browser);

        switch (browser.toLowerCase()) {
        case "chrome":
            driver = new ChromeDriver();
            break;

        case "firefox":
            driver = new FirefoxDriver();
            break;

        case "edge":
            driver = new EdgeDriver();
            break;

        default:
            throw new RuntimeException("Unsupported Browser : "+ browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.getProperty("url"));
        logger.info("Application Opened");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing Browser");
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}