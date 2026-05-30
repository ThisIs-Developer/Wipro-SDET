package stepdefinitions;

import org.testng.Assert;
import base.BrowserSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingPage;
import pages.LoginPage;

public class BookingSteps {

    private BookingPage reservationView = new BookingPage(BrowserSetup.getDriver());
    private LoginPage authenticationPage = new LoginPage(BrowserSetup.getDriver());

    @When("user enters {string} and {string}")
    public void supplyLoginArguments(String rawUser, String rawPass) {
        authenticationPage.enterUsername(rawUser);     
        authenticationPage.enterPassword(rawPass);  
    }
    
    @And("user selects a hotel from the search results")
    public void pickTopHotelResult() {
        reservationView.selectFirstHotel();
    }

    @And("books the hotel room")
    public void proceedToRoomCheckout() {
        reservationView.clickBookNow();
    }

    @And("enters traveller details and confirms booking")
    public void supplyGuestInfoAndSubmit() {
        reservationView.enterTravellerDetailsAndConfirm();
    }

    @Then("validate booking confirmation message")
    public void checkBookingSuccessAlert() {
        boolean successFlag = reservationView.isBookingConfirmed();
        Assert.assertTrue(successFlag, "Failure: Confirmation dialog was never rendered!");
    }

    @And("user logs out")
    public void terminateSession() {
        reservationView.logout();
    }
}