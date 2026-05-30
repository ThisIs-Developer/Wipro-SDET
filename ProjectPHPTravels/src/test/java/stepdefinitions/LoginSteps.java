package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import base.BrowserSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ExcelReader;

public class LoginSteps {
    
    private LoginPage loginScreen = new LoginPage(BrowserSetup.getDriver());
    private boolean loginShouldPass;

    @Given("user launches browser")
    public void initializeBrowserSession() {
        String targetUrl = utilities.ConfigReader.init_prop().getProperty("base_url");
        BrowserSetup.getDriver().get(targetUrl + "/login");
        loginScreen.closeDemoPopupIfPresent();
        System.out.println("Authentication portal is ready.");
    }

    @When("user enters login credentials from sheet {string} and rownumber {int}")
    public void extractAndInputCredentials(String sheetName, Integer rowIndex) {
        
        ExcelReader sheetReader = new ExcelReader();
        List<Map<String, String>> dataset = sheetReader.getData("src/test/resources/testdata/LoginData.xlsx", sheetName);
        
        String inputUser = dataset.get(rowIndex).get("username");
        String inputPass = dataset.get(rowIndex).get("password");
        
        System.out.println(String.format("Fetched from Excel -> ID: %s | Secret: %s", inputUser, inputPass));
        
        // Logical check for valid demo credentials
        loginShouldPass = inputUser.equalsIgnoreCase("user@phptravels.com") && inputPass.equals("demouser");
        
        loginScreen.enterUsername(inputUser);
        loginScreen.enterPassword(inputPass);
    }

    @And("clicks on login button")
    public void triggerLoginAction() {
        loginScreen.clickLogin();
    }

    @Then("validate login result")
    public void verifyAuthenticationState() {
        if (loginShouldPass) {
            Assert.assertTrue(loginScreen.isDashboardDisplayed(), "Error: Dashboard did not load for valid user.");
            System.out.println("Access granted: Valid credentials accepted.");
        } else {
            boolean hasErrorMsg = loginScreen.isErrorMessageDisplayed();
            boolean isStillOnLogin = !loginScreen.isDashboardDisplayed();
            
            Assert.assertTrue(hasErrorMsg || isStillOnLogin, "Security Flaw: Invalid login was allowed through.");
            System.out.println("Access denied: Invalid login caught successfully.");
        }
    }
}