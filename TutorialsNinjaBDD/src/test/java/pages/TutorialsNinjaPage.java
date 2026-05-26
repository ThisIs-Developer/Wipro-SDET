package pages;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TutorialsNinjaPage {
    WebDriver driver;
    JavascriptExecutor js;

    public TutorialsNinjaPage(WebDriver driver) {
        this.driver = driver;
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
    By tacCheckbox = By.xpath("//input[@name='agree' and @value='1']");
    By continueBtn = By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]");

    // Login
    By findLogout =By.xpath("/html/body/div[2]/div/aside/div/a[13]");
    By continueLoginBtn =By.xpath("/html/body/div[2]/div/aside/div/a[1]");
    By loginEmail = By.id("input-email");
    By loginPassword = By.id("input-password");
    By loginBtn = By.xpath("//input[@value='Login']");

    // Search
    By searchBar = By.xpath("//input[@name='search']");
    By searchBtn = By.xpath("//button[@class='btn btn-default btn-lg']");

    // Add To Cart
    By addToCartBtn = By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
    By goToCartBtn = By.xpath("//button[contains(@class,'dropdown-toggle') and contains(.,'item')]");

    // Remove Products
    By openCartBtn = By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]");
    By remove1 = By.xpath("//*[@id='content']/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]");
    By remove2 = By.xpath("//*[@id='content']/form/div/table/tbody/tr[2]/td[4]/div/span/button[2]");

    // Checkout
    By checkoutBtn = By.xpath("//*[@id='content']/div[3]/div[2]/a");

    public void register(String fname,String lname,String mail,String phone,String pass,String confirmPass) {

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
        FileInputStream fis =new FileInputStream(excelPath);
        XSSFWorkbook workbook =new XSSFWorkbook(fis);
        XSSFSheet sheet =workbook.getSheet("RegisterData");
        String emailData =sheet.getRow(1).getCell(2).getStringCellValue();
        String passwordData =sheet.getRow(1).getCell(4).getStringCellValue();
        
        driver.findElement(loginEmail).sendKeys(emailData);        
        driver.findElement(loginPassword).sendKeys(passwordData);
        driver.findElement(loginBtn).click();

        workbook.close();
        fis.close();
    }

    public void search(String item) throws Exception {

        js = (JavascriptExecutor) driver;
        driver.findElement(searchBar).clear();
        driver.findElement(searchBar).sendKeys(item);
        Thread.sleep(1000);
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,450)");
        Thread.sleep(1000);
    }

    public void addToCart(String item) throws Exception {

        search(item);
        driver.findElement(addToCartBtn).click();
        Thread.sleep(1000);
        if(item.equals("tab")) {
            driver.findElement(goToCartBtn).click();
            Thread.sleep(1000);
        }
    }

    public void removeToCart() throws Exception {

        driver.findElement(openCartBtn).click();
        Thread.sleep(1000);
        driver.findElement(remove1).click();
        Thread.sleep(1000);
        driver.findElement(remove2).click();
        Thread.sleep(1000);
    }

    public void checkout() {

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        driver.findElement(checkoutBtn).click();
        try {

            WebElement outOfStockMsg = driver.findElement(
                    By.xpath("//div[contains(text(),'Products marked with *** are not available in the desired quantity or not in stock!')]"));
//            if(outOfStockMsg.isDisplayed()) { 
//            	System.out.println("Product Out Of Stock"); 
//            }
//            Assert.assertFalse(outOfStockMsg.isDisplayed(),"Product Out Of Stock");
            Assert.assertTrue(outOfStockMsg.isDisplayed(),"Out Of Stock Message Not Displayed");
        } catch (Exception e) {
            System.out.println("Going To Checkout");
        }
    }

    public void logoutUser() throws Exception {

        driver.findElement(findRegisterBtn).click();
        Thread.sleep(1000);
        driver.findElement(findLogout).click();
        Thread.sleep(1000);
    }
}