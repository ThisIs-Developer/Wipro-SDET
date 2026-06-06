package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getCellData(String filePath, String sheetName, int rowNum, int cellNum) {

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) 
        {
            XSSFSheet sheet = workbook.getSheet(sheetName);

            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));

        } catch (Exception e) {
            throw new RuntimeException("Unable to read Excel data",e);
        }
    }

    public static int getRowCount(String filePath,String sheetName) {

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) 
        {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get row count",e);
        }
    }

    public static int getCellCount(String filePath, String sheetName, int rowNum) {

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) 
        {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            return sheet.getRow(rowNum).getLastCellNum();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get cell count",e);
        }
    }
}