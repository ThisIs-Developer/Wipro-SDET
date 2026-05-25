package testcases;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.TutorialsNinjaPage;
import utilities.ScreenshotUtil;

public class TutorialsNinjaTest extends BaseClass {

    TutorialsNinjaPage pom;
    
    String excelPath = System.getProperty("user.dir") + "/src/test/resources/testdata/TutorialsNinja_RegisterUserData.xlsx";

    @BeforeClass
    public void initPage() {
        pom = new TutorialsNinjaPage(driver, wait);
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
        ScreenshotUtil.takeScreenshot(driver, "Checkout_Complete");
    }
    
    @Test(priority = 7)
    public void logoutUser() throws InterruptedException{
        pom.logoutUser();
    }
}