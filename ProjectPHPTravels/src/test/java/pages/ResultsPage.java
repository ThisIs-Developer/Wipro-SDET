package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;
import java.util.*;

public class ResultsPage {

    private WebDriver browserDriver;

    private By locTitles = By.xpath("//h3[contains(@class, 'font-bold') and contains(@class, 'line-clamp-1')]");
    private By locCosts = By.xpath("//p[contains(@class, 'text-2xl') and contains(@class, 'font-bold')]");

    public ResultsPage(WebDriver driver) {
        this.browserDriver = driver;
    }

    public void fetchAndValidateHotelData() {
        try {
            System.out.println("Polling for hotel data to render...");
            
            WaitUtils.waitForVisible(browserDriver, locTitles, 15); 
            Thread.sleep(2000); 

            List<WebElement> titleElements = browserDriver.findElements(locTitles);
            List<WebElement> costElements = browserDriver.findElements(locCosts);

            if (titleElements.isEmpty() || costElements.isEmpty()) {
                System.out.println("Warning: Zero hotels extracted. Verify DOM locators.");
                return;
            }

            Map<String, Integer> extractedDataMap = new HashMap<>();
            Set<String> processedNames = new HashSet<>();
            List<String> repeatedEntries = new ArrayList<>();

            int maxCost = Integer.MIN_VALUE;
            int minCost = Integer.MAX_VALUE;
            double cumulativeCost = 0;
            
            int totalItems = Math.min(titleElements.size(), costElements.size()); 
            
            for (int idx = 0; idx < totalItems; idx++) {
                String rawName = titleElements.get(idx).getText().trim();
                String rawPrice = costElements.get(idx).getText().trim(); 

                String preDecimal = rawPrice.contains(".") ? rawPrice.substring(0, rawPrice.indexOf('.')) : rawPrice;
                String digitsOnly = preDecimal.replaceAll("\\D+", ""); 
                
                int parsedCost = digitsOnly.isEmpty() ? 0 : Integer.parseInt(digitsOnly);

                extractedDataMap.put(rawName, parsedCost);

                if (parsedCost > maxCost) maxCost = parsedCost;
                if (parsedCost < minCost) minCost = parsedCost;
                cumulativeCost += parsedCost;

                if (!processedNames.add(rawName)) {
                    repeatedEntries.add(rawName);
                }
            }

            double meanCost = cumulativeCost / totalItems;

            System.out.println("\n--- DATA VALIDATION SUMMARY ---");
            System.out.println("Entities Processed: " + totalItems);
            System.out.println("Peak Price: " + maxCost);
            System.out.println("Floor Price: " + minCost);
            System.out.println("Mean Price: " + meanCost);
            
            if (repeatedEntries.size() == 0) {
                System.out.println("Integrity Check: No duplicated names found.");
            } else {
                System.out.println("Integrity Alert! Duplicates detected: " + repeatedEntries);
            }
            System.out.println("-------------------------------\n");

        } catch (Exception ex) {
            System.out.println("Data extraction malfunctioned: " + ex.getMessage());
        }
    }
}