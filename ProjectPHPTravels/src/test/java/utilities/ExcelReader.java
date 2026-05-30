package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

    public List<Map<String, String>> getData(String pathToFile, String targetSheet) {
        List<Map<String, String>> extractedRecords = new ArrayList<>();
        
        try (FileInputStream fileStream = new FileInputStream(new File(pathToFile));
             Workbook excelDoc = WorkbookFactory.create(fileStream)) {
            
            Sheet sheetObj = excelDoc.getSheet(targetSheet);
            Row titleRow = sheetObj.getRow(0);
            
            int totalRows = sheetObj.getLastRowNum();
            int totalCols = titleRow.getLastCellNum();
            
            for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
                Row activeRow = sheetObj.getRow(rowIndex);
                Map<String, String> rowDataMap = new LinkedHashMap<>();
                
                for (int colIndex = 0; colIndex < totalCols; colIndex++) {
                    String columnHeader = titleRow.getCell(colIndex).getStringCellValue();
                    Cell currentCell = activeRow.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    
                    String cellContent = "";
                    
                    switch (currentCell.getCellType()) {
                        case STRING:
                            cellContent = currentCell.getStringCellValue();
                            break;
                        case NUMERIC:
                            cellContent = String.valueOf((int) currentCell.getNumericCellValue());
                            break;
                        default:
                            cellContent = "";
                            break;
                    }
                    
                    rowDataMap.put(columnHeader, cellContent);
                }
                extractedRecords.add(rowDataMap);
            }
        } catch (Exception ex) {
            System.err.println("Failed to parse Excel document: " + ex.getMessage());
        }
        
        return extractedRecords;
    }
}