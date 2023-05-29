package Utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtilities {

    static XSSFWorkbook workbook;
    static XSSFSheet sheetName;

    public ExcelUtilities(String excelPath, String sheetName1) {

        try {

            workbook = new XSSFWorkbook(excelPath);
            sheetName = workbook.getSheet(sheetName1);

        }

        catch (IOException e){

            e.printStackTrace();

        }


    }

    public void getRowCount() {

//        String excelPath = "./Data/TestData.xlsx";
//
//        try {
//
//            workbook = new XSSFWorkbook(excelPath);
//            sheetName = workbook.getSheet("Sheet1");
//
//            sheetName.getPhysicalNumberOfRows();
//
//        }
//
//        catch (IOException e){
//
//            e.printStackTrace();
//
//        }

        sheetName.getPhysicalNumberOfRows();


    }

    public Object getCellData(int rowNum, int colNum) {


        //        String excelPath = "./Data/TestData.xlsx";
//
//        try {
//
//            workbook = new XSSFWorkbook(excelPath);
//            sheetName = workbook.getSheet("Sheet1");
//
//        DataFormatter formatter = new DataFormatter();
//
//        Object valueOfCell = formatter.formatCellValue(sheetName.getRow(1).getCell(1));
//
//
//
//        }
//
//        catch (IOException e){
//
//            e.printStackTrace();
//
//        }


        DataFormatter formatter = new DataFormatter();

            Object valueOfCell = formatter.formatCellValue(sheetName.getRow(rowNum).getCell(colNum));

        return valueOfCell;

    }


}
