package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    /*
    in the class we will be able to pass pre- and post- conditions to each scenario and each step
     */

    // import from io.cucumber
    @Before (order = 1)
    public void setupScenario(){
        System.out.println("===Setting up browser using cucumber @Before===");
    }

    @Before (value = "@login", order = 2)
    public void setupScenarioForLogin(){
        System.out.println("===Setting up browser with @login ===");
    }

    @Before (value = "@db", order = 0)
    public void setupForDatabaseScenario(){
        System.out.println("===Setting up browser with @db ===");
    }

    @After
    public void tearDownScenario(Scenario scenario){

        // if scenario fails this method will return true boolean value


        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }




        Driver.closeDriver();
//        System.out.println("===Closing browser using cucumber @After===");
//        System.out.println("===Scenario ended/ Take screenshot if failed!===");
    }

  //  @BeforeStep
    public void setupStep(){
        System.out.println("====Applying setup using @BeforeStep");
    }

  //  @AfterStep
    public void afterStep(){
        System.out.println("=====Applying tear down using @AfterStep");
    }
}
