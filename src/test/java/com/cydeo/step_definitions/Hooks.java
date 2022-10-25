package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//In this class will be able to pass pre& post conditions to each scenario and each step
public class Hooks {

   @Before (order = 1)// import from io.cucumber.java
    public void setupScenario() {

       System.out.println("====Setting up browser using cucumber @Before");

   }
       @Before (value = "@login",order = 2)
       public void setupScenarioForLogin(){
           System.out.println("====Setting up browser using cucumber with @login tag");



    }

       @Before(value = "@db",order = 0)
       public void setupFroDatabaseScenario(){
           System.out.println("====this will only apply to scenario with @db tag");
       }

    @After
    public void tearDownScenario(Scenario scenario){

       //scenario.isFailed().--> scenario fails this method will return true booelan value
       if(scenario.isFailed()) {

           byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot, "image/png", scenario.getName());

       }



        Driver.closeDriver();





        /*System.out.println("====Closing browser using cucumber @After");
        System.out.println("====Scenario ended/ take screenshot if failed!");*/
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("-------applying setup using @BeforeStep");

    }


    @AfterStep
    public void afterStep(){
        System.out.println("--------------> applying tearDown using @AfterStep");
    }





}
