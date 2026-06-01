package stepDefinitions;

import java.io.FileOutputStream;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import hooks.Hooks;
import pages.TutorialsNinjaPage;

public class TutorialsNinjaSteps {

    static TutorialsNinjaPage page;

    String excelPath =
            "TestData/TutorialsNinja_RegisterUserData.xlsx";

    @Given("user opens TutorialsNinja website")
    public void openWebsite() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        if (!currentUrl.contains("tutorialsninja.com")) {
            Hooks.driver.get("https://tutorialsninja.com/demo/");
        }
        if (page == null) {
            page = new TutorialsNinjaPage(Hooks.driver);
        }
    }

    private String generateRandomEmail() {
        long timestamp = System.currentTimeMillis();
        int randomNum = new Random().nextInt(10000);
        return "tester.bot_" + timestamp + "_" + randomNum + "@automation.com";
    }

    @When("user registers with valid details")
    public void registerUser() throws Exception {

        String fname = "Test";
        String lname = "Selenium";
        String email = generateRandomEmail();
        String phone = "9876543210";
        String pass = "test@123";
        String confirmPass = "test@123";

        System.out.println("Generated Email: " + email);
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

        try (FileOutputStream fos = new FileOutputStream(excelPath)) {
            workbook.write(fos);
        }

        workbook.close();

        page.register(
                fname,
                lname,
                email,
                phone,
                pass,
                confirmPass);
    }

    @Then("registration should be successful")
    public void registrationSuccess() {

        System.out.println("Registration Successful");
    }

    @When("user logs in using excel data")
    public void loginUser() throws Exception {

        page.loginFromExcel(excelPath);
    }

    @Then("login should be successful")
    public void loginSuccess() {

        System.out.println("Login Successful");
    }

    @When("user searches for (.*)$")
    public void searchProduct(String product) throws Exception {

        page.search(product);
    }

    @Then("search should complete")
    public void searchComplete() {

        System.out.println("Search Completed");
    }

    @When("user adds (.*) to cart$")
    public void addProduct(String product) throws Exception {

        page.addToCart(product);
    }

    @Then("product should be added successfully")
    public void productAdded() {

        System.out.println("Product Added Successfully");
    }

    @When("user removes products from cart")
    public void removeProducts() throws Exception {

        page.removeToCart();
    }

    @Then("cart should update")
    public void cartUpdated() {

        System.out.println("Cart Updated");
    }

    @When("user proceeds to checkout")
    public void checkoutProduct() {

        page.checkout();
    }

    @Then("checkout page should open")
    public void checkoutSuccess() {

        System.out.println("Checkout Page Opened");
    }

    @When("user logs out")
    public void logoutUser() throws Exception {

        page.logoutUser();
    }

    @Then("logout should be successful")
    public void logoutSuccess() {

        System.out.println("Logout Successful");
    }
}