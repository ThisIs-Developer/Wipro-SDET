package eBay;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

@SuppressWarnings("unused")
public class eBay_TestCase {
	WebDriver driver;
	WebDriverWait wait;
	
  @BeforeTest (alwaysRun =true)
  public void beforeTest() {
	  driver = new ChromeDriver();
	  
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      
      driver.manage().window().maximize();
      driver.get("https://www.ebay.com/");
  }
  
  @DataProvider (name="UserData")
  public Object[][] data(){
	  return new Object[][] {
			  {"Test","Selenium","baivabbandel@gmail.com","test@selenium123"}
	  };
  }
  
  @DataProvider (name="searchItems")
  public Object[][] itmes(){
	  return new Object[][] {
		  {"pokemon cards"},
		  {"Super Saiyan"},
		  {"Car"}
	  };
  }
  
  @Test (priority=1, groups="Regression", dataProvider="UserData")
  public void registerUser(String fname, String lname, String email, String password) throws IOException {
	  POM_eBay pom = new POM_eBay(driver, wait);
	  pom.register(fname, lname, email, password);

	  String path = "C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\eBay_RegisterUserData.xlsx";

	  XSSFWorkbook workbook = new XSSFWorkbook();
	  XSSFSheet sheet = workbook.createSheet("Sheet1");

	  int rowNo = 0;
	  XSSFRow row = sheet.createRow(rowNo++);

	  row.createCell(0).setCellValue(fname);
	  row.createCell(1).setCellValue(lname);
	  row.createCell(2).setCellValue(email);
	  row.createCell(3).setCellValue(password);

	  FileOutputStream fos = new FileOutputStream(path);
	  workbook.write(fos);
	  fos.close();
	  workbook.close();
	  System.out.println("Pass: Test executed");
  }
  
  @Test (priority=2, groups="Smoke")
  public void login() throws IOException{
//	  String path = "C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\eBay_LoginUserData.xlsx";
//	  FileInputStream file = new FileInputStream(path);
//	  
//	  try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
//		  XSSFSheet sheet =workbook.getSheet("Sheet1");
//		  String password = sheet.getRow(0).getCell(0).toString();
//		  
//		  POM_eBay pom = new POM_eBay(driver, wait);
//		  pom.login(password);
//	}
	  String password="uM8--1lcT@e$luy";
	  POM_eBay pom = new POM_eBay(driver, wait);
	  pom.login(password);
      System.out.println("Pass: Test executed");
  }
  
  @Test (priority=3, groups="Regression", dataProvider="searchItems")
  public void serachEngin(String items) {
	  POM_eBay pom = new POM_eBay(driver, wait);
	  pom.search(items);
  }

  @AfterTest 
  public void afterTest() {
	  
  }

}
