package AssignmentDay26;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_TutorialsNinja {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public POM_TutorialsNinja(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// Register 
	By findRegisterBtn = By.xpath("/html/body/footer/div/div/div[4]/ul/li[1]/a");
	By conReg = By.xpath("/html/body/div[2]/div/div/div/div[1]/div/a");
	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By email = By.id("input-email");
	By telephone = By.id("input-telephone");
	By password = By.id("input-password");
	By confirmPassword = By.id("input-confirm");
	By newsletterYes = By.xpath("//input[@name='newsletter' and @value='1']");
	By newsletterNo = By.xpath("//input[@name='newsletter' and @value='0']");
	By tacCheckbox = By.xpath("//input[@name='agree' and @value='1']");
	By continueBtn = By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]");
	
	//login
	By findLogout = By.xpath("/html/body/div[2]/div/aside/div/a[13]");
	By continueLoginBtn = By.xpath("/html/body/div[2]/div/aside/div/a[1]");
	By loginEmail = By.id("input-email");
	By loginPassword = By.id("input-password");
	By loginBtn = By.xpath("//input[@value='Login']");
	
	// Product searcg
	By conHomeBtn = By.xpath("/html/body/div[2]/ul/li[1]/a");
	By searchBar = By.xpath("//input[@name='search']");
	By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");
	
	// Add to cart
	By addToCartBtn = By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
	By goToCartBtn = By.xpath("//button[contains(@class,'dropdown-toggle') and contains(.,'item')]"); 

	public void register(String fname, String lname, String mail,
			String phone, String pass, String confirmPass) {

		driver.findElement(findRegisterBtn).click();
		driver.findElement(conReg).click();

		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirmPassword).sendKeys(confirmPass);
		driver.findElement(newsletterYes).click();
		driver.findElement(tacCheckbox).click();
		driver.findElement(continueBtn).click();
	}
	
	public void loginFromExcel(String excelPath) throws Exception {
		driver.findElement(findLogout).click();
		driver.findElement(continueLoginBtn).click();
		
		FileInputStream fis = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("RegisterData");
		String emailData = sheet.getRow(1).getCell(2).getStringCellValue();
		String passwordData = sheet.getRow(1).getCell(4).getStringCellValue();

		driver.findElement(loginEmail).sendKeys(emailData);
		driver.findElement(loginPassword).sendKeys(passwordData);
		driver.findElement(loginBtn).click();
		workbook.close();
		fis.close();
	}
	
	public void search(String items) throws Exception {

		js = (JavascriptExecutor) driver;
//		driver.findElement(conHomeBtn).click();
		js.executeScript("window.scrollTo(0,300)");
		Thread.sleep(1000);

		driver.findElement(searchBar).clear();
		driver.findElement(searchBar).sendKeys(items);
		Thread.sleep(1000);
		driver.findElement(searchBtn).click();
		Thread.sleep(1000);
	}
	
	public void addToCart(String items) throws Exception {

		js = (JavascriptExecutor) driver;

		// Home
		driver.findElement(conHomeBtn).click();

		Thread.sleep(1000);

		// Scroll Top
		js.executeScript("window.scrollTo(0,0)");

		Thread.sleep(1000);

		// Search Product
		driver.findElement(searchBar).clear();

		driver.findElement(searchBar).sendKeys(items);

		Thread.sleep(1000);

		driver.findElement(searchBtn).click();

		Thread.sleep(1000);

		// Scroll Down
		js.executeScript("window.scrollBy(0,450)");

		Thread.sleep(1000);

		// Add To Cart
		driver.findElement(addToCartBtn).click();

		Thread.sleep(1000);

		// Open Cart ONLY after last DataProvider item
		if(items.equals("tab")) {

			driver.findElement(goToCartBtn).click();

			Thread.sleep(1000);
		}
	}
}