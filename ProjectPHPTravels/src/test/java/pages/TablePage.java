package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

import java.util.*;

public class TablePage {

    private WebDriver driver;

    // Locators
    private By tableHeaders = By.xpath("//table//thead//th");
    private By tableRows = By.xpath("//table//tbody//tr");

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    //1
    public List<Map<String, String>> getTableData() {
        List<Map<String, String>> tableData = new ArrayList<>();
        
        List<WebElement> headerElements = WaitUtils.waitForAllVisible(driver, tableHeaders, 10);
        List<String> headers = new ArrayList<>();
        for (WebElement header : headerElements) {
            headers.add(header.getText().trim());
        }
        
        List<WebElement> rowElements = driver.findElements(tableRows);

        for (WebElement row : rowElements) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            Map<String, String> rowData = new LinkedHashMap<>();

            for (int i = 0; i < columns.size(); i++) {
                if (i < headers.size()) { 
                    rowData.put(headers.get(i), columns.get(i).getText().trim());
                }
            }
            if(!rowData.isEmpty()) {
                tableData.add(rowData);
            }
        }
        return tableData;
    }

    // 2
    public void findDuplicateBookings(List<Map<String, String>> tableData) {
        Set<String> uniqueIds = new HashSet<>();
        boolean duplicateFound = false;

        System.out.println("Checking for duplicate invoices...");
        for (Map<String, String> row : tableData) {
            String invoiceId = row.get("INVOICE"); 
            
            if (invoiceId != null && !uniqueIds.add(invoiceId)) {
                System.out.println("Duplicate Invoice Found! ID: " + invoiceId);
                duplicateFound = true;
            }
        }
        
        if (!duplicateFound) {
            System.out.println("✅ No duplicate invoices found in the table.");
        }
    }

    // 3
    public void printHighestAndLowestPrice(List<Map<String, String>> tableData) {
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;
        String maxBookingInfo = "";
        String minBookingInfo = "";

        for (Map<String, String> row : tableData) {
            String priceString = row.get("PRICE"); 
            String invoiceId = row.get("INVOICE");
            
            if (priceString != null && !priceString.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceString.replaceAll("[^0-9.]", ""));

                    if (price > maxPrice) {
                        maxPrice = price;
                        maxBookingInfo = invoiceId + " (" + priceString + ")";
                    }
                    if (price < minPrice) {
                        minPrice = price;
                        minBookingInfo = invoiceId + " (" + priceString + ")";
                    }
                } catch (NumberFormatException e) {
                }
            }
        }

        System.out.println("Highest Booking Amount: " + maxBookingInfo);
        System.out.println("Lowest Booking Amount: " + minBookingInfo);
    }
}