package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtils;

public class ConfirmationPage {

    private WebDriver driver;
    private WaitUtils wait;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    private By successMessage = By.cssSelector("div.hero-unit h1");
    private By purchaseId = By.cssSelector("table.table tbody tr:nth-child(1) td:nth-child(2)");
    private By status = By.cssSelector("table.table tbody tr:nth-child(2) td:nth-child(2)");
    private By amount = By.cssSelector("table.table tbody tr:nth-child(3) td:nth-child(2)");
    private By cardNumber = By.cssSelector("table.table tbody tr:nth-child(4) td:nth-child(2)");
    private By date = By.cssSelector("table.table tbody tr:nth-child(7) td:nth-child(2)");

    public String getSuccessMessage() {
        WebElement element =driver.findElement(successMessage);
        wait.waitForVisibility(element);
        return element.getText();
    }

    public String getPurchaseId() {
        return driver.findElement(purchaseId).getText();
    }

    public String getStatus() {
        return driver.findElement(status).getText();
    }

    public String getAmount() {
        return driver.findElement(amount).getText();
    }

    public String getCardNumber() {
        return driver.findElement(cardNumber).getText();
    }

    public String getDate() {
        return driver.findElement(date).getText();
    }

    public boolean verifyBookingSuccess() {
        return getSuccessMessage().equals("Thank you for your purchase today!");
    }
}