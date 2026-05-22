package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Excel_Login_Validation {
	WebDriver driver;
	
	@DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        FileInputStream file =new FileInputStream("C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\LoginData.xlsx");
        XSSFWorkbook workbook =new XSSFWorkbook(file);
 
        XSSFSheet sheet =workbook.getSheet("Sheet2");
 
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();
 
        Object[][] data = new Object[rows - 1][cols];
 
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] =
                sheet.getRow(i).getCell(j).toString();
            }
        }
 
        workbook.close();
        return data;
    }
	
	@BeforeTest
    public void beforetest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

	
  @Test (dataProvider="loginData")
  public void loginVerify(String ID, String PASS) throws InterruptedException {
	  WebElement username =
              driver.findElement(By.id("username"));
      username.sendKeys(ID);

      WebElement password =
              driver.findElement(By.name("password"));
      password.sendKeys(PASS);

      WebElement loginBtn =
              driver.findElement(By.xpath("//*[@id='login']/button"));

      loginBtn.click();
      Thread.sleep(1000);

      WebElement flashMsg = driver.findElement(By.id("flash"));
      String msg = flashMsg.getText();
      Assert.assertTrue(msg.contains("You logged into a secure area"),"Login failed!");

  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
