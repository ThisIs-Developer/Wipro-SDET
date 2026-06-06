package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitUtils;

public class ConfirmationPage {

    private WebDriver driver;
    private WaitUtils wait;

    private By successMessage = By.tagName("h1");
    private By purchaseId = By.xpath("//td[text()='Id']/following-sibling::td");
    private By status = By.xpath("//td[text()='Status']/following-sibling::td");
    private By amount = By.xpath("//td[text()='Amount']/following-sibling::td");
    private By cardNumber = By.xpath("//td[text()='Card Number']/following-sibling::td");
    private By date = By.xpath("//td[text()='Date']/following-sibling::td");
    
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }

    public String getSuccessMessage() {
        WebElement element = driver.findElement(successMessage);
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
}