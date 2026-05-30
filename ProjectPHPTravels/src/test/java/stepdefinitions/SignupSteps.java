package stepdefinitions;

import org.testng.Assert;
import base.BrowserSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SignupSteps {

    private SignupPage registrationView = new SignupPage(BrowserSetup.getDriver());

    @Given("user is on the registration page")
    public void accessRegistrationPortal() {
        String domainUrl = utilities.ConfigReader.init_prop().getProperty("base_url");
        BrowserSetup.getDriver().get(domainUrl + "/signup");
        registrationView.closeDemoPopupIfPresent();
        System.out.println("Signup portal initialized.");
    }

    @When("user enters personal details {string} {string}")
    public void fillNamingFields(String givenName, String surname) {
        registrationView.enterPersonalDetails(givenName, surname);
    }

    @And("enters a randomly generated email and password {string}")
    public void generateDynamicCredentials(String accountPassword) {
        // Different random logic generation
        long timestampSalt = System.currentTimeMillis() % 100000;
        String dynamicEmail = "tester.bot_" + timestampSalt + "@automation.com";
        
        System.out.println("Created temp email: " + dynamicEmail);
        registrationView.enterAccountDetails(dynamicEmail, accountPassword);
    }

    @And("clicks on the signup button")
    public void finalizeRegistrationSubmission() {
        registrationView.waitForManualCaptchaSolve();
        registrationView.clickSignup(); 
    }

    @Then("validate successful registration")
    public void verifyAccountCreation() {
        try {
            WebDriverWait waiter = new WebDriverWait(BrowserSetup.getDriver(), Duration.ofSeconds(15));
            
            boolean redirectSuccessful = waiter.until(
                ExpectedConditions.or(
                    ExpectedConditions.urlContains("signup_success"),
                    ExpectedConditions.urlContains("dashboard"),
                    ExpectedConditions.urlContains("login")
                )
            );
            
            Assert.assertTrue(redirectSuccessful, "URL routing failed post-registration.");
            System.out.println("Account created! Routing logic passed.");
            
        } catch (Exception ex) {
            Assert.fail("Validation logic threw a timeout exception during signup.");
        }
    }
}