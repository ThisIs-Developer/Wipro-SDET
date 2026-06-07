package testcases;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utilities.ExtentManager;
import utilities.Log;
import utilities.ScreenshotUtil;

public class FlightBookingTest extends BaseTest {

    private final ExtentReports extent = ExtentManager.getInstance();
    private ExtentTest test;

    private HomePage homePage;
    private FlightsPage flightsPage;
    private PurchasePage purchasePage;
    private ConfirmationPage confirmationPage;

    @Test(priority=1, groups={"smoke", "regression"})
    public void verifyHomePage() {
        test = extent.createTest("Verify Home Page");
        Log.info("Home Page Verification Started");
        
        homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getPageTitle(),"BlazeDemo");
        Assert.assertEquals(homePage.getPageUrl(),"https://blazedemo.com/");
        Assert.assertTrue(homePage.isDepartureDropdownDisplayed());
        Assert.assertTrue(homePage.isDestinationDropdownDisplayed());
        Assert.assertTrue(homePage.isFindFlightsButtonDisplayed());

        homePage.selectDepartureCity("Boston");
        homePage.selectDestinationCity("London");
        homePage.clickFindFlights();

        test.pass("Home Page Verified Successfully");
        Log.info("Home Page Verification Completed");
    }

    @Test(priority = 2,groups = {"regression"},dependsOnMethods = "verifyHomePage")
    public void verifyFlightSearch() {
        test = extent.createTest("Verify Flight Search");
        Log.info("Flight Search Verification Started");
        flightsPage = new FlightsPage(driver);

        Assert.assertTrue(flightsPage.isFlightTableDisplayed());
        Assert.assertTrue(flightsPage.hasFlights());

        flightsPage.chooseFirstFlight();
        test.pass("Flight Search Verified");
        Log.info("Flight Search Verification Completed");
    }

    @Test(priority = 3,groups = {"regression"},dependsOnMethods = "verifyFlightSearch")
    public void verifyPurchasePage() {
        test = extent.createTest("Verify Purchase Page");
        Log.info("Purchase Page Verification Started");
        purchasePage = new PurchasePage(driver);

        Assert.assertTrue(purchasePage.isPriceDisplayed());
        Assert.assertTrue(purchasePage.isTotalCostDisplayed());

        purchasePage.enterName("Tulsi Das");
        purchasePage.enterAddress("123 Main Street");
        purchasePage.enterCity("Kolkata");
        purchasePage.enterState("West Bengal");
        purchasePage.enterZipCode("700001");
        purchasePage.selectCardType("Visa");
        purchasePage.enterCardNumber("4111111111111111");
        purchasePage.enterMonth("12");
        purchasePage.enterYear("2028");
        purchasePage.enterNameOnCard("Tulsi Das");
        purchasePage.clickPurchaseFlight();

        test.pass("Passenger And Payment Details Submitted");
        Log.info("Purchase Page Verification Completed");
    }

    @Test(priority = 4,groups = {"regression"},dependsOnMethods = "verifyPurchasePage")
    public void verifyBookingConfirmation() throws Exception {
        test = extent.createTest("Verify Booking Confirmation");
        Log.info("Confirmation Verification Started");
        confirmationPage = new ConfirmationPage(driver);

        Assert.assertEquals(confirmationPage.getSuccessMessage(),"Thank you for your purchase today!");
        Assert.assertFalse(confirmationPage.getPurchaseId().isEmpty());
        Assert.assertEquals(confirmationPage.getStatus(),"PendingCapture");
        Assert.assertFalse(confirmationPage.getAmount().isEmpty());
        Assert.assertFalse(confirmationPage.getCardNumber().isEmpty());
        Assert.assertFalse(confirmationPage.getDate().isEmpty());
        
        String purchaseId = confirmationPage.getPurchaseId();
        String status = confirmationPage.getStatus();
        String amount = confirmationPage.getAmount();
        String cardNumber = confirmationPage.getCardNumber();
        String bookingDate = confirmationPage.getDate();

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver,"BookingSuccess");
        test.addScreenCaptureFromPath(screenshotPath);
        Log.info("Screenshot Captured");

        String excelPath ="src/test/resources/testdata/BookingResult.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("BookingDetails");

        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("PurchaseId");
        header.createCell(1).setCellValue("Status");
        header.createCell(2).setCellValue("Amount");
        header.createCell(3).setCellValue("CardNumber");
        header.createCell(4).setCellValue("BookingDate");

        XSSFRow row = sheet.createRow(1);
        row.createCell(0).setCellValue(purchaseId);
        row.createCell(1).setCellValue(status);
        row.createCell(2).setCellValue(amount);
        row.createCell(3).setCellValue(cardNumber);
        row.createCell(4).setCellValue(bookingDate);

        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        test.pass("Booking Confirmation Verified");
        Log.info("Booking Confirmation Completed");
        extent.flush();
    }
}