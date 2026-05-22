package Testing_Pratice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteSheet {

    WebDriver driver;

    String path =
    "C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\LoginResult2.xlsx";

    XSSFWorkbook workbook = new XSSFWorkbook();

    XSSFSheet sheet = workbook.createSheet("Sheet3");

    int rowNum = 0;

    @DataProvider(name = "loginData")
    public Object[][] dp() {

        return new Object[][]{
                {"username", "SuperSecretPassword!"},
                {"wronguser", "SuperSecretPassword!"},
                {"tomsmith", "SuperSecretPassword!"}
        };
    }

    @BeforeTest
    public void beforetest() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(dataProvider = "loginData")
    public void loginVerify(String id, String pass)
            throws InterruptedException {

        WebElement username =
                driver.findElement(By.id("username"));

        username.clear();
        username.sendKeys(id);

        WebElement password =
                driver.findElement(By.name("password"));

        password.clear();
        password.sendKeys(pass);

        XSSFRow row = sheet.createRow(rowNum++);

        row.createCell(0).setCellValue(id);
        row.createCell(1).setCellValue(pass);

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterTest
    public void afterTest() throws IOException {

        FileOutputStream fos =
                new FileOutputStream(path);

        workbook.write(fos);

        fos.close();
        workbook.close();

        driver.quit();
    }
}