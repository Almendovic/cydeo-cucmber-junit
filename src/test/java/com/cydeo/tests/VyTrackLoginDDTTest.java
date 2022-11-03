package com.cydeo.tests;

import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.pages.VytrackDashboardPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {
    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VytrackDashboardPage dashboardPage  = new VytrackDashboardPage();

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }
    @After
    public void tearDown(){
        Driver.closeDriver();

    }

    @Test
    public void loginDDTTest() throws IOException, InterruptedException {

        String filePath="VyTrackQa2Users.xlsx";
        FileInputStream in =new FileInputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook(in);
        XSSFSheet sheet= workbook.getSheet("data");


        for (int i=1;i<=sheet.getLastRowNum();i++){
            String userName=sheet.getRow(i).getCell(0).toString();
            String password=sheet.getRow(i).getCell(1).toString();
            String firstName=sheet.getRow(i).getCell(2).toString();
            String lastName=sheet.getRow(i).getCell(3).toString();

            loginPage.login(userName,password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(dashboardPage.fullName));

            String actualFullname=dashboardPage.fullName.getText();

            XSSFCell resultCell=sheet.getRow(i).getCell(4);

            if(actualFullname.contains(firstName) && actualFullname.contains(lastName)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            }else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }


            dashboardPage.logout();



        }
        FileOutputStream out= new FileOutputStream(filePath);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();

    }


}
