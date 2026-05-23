package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

    WebDriver driver;

    String username = "student";
    String password = "Password123";

    @Given("the login page is open in the default browser")
    public void the_login_page_is_open_in_the_default_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("the user enters a valid username in the username field")
    public void the_user_enters_a_valid_username_in_the_username_field() {
    	
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    @And("the user enters a valid password in the password field")
    public void the_user_enters_a_valid_password_in_the_password_field() {

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {

        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {

        WebElement successMessage = driver.findElement(By.className("post-title"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @And("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://practicetestautomation.com/logged-in-successfully/",currentUrl);
    }

    @After
    public void aftertest() {
        if (driver != null) {
            driver.quit();
        }
    }
}