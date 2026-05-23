package Testing_Pratice;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon_Automation2 {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    POM_Amazon pom ;

    @BeforeTest (alwaysRun = true)
    public void beforeTest() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.amazon.in/");
    }

    @Test(priority = 1)
    public void registration() throws InterruptedException {
    	pom = new POM_Amazon(driver,wait);
    	pom.registration();
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
    	pom = new POM_Amazon(driver,wait);
    	pom.login();        
    }

    @Test(priority = 3)
    public void search_Engine() throws InterruptedException {
    	pom = new POM_Amazon(driver,wait);
        pom.serachEng();
    }

    @Test(priority = 4)
    public void add_to_cart() throws InterruptedException {
    	pom = new POM_Amazon(driver,wait);
        pom.add_to_cart();
    }

    @Test(priority = 5)
    public void viewProduct() throws InterruptedException {
    	pom = new POM_Amazon(driver,wait);
        pom.viewProduct();
    }

    @Test(priority = 6)
    public void remove_from_cart() throws InterruptedException {
    	pom = new POM_Amazon(driver,wait);
        pom.remove_from_cart();
    }

    @Test(priority = 7)
    public void updateAddress() throws InterruptedException {
    	pom = new POM_Amazon(driver,wait);
    	pom.updateAddress();
    }

    @AfterTest (alwaysRun = true)
    public void afterTest() {
    	driver.quit();
    }
}