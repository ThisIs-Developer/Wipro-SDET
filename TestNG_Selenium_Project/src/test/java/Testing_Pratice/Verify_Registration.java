package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Verify_Registration {

   WebDriver driver;

   @BeforeTest
   public void beforeTest() {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      driver.manage().window().maximize();
      driver.get("https://demowebshop.tricentis.com/");
   }

   @DataProvider(name = "registerData")
   public Object[][] registerData() {
      return new Object[][] {
         {"John", "Smith", "john123@gmail.com", "John@123", "John@123"},
         {"Emma", "Wilson", "emma.com", "Emma@123", "Emma@123"},
         {"Rahul", "Sharma", "rahul@gmail.com", "Rahul@123", "Rahul123"},
         {"", "", "", "", ""}
      };
   }

   @Test(dataProvider = "registerData", groups = {"Smoke","Regression"})
   public void registrationTest(String fname,
                                String lname,
                                String email,
                                String pass,
                                String cpass)
                                throws InterruptedException {

      driver.get("https://demowebshop.tricentis.com/register");

      driver.findElement(By.id("gender-male")).click();
      driver.findElement(By.id("FirstName")).sendKeys(fname);
      driver.findElement(By.id("LastName")).sendKeys(lname);
      driver.findElement(By.id("Email")).sendKeys(email);
      driver.findElement(By.id("Password")).sendKeys(pass);
      driver.findElement(By.id("ConfirmPassword")).sendKeys(cpass);

      driver.findElement(By.id("register-button")).click();

      Thread.sleep(2000);

      String pageSource = driver.getPageSource();

      if(fname.isEmpty() || lname.isEmpty()
            || email.isEmpty()
            || pass.isEmpty()
            || cpass.isEmpty()) {

         Assert.assertTrue(pageSource.contains("required"));
         System.out.println("Validation Passed - Empty Fields");
      }

      else if(!pass.equals(cpass)) {

         Assert.assertTrue(pageSource.contains("do not match"));
         System.out.println("Validation Passed - Password Mismatch");
      }

      else if(!email.contains("@")) {

         Assert.assertTrue(pageSource.contains("Wrong email"));
         System.out.println("Validation Passed - Invalid Email");
      }

      else {

         Assert.assertTrue(pageSource.contains("Your registration completed"));
         System.out.println("Registration Successful");
      }
   }

   @AfterTest
   public void afterTest() {
      driver.quit();
   }
}