package com.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {


    /*  Syntax : Workbook reference = new Xssfworkbook();  */

    public static String getParticularData(int rowValue, int columnValue) {

        String data = null;

        try {
            File file = new File("C:\\Users\\NithiMani\\Desktop\\Greens Technology\\IPT\\DataDriven\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);

            //String stringCellValue = book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();

            Sheet sheet = book.getSheet("Sheet1");
            Row row = sheet.getRow(rowValue);
            Cell cell = row.getCell(columnValue);
            // System.out.println(data);
            // DataFormatter is used to get the data in string format
            // even if the data is in numeric or date format
            DataFormatter dataFormat = new DataFormatter();
            data = dataFormat.formatCellValue(cell);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

//    public static void main(String[] args) {
//        getParticularData(1,0);
//    }


    public static void getAllData() {
        try {
            File file = new File("C:\\Users\\NithiMani\\Desktop\\Greens Technology\\IPT\\DataDriven\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");

            int lastRowNum = sheet.getLastRowNum();
            System.out.println("No of rows: " + lastRowNum);

            short lastCellNum = sheet.getRow(0).getLastCellNum();
            System.out.println("No of rows: " + lastCellNum);

            for (int i = 0; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < lastCellNum; j++) {
                    Cell cell = row.getCell(j);
                    DataFormatter dataFormat = new DataFormatter();
                    String data = dataFormat.formatCellValue(cell);
                    System.out.print(data + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        getAllData();
    }

    public static String getYoutubeData(int rowValue, int columnValue) {

        String data = null;

        try {
            File file = new File("C:\\Users\\NithiMani\\Desktop\\DataDriven1.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");
            Row row = sheet.getRow(rowValue);
            Cell cell = row.getCell(columnValue);
            DataFormatter dataFormat = new DataFormatter();
            data = dataFormat.formatCellValue(cell);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
