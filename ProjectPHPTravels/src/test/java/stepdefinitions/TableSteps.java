package stepdefinitions;

import base.BrowserSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TablePage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class TableSteps {

    private TablePage gridAnalyzer = new TablePage(BrowserSetup.getDriver());
    private LoginPage loginApp = new LoginPage(BrowserSetup.getDriver());
    
    @When("user enters valid login credentials")
    public void bypassLoginWithStaticData() {
        System.out.println("Pushing hardcoded admin credentials...");
        
        String staticUser = "user@phptravels.com";
        String staticPass = "demouser";
        
        loginApp.enterUsername(staticUser);
        loginApp.enterPassword(staticPass);
    }

    @Then("user validates booking table data for duplicates and prices")
    public void analyzeGridMetrics() {
        System.out.println("Starting DOM scraping for table data...");
        List<Map<String, String>> scrapedData = gridAnalyzer.getTableData();
        System.out.println("Total valid rows scraped: " + scrapedData.size());
        
        gridAnalyzer.findDuplicateBookings(scrapedData);
        gridAnalyzer.printHighestAndLowestPrice(scrapedData);
    }
}