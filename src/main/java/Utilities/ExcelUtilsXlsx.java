package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtilsXlsx {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtilsXlsx(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                e.printStackTrace();
            }
    }

    public static void getCellData(int rowNum, int colNum) {
            // in Excel file both row col start from 0
            DataFormatter formatter = new DataFormatter();
            Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
            System.out.println(value);
    }

    public static void getRowCount() {
            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("total row count:-" + rowCount);

    }
}
