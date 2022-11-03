package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

 @Test
 public void read_from_excel_file() throws IOException {

     String path="SampleData.xlsx";

     // to rread from excel we need to load in to FileInput Stream

     FileInputStream fileInputStream=new FileInputStream(path);

     // workbook>sheet>row>cell

     //<1> CRete a work

     XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

     // <2>
     XSSFSheet sheet= workbook.getSheet("Employees");

     //<3> Select row and cell
     // Print out many cells
     //INdexex start from 0

     System.out.println(sheet.getRow(1).getCell(0));


     // print out Developer

     System.out.println(sheet.getRow(3).getCell(2));

     //Return the count of used cells only
     //Starts counting from 1
      int usedRows=sheet.getPhysicalNumberOfRows();

     System.out.println(usedRows);

     //Return the number from top cell to bottom cell
     //It doent care if the cell is empty or not

     //Starts counting from 0

     int lastusedRow=sheet.getLastRowNum();

     System.out.println(lastusedRow);



 }

}
