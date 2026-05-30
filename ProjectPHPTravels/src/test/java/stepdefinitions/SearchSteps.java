package stepdefinitions;

import org.testng.Assert;
import base.BrowserSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import pages.ResultsPage;

public class SearchSteps {

    private SearchPage searchEngine = new SearchPage(BrowserSetup.getDriver());
    private ResultsPage resultsGrid = new ResultsPage(BrowserSetup.getDriver());

    @Given("user is on the PHPTravels home page")
    public void loadPhptravelsHomepage() {
        String envUrl = utilities.ConfigReader.init_prop().getProperty("base_url");
        BrowserSetup.getDriver().get(envUrl);
        searchEngine.closeDemoPopupIfPresent();
        searchEngine.clickStaysTab();
        System.out.println("Landing page successfully initiated.");
    }

    @When("user enters destination {string}")
    public void inputTravelDestination(String targetCity) {
        searchEngine.searchCity(targetCity);
    }

    @And("selects check-in and check-out dates")
    public void configureBookingDates() {
        searchEngine.selectDates();
    }

    @And("selects travellers count")
    public void setPassengerCount() {
        searchEngine.selectTravellers();
    }
    
    @And("selects nationality {string}")
    public void defineUserNationality(String countryCode) {
        searchEngine.selectNationality(countryCode);
    }

    @And("clicks on the hotel search button")
    public void fireSearchQuery() {
        searchEngine.clickSearch();
    }

    @Then("validate hotel search results are displayed")
    public void verifySearchResultsRendered() {
        try {
            WebDriverWait dynamicWait = new WebDriverWait(BrowserSetup.getDriver(), Duration.ofSeconds(20));
            boolean didSearchLoad = dynamicWait.until(ExpectedConditions.urlContains("stays"));
            
            Assert.assertTrue(didSearchLoad, "System failed to route to the stays page.");
            System.out.println("Search executed. Active URL: " + BrowserSetup.getDriver().getCurrentUrl());
            
        } catch (Exception ex) {
            String crashedUrl = BrowserSetup.getDriver().getCurrentUrl();
            System.out.println("Timeout Blocked! Stuck at URL: " + crashedUrl);
            Assert.fail("Results page rendering timed out.");
        }
    }

    @And("fetch and validate dynamic hotel prices")
    public void triggerPriceValidation() {
        resultsGrid.fetchAndValidateHotelData();
    }
}