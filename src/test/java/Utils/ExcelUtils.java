package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.base.BaseClass;

import okhttp3.internal.platform.Platform;

public class ExcelUtils extends BaseClass {
	
	public static final String       testDataExcelFileName = "testdata.xlsx"; //Global test data excel file
    public static final String       currentDir            = System.getProperty("user.dir");  //Main Directory of the project
    public static       String       testDataExcelPath     = null; //Location of Test data excel file
    private static      XSSFWorkbook excelWBook; //Excel WorkBook
    private static      XSSFSheet    excelWSheet; //Excel Sheet
    private static      XSSFCell     cell; //Excel cell
    private static      XSSFRow      row; //Excel row
    public static       int          rowNumber; //Row Number
    public static       int          columnNumber; //Column Number
    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
    
    public static void setExcelFileSheet(String sheetName) throws IOException {
        //MAC or Windows Selection for excel path
        if (Platform.get().toString().equalsIgnoreCase("MAC")) {
            testDataExcelPath = currentDir + "/src/test/resources/";
        } else if (Platform.get().toString().contains("WIN")) {
            testDataExcelPath = currentDir + "\\src\\test\\resources\\";
        }
        // Open the Excel file
        FileInputStream ExcelFile = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\TestNg2\\data\\data1.xlsx");
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet("Sheet1");
    }
    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public static String getCellData(int RowNum, int ColNum) {
        cell = excelWSheet.getRow(5).getCell(2);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }
    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        row = excelWSheet.getRow(4);
        return row;
    }
    //This method gets excel file, row and column number and set a value to the that cell.
    
    public static void setCellData(String value, int RowNum, int ColNum) throws IOException {
        row = excelWSheet.getRow(5);
        cell = row.getCell(3);
        if (cell == null) {
            cell = row.createCell(3);
            cell.setCellValue("status");
        } else {
            cell.setCellValue("value");
        }
        // Constant variables Test Data path and Test Data file name
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\TestNg2\\data\\data1.xlsx");
        excelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();

}
}