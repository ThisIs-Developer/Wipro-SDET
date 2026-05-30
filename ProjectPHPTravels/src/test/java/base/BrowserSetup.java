package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class BrowserSetup {

    private static ThreadLocal<WebDriver> activeDriverThread = new ThreadLocal<>();

    public WebDriver init_driver(String browserType) {
        System.out.println("Initializing execution on: " + browserType.toUpperCase());

        switch (browserType.toLowerCase()) {
            case "chrome":
                activeDriverThread.set(new ChromeDriver());
                break;
            case "firefox":
                activeDriverThread.set(new FirefoxDriver());
                break;
            case "edge":
                activeDriverThread.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type specified: " + browserType);
        }

        WebDriver currentInstance = getDriver();
        currentInstance.manage().deleteAllCookies();
        currentInstance.manage().window().maximize();
        currentInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        return currentInstance;
    }

    public static synchronized WebDriver getDriver() {
        return activeDriverThread.get();
    }
    
    public static synchronized void removeDriver() {
        activeDriverThread.remove();
    }
}