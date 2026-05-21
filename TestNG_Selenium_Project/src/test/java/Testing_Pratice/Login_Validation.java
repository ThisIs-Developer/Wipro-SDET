package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login_Validation {
	WebDriver driver;
	
	@DataProvider(name = "loginData")
    public Object[][] dp() {
        return new Object[][]{
                {"username", "SuperSecretPassword!"},
                {"wronguser", "SuperSecretPassword!"},
                {"username", "WrongPassword123"},
                {"123456", "987654"},
                {"user!@#", "Pass!@#123"},
                {"", ""},
                {"", "SuperSecretPassword!"},
                {"username", ""},
                {null, null},
                {"tomsmith", "SuperSecretPassword!"}
        };
    }
	
	@BeforeTest
    public void beforetest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

	
  @Test (dataProvider="loginData")
  public void loginVerify(String id, String pass) throws InterruptedException {
	  WebElement username =
              driver.findElement(By.id("username"));
      username.sendKeys(id);

      WebElement password =
              driver.findElement(By.name("password"));
      password.sendKeys(pass);

      WebElement loginBtn =
              driver.findElement(By.xpath("//*[@id='login']/button"));

      loginBtn.click();
      Thread.sleep(2000);

      WebElement flashMsg = driver.findElement(By.id("flash"));
      String msg = flashMsg.getText();
      Assert.assertTrue(msg.contains("You logged into a secure area"),"Login failed!");

  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
