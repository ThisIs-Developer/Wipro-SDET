package AssignmentDay26;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TutorialsNinja_TestCase {

	WebDriver driver;
	WebDriverWait wait;

	POM_TutorialsNinja pom;

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		pom = new POM_TutorialsNinja(driver, wait);
	}

	@DataProvider(name = "UserData")
	public Object[][] data() {
		return new Object[][] {
				{ "Test", "Selenium", "testselenium02@gmail.com",
				"9876543210", "test@123", "test@123" }
		};
	}
	
	@DataProvider(name = "searchItems")
	public Object[][] items() {
		return new Object[][] {
				{"phone"},
				{"Sony VAIO"},
				{"tab"}
		};
	}
	
	@Test(priority = 1, dataProvider = "UserData")
	public void registerUser(String fname, String lname, String email, String phone, String pass, String confirmPass) throws IOException {
		
		String excelPath = "C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\TutorialsNinja_RegisterUserData.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("RegisterData");
		XSSFRow header = sheet.createRow(0);

		header.createCell(0).setCellValue("FirstName");
		header.createCell(1).setCellValue("LastName");
		header.createCell(2).setCellValue("Email");
		header.createCell(3).setCellValue("Phone");
		header.createCell(4).setCellValue("Password");
		header.createCell(5).setCellValue("ConfirmPassword");

		XSSFRow dataRow = sheet.createRow(1);

		dataRow.createCell(0).setCellValue(fname);
		dataRow.createCell(1).setCellValue(lname);
		dataRow.createCell(2).setCellValue(email);
		dataRow.createCell(3).setCellValue(phone);
		dataRow.createCell(4).setCellValue(pass);
		dataRow.createCell(5).setCellValue(confirmPass);

		FileOutputStream fos = new FileOutputStream(excelPath);
		workbook.write(fos);
		fos.close();
		workbook.close();
		
		pom.register(fname, lname, email, phone, pass, confirmPass);
	}
	
	@Test(priority = 2)
	public void login() throws Exception {
		String excelPath = "C:\\Users\\User\\git\\Wipro-SDET\\TestNG_Selenium_Project\\TestData\\TutorialsNinja_RegisterUserData.xlsx";
		pom.loginFromExcel(excelPath);
	}
	
	@Test(priority = 3, dataProvider = "searchItems")
	public void searchEngine(String items) throws Exception {
		pom.search(items);
	}
	
	@Test(priority = 4, dataProvider = "searchItems")
	public void addProductsToCart(String items) throws Exception {
		pom.addToCart(items);
	}
	
	@Test(priority = 5)
	public void removeProductsToCart() throws Exception {
		pom.removeToCart();
	}
	
	@Test(priority = 6)
	public void checkout() throws Exception {
		pom.checkout();
	}
	
	@Test(priority = 7)
	public void logoutUser() throws InterruptedException{
		pom.logoutUser();
	}

	@AfterTest
	public void afterTest() {
		 driver.quit();
	}
}