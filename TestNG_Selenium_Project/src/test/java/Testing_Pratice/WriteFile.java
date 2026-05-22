package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class WriteFile {
	WebDriver driver;
	@BeforeTest
    public void beforetest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void writeme() throws IOException {
        String title = driver.getTitle();
        
        FileInputStream file =new FileInputStream("C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\LoginData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        
        XSSFSheet sheet = workbook.getSheet("Sheet3");
        sheet = workbook.createSheet("Sheet3");

        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue(title);

        FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\LoginData.xlsx");
        workbook.write(fos);
        fos.close();
        
        workbook.close();
        file.close();
    }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
