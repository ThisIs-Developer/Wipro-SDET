package AssignmentDay21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyValidLogin() {

        WebElement username =
                driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement password =
                driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement loginBtn =
                driver.findElement(By.xpath("//*[@id='login']/button"));

        loginBtn.click();

        WebElement flashMsg =
                driver.findElement(By.id("flash"));

        String msg = flashMsg.getText();

        Assert.assertTrue(
                msg.contains("You logged into a secure area"),
                "Login failed!"
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
