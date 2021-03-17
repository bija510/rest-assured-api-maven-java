package dataDriven;

import Utilities.ExcelUtilsXls;
import Utilities.ExcelUtilsXlsx;
import org.hamcrest.Description;
import org.testng.annotations.Test;

public class Test_06_ExcelDataDriven {

    @Test(description = "This is for new Excel File")
    public void test_Xlsx_dataDrivenExcel() {
    String excelPath = "./Data/excelData.xlsx";
    String sheetName = "Sheet1";

    ExcelUtilsXlsx excel = new ExcelUtilsXlsx(excelPath, sheetName);
        excel.getRowCount();
        excel.getCellData(1,0);
    }

    @Test(description = "This is for Old excel file from 1997- 2003")
    public void test_Xls_dataDrivenExcel() {
        String excelPath = "./Data/excelData.xls";
        String sheetName = "Sheet1";

        ExcelUtilsXls excel = new ExcelUtilsXls(excelPath, sheetName);
        excel.getRowCount();
        excel.getCellData(1,0);
    }
}
