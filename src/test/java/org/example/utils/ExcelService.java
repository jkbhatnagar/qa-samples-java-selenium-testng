package org.example.utils;//package test.util;
//
//import java.io.FileInputStream;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// * These methods are used to set Excel path and perform read-write operations on
// * the Excel file
// *
// * @author M1046633
// *
// */
//
//public class ExcelService {
//
//    private static XSSFSheet sheet;
//    private static XSSFWorkbook workbook;
//    private static XSSFCell cell;
//
//    // This method returns the path of the keywords Excel file
//    public static String getKeywordsPath() {
//
//        String excelPath = ".\\data-tables\\amazon-products.xlsx";
//        return excelPath;
//
//    }
//
//    // This method returns the path of the responsive dimensions Excel file
//    public static String getResponsivePath() {
//
//        String excelPath = ".\\data-tables\\responsive-web-dimensions.xlsx";
//        return excelPath;
//
//    }
//
//    // This method sets the Excel path and opens it
//    public static void setExcelFile(String path, String sheetName) throws Exception {
//
//        FileInputStream input = new FileInputStream(path);
//        workbook = new XSSFWorkbook(input);
//        sheet = workbook.getSheet(sheetName);
//
//    }
//
//    // This method reads data from each Excel cell
//    public static String getCellData(int row, int column) throws Exception {
//
//        cell = sheet.getRow(row).getCell(column);
//        String data = cell.getStringCellValue();
//        return data;
//
//    }
//
//}