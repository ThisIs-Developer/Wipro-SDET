package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

public class BookingPage {

    private WebDriver webDriver;

    private By locMoreInfo = By.xpath("(//a[contains(., 'More Details') or contains(@href, 'stay/')])[1]");
    private By locBookBtn = By.xpath("(//button[contains(., 'Book Now') or contains(., 'Book')])[1]");
    private By locPickRoom = By.xpath("(//button[contains(., 'Select')])[1]");
    private By locProceedBtn = By.xpath("//button[contains(., 'Continue Booking')]");
    
    private By inputFName = By.name("firstname");
    private By inputLName = By.name("lastname");
    private By inputMail = By.name("email");
    private By inputMobile = By.name("phone");
    private By chkAgreeTerms = By.id("terms_accepted"); 
    private By locSubmitBooking = By.xpath("//button[contains(., 'Confirm Booking')]");
    
    private By msgSuccess = By.id("successMessage");
    
    private By navAccount = By.xpath("//a[contains(@class, 'dropdown-toggle') and contains(., 'Account')]");
    private By navLogout = By.xpath("//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'logout')]");

    public BookingPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void selectFirstHotel() {
        System.out.println("Awaiting hotel search results to display...");
        try {
            Thread.sleep(5000); 
            WebElement moreInfoElement = WaitUtils.waitForClickable(webDriver, locMoreInfo, 15);
            JavascriptExecutor jsExec = (JavascriptExecutor) webDriver;
            
            jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", moreInfoElement);
            Thread.sleep(1000); 
            System.out.println("Accessing details for the top hotel result...");
            jsExec.executeScript("arguments[0].click();", moreInfoElement);
            
            Thread.sleep(5000); 
            boolean isServerChoked = webDriver.getTitle().contains("504") || webDriver.getPageSource().contains("Gateway time-out");
            
            if (isServerChoked) {
                System.out.println("WARNING: 504 Gateway Timeout intercepted. Triggering fallback refresh...");
                webDriver.navigate().refresh();
                Thread.sleep(5000); 
                
                if (webDriver.getTitle().contains("504") || webDriver.getPageSource().contains("Gateway time-out")) {
                    System.out.println("Fallback failed. The target server is entirely unresponsive.");
                    org.testng.Assert.fail("CRITICAL: Environment is down (504 Gateway Timeout).");
                } else {
                    System.out.println("Fallback successful! Proceeding to room selection.");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error encountered while picking hotel: " + ex.getMessage());
            org.testng.Assert.fail("Unable to locate or interact with the 'More Details' element.");
        }
    }

    public void clickBookNow() {
        System.out.println("Initiating room allocation process...");
        try {
            JavascriptExecutor jsExec = (JavascriptExecutor) webDriver;
            jsExec.executeScript("window.scrollBy(0, 600);");
            Thread.sleep(3000); 

            System.out.println("Picking the primary room configuration...");
            WebElement roomElement = WaitUtils.waitForClickable(webDriver, locPickRoom, 15);
            
            jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", roomElement);
            Thread.sleep(1000); 
            jsExec.executeScript("arguments[0].click();", roomElement);
            
            System.out.println("Room locked in. Awaiting confirmation step...");
            Thread.sleep(2000); 

            WebElement proceedElement = WaitUtils.waitForClickable(webDriver, locProceedBtn, 10);
            jsExec.executeScript("arguments[0].click();", proceedElement);
            
        } catch (Exception ex) {
            System.out.println("Room allocation error: " + ex.getMessage());
            org.testng.Assert.fail("Flow broken during room selection phase.");
        }
    }

    public void enterTravellerDetailsAndConfirm() {
        System.out.println("Populating traveler form...");
        try {
            Thread.sleep(2000); 
            JavascriptExecutor jsExec = (JavascriptExecutor) webDriver;
            WebElement termsBox = webDriver.findElement(chkAgreeTerms);
            
            jsExec.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", termsBox);
            Thread.sleep(1000);
            jsExec.executeScript("arguments[0].checked = true;", termsBox);
            jsExec.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", termsBox);
            System.out.println("T&C accepted successfully.");
            
            Thread.sleep(1000);

            WebElement submitElement = WaitUtils.waitForClickable(webDriver, locSubmitBooking, 10);
            jsExec.executeScript("arguments[0].click();", submitElement);
            
            Thread.sleep(5000); 
            boolean crashedOnSubmit = webDriver.getTitle().contains("504") || webDriver.getPageSource().contains("Gateway time-out");
            if (crashedOnSubmit) {
                System.out.println("WARNING: Server stalled on submission. Refreshing...");
                webDriver.navigate().refresh(); 
                Thread.sleep(5000); 
            }
            
        } catch (Exception ex) {
            System.out.println("Booking submission error: " + ex.getMessage());
            org.testng.Assert.fail("Failed to process traveler data and finalize booking.");
        }
    }

    public boolean isBookingConfirmed() {
        try {
            WebElement successAlert = WaitUtils.waitForVisible(webDriver, msgSuccess, 20);
            System.out.println("System Confirmation: " + successAlert.getText());
            return true;
        } catch (Exception ex) {
            System.out.println("Failed to validate booking confirmation.");
            return false;
        }
    }

    public void logout() {
        System.out.println("Terminating user session...");
        try {
            JavascriptExecutor jsExec = (JavascriptExecutor) webDriver;
            try {
                WebElement accountDrop = WaitUtils.waitForClickable(webDriver, navAccount, 5);
                jsExec.executeScript("arguments[0].click();", accountDrop);
                Thread.sleep(1000);
            } catch (Exception ignored) {}
            
            WebElement exitBtn = WaitUtils.waitForClickable(webDriver, navLogout, 10);
            jsExec.executeScript("arguments[0].click();", exitBtn);
            System.out.println("Session terminated successfully.");
        } catch (Exception ex) {
            System.out.println("Error during session termination: " + ex.getMessage());
        }
    }
}