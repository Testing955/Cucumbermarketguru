package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public static HashMap<String, String> storeValues = new HashMap<>();

    public static List<HashMap<String, String>> data(String filepath, String sheetName) throws IOException {
        List<HashMap<String, String>> mydata = new ArrayList<>();
        
        try (FileInputStream fs = new FileInputStream(filepath)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row headerRow = sheet.getRow(0);
            
            if (headerRow == null) {
                throw new IOException("Header row is missing in the sheet");
            }
            
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    continue;
                }
                
                HashMap<String, String> currentHash = new HashMap<>();
                for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {
                    Cell currentCell = currentRow.getCell(j);
                    String headerValue = headerRow.getCell(j).getStringCellValue();
                    String cellValue = getCellValueAsString(currentCell);
                    
                    currentHash.put(headerValue, cellValue);
                    storeValues.put(headerValue, cellValue);
                }
                mydata.add(currentHash);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file was not found: " + filepath);
            throw e;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + filepath);
            throw e;
        }
        return mydata;
    }
    
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
