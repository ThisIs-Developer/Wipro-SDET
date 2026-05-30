package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;
import java.util.List;

public class SearchPage {

    private WebDriver activeDriver;
    
    private By locDestCity = By.cssSelector("input[placeholder='Search By City']");
    private String xpathCityMatch = "//*[contains(text(),'%s')]";
    private By tabStays = By.xpath("//button[@role='tab' and .//span[text()='Stays']]");
    
    private By inputArrival = By.name("checkin_date");
    private By inputDeparture = By.name("checkout_date");
    private By dropTravellers = By.xpath("//*[contains(text(), 'Traveler') or contains(@class, 'traveller')]");
    private By btnTriggerSearch = By.xpath("//button[@type='submit' and contains(., 'Search Hotels')]");
    
    private By btnUnderstand = By.xpath("//button[contains(text(), 'I Understand')]");
    
    public SearchPage(WebDriver driver) {
        this.activeDriver = driver;
    }
    
    public void closeDemoPopupIfPresent() {
        try {
            WebElement popupNode = WaitUtils.waitForClickable(activeDriver, btnUnderstand, 3);
            ((JavascriptExecutor) activeDriver).executeScript("arguments[0].click();", popupNode);
            System.out.println("Bypassed demo overlay.");
            Thread.sleep(1000); 
        } catch (Exception ex) {
            System.out.println("No demo overlay present.");
        }
    }

    public void clickStaysTab() {
        try {
            WebElement tabNode = WaitUtils.waitForPresence(activeDriver, tabStays, 10);
            ((JavascriptExecutor) activeDriver).executeScript("arguments[0].click();", tabNode);
            System.out.println("Navigated to Stays module.");
            Thread.sleep(2000); 
        } catch (Exception ex) {
            System.out.println("Module switch failed: " + ex.getMessage());
            org.testng.Assert.fail("Failed to activate Stays tab: " + ex.getMessage());
        }
    }
    
    public void searchCity(String targetCity) {
        try {
            List<WebElement> cityFields = activeDriver.findElements(locDestCity);
            
            WebElement targetInput = cityFields.stream()
                                               .filter(WebElement::isDisplayed)
                                               .findFirst()
                                               .orElse(null);
            
            if(targetInput != null) {
                targetInput.clear();
                targetInput.sendKeys(targetCity);
                System.out.println("Entered destination: " + targetCity);
                Thread.sleep(2500);

                By specificCityNode = By.xpath(String.format(xpathCityMatch, targetCity));
                WebElement autoSuggestOption = WaitUtils.waitForClickable(activeDriver, specificCityNode, 10);
                ((JavascriptExecutor) activeDriver).executeScript("arguments[0].click();", autoSuggestOption);
                System.out.println("Confirmed city suggestion.");
            } else {
                System.out.println("Error: Destination field is hidden or missing.");
                org.testng.Assert.fail("No interactable destination input located.");
            }
        } catch (Exception ex) {
            System.out.println("Search input failed: " + ex.getMessage());
            org.testng.Assert.fail("Exception during city input: " + ex.getMessage());
        }
    }

    public void selectDates() {
        System.out.println("Executing DOM injection for booking dates...");
        try {
            WebElement dateIn = WaitUtils.waitForPresence(activeDriver, inputArrival, 5);
            WebElement dateOut = WaitUtils.waitForPresence(activeDriver, inputDeparture, 5);
            
            JavascriptExecutor jsEngine = (JavascriptExecutor) activeDriver;
            String arrivalStr = "15-06-2026"; 
            String departureStr = "20-06-2026";
            
            jsEngine.executeScript("arguments[0].value=arguments[1];", dateIn, arrivalStr);
            jsEngine.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true })); arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", dateIn);
            
            jsEngine.executeScript("arguments[0].value=arguments[1];", dateOut, departureStr);
            jsEngine.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true })); arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", dateOut);
            
            System.out.println(String.format("Timestamps registered: %s -> %s", arrivalStr, departureStr));
            
        } catch(Exception ex) {
             System.out.println("Date injection malfunction: " + ex.getMessage());
        }
    }

    public void selectTravellers() {
        try {
            WebElement paxDropdown = WaitUtils.waitForPresence(activeDriver, dropTravellers, 5);
            ((JavascriptExecutor) activeDriver).executeScript("arguments[0].click();", paxDropdown);
            System.out.println("Pax dropdown engaged.");
        } catch (Exception ex) {
            System.out.println("Pax interaction failed: " + ex.getMessage());
        }
    }

    public void selectNationality(String country) {
        try {
            JavascriptExecutor jsEngine = (JavascriptExecutor) activeDriver;
            WebElement countryNode = WaitUtils.waitForPresence(activeDriver, By.name("nationality"), 5);
            String isoCode = country.substring(0, 2).toUpperCase(); 

            jsEngine.executeScript("arguments[0].value=arguments[1];", countryNode, isoCode);
            jsEngine.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", countryNode);
            jsEngine.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", countryNode);
            
            System.out.println("Nationality mapped to: " + isoCode);
        } catch (Exception ex) {
            System.out.println("Nationality mapping failed: " + ex.getMessage());
        }
    }

    public void clickSearch() {
        WebElement submitNode = WaitUtils.waitForClickable(activeDriver, btnTriggerSearch, 5);
        ((JavascriptExecutor) activeDriver).executeScript("arguments[0].click();", submitNode);
    }
}