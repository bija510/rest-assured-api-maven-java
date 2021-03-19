package utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelUtilsXls {

    static HSSFWorkbook workbook;
    static HSSFSheet sheet;

    public ExcelUtilsXls(String excelPath, String sheetName) {
        try {
            InputStream file= new FileInputStream(excelPath);
            workbook = new HSSFWorkbook(new POIFSFileSystem(file));
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
