package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void sleep(int second){
        second*=1000;
        try{
            Thread.sleep(second);
        }catch(InterruptedException e){

        }



    }

    //this method accepts 3 arg
    //arg1: webdriver
    //arg2:expected InUrl : for verify if the url contains given String
    //if conditions is true it will break the loop
    //arr3 expectedTitle will be compared to actualTitle
    public static void switchWindownAndVerify( String expectedInUrl, String expectedInTitle) {
        Set<String> allWindowshandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowshandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains("etsy")){
                break;
            }

        }
        //5 Assert:Title contains "ExpectedTitle"
        //lines to be pasted
        //5 Assert:Title contains "Etsy"
        //lines to be pasted
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue("Title verification failed!",actualTitle.contains(expectedInTitle));
    }

    //this method accepts a String "expectedTitle " and assers if it is true
    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    public static void waitForInvisibilityOf (WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.invisibilityOf(element));




    }
    /**This Method will verify if current URL contains expected value
     * @param expectedInUrl
     *
    */
    public static void verifyURLContains(String expectedInUrl){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));




    }

    /**
     * This method will accept a dropdown as a Webelemnt
     * and return all of hte options 'text in a List of String
     * @param  dropdownElement
     * @return List<String> actualOptionsAsString

     */

    public static List<String >dropdownOptionsAsString(WebElement dropdownElement){



        Select select= new Select(dropdownElement);

        List<WebElement>actualOptionsAsWebElement=select.getOptions();

        List<String > actualOptionsAsString=new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {

            actualOptionsAsString.add(each.getText());


        }
        return  actualOptionsAsString;

    }




}

