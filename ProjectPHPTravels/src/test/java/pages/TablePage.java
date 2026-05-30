package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

import java.util.*;

public class TablePage {

    private WebDriver webDriver;

    private By locColHeaders = By.xpath("//table//thead//th");
    private By locDataRows = By.xpath("//table//tbody//tr");

    public TablePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public List<Map<String, String>> getTableData() {
        List<Map<String, String>> extractedGrid = new ArrayList<>();
        
        List<WebElement> thNodes = WaitUtils.waitForAllVisible(webDriver, locColHeaders, 10);
        List<String> keyList = new ArrayList<>();
        
        for (WebElement th : thNodes) {
            keyList.add(th.getText().trim());
        }

        List<WebElement> trNodes = webDriver.findElements(locDataRows);

        for (WebElement tr : trNodes) {
            List<WebElement> tdNodes = tr.findElements(By.tagName("td"));
            Map<String, String> rowMapping = new LinkedHashMap<>(); 

            for (int colIdx = 0; colIdx < tdNodes.size(); colIdx++) {
                if (colIdx < keyList.size()) { 
                    rowMapping.put(keyList.get(colIdx), tdNodes.get(colIdx).getText().trim());
                }
            }
            if(!rowMapping.isEmpty()) {
                extractedGrid.add(rowMapping);
            }
        }
        return extractedGrid;
    }

    public void findDuplicateBookings(List<Map<String, String>> gridData) {
        Set<String> processedInvoices = new HashSet<>();
        boolean hasDuplicates = false;

        System.out.println("Scanning grid for repeating invoice numbers...");
        for (Map<String, String> record : gridData) {
            String inv = record.get("INVOICE"); 
            
            if (inv != null && !processedInvoices.add(inv)) {
                System.out.println("Conflict Detected! Repeating Invoice: " + inv);
                hasDuplicates = true;
            }
        }
        
        if (!hasDuplicates) {
            System.out.println("Scan Complete: Data is clean, no duplicates.");
        }
    }

    public void printHighestAndLowestPrice(List<Map<String, String>> gridData) {
        double highestVal = Double.MIN_VALUE;
        double lowestVal = Double.MAX_VALUE;
        String topBookingInfo = "N/A";
        String bottomBookingInfo = "N/A";

        for (Map<String, String> record : gridData) {
            String rawAmount = record.get("PRICE"); 
            String invNum = record.get("INVOICE");
            
            if (rawAmount != null && !rawAmount.isEmpty()) {
                try {
                    double parsedAmount = Double.parseDouble(rawAmount.replaceAll("[^0-9.]", ""));

                    if (parsedAmount > highestVal) {
                        highestVal = parsedAmount;
                        topBookingInfo = String.format("%s (%s)", invNum, rawAmount);
                    }
                    if (parsedAmount < lowestVal) {
                        lowestVal = parsedAmount;
                        bottomBookingInfo = String.format("%s (%s)", invNum, rawAmount);
                    }
                } catch (NumberFormatException ignored) {}
            }
        }

        System.out.println("Maximum Expenditure: " + topBookingInfo);
        System.out.println("Minimum Expenditure: " + bottomBookingInfo);
    }
}