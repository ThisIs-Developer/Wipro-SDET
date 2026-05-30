package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TablePage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class TableSteps {

    private TablePage tablePage = new TablePage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    
    @When("user enters valid login credentials")
    public void user_enters_valid_login_credentials() {
        System.out.println("Entering hardcoded valid credentials for Web Table test...");
        
        String validUser = "user@phptravels.com";
        String validPass = "demouser";
        
		loginPage.enterUsername(validUser);
        loginPage.enterPassword(validPass);
    }

    @Then("user validates booking table data for duplicates and prices")
    public void user_validates_booking_table_data_for_duplicates_and_prices() {
        
        System.out.println("Starting Web Table Data Extraction...");
        List<Map<String, String>> tableData = tablePage.getTableData();
        System.out.println("Total Rows Extracted: " + tableData.size());
        tablePage.findDuplicateBookings(tableData);
        tablePage.printHighestAndLowestPrice(tableData);
    }
}