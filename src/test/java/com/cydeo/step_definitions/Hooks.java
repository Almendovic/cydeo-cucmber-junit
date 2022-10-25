package com.cydeo.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

//In this class will be able to pass pre& post conditions to each scenario and each step
public class Hooks {

   @Before // import from io.cucumber.java
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
    public void tearDownScenario(){
        System.out.println("====Closing browser using cucumber @After");
        System.out.println("====Scenario ended/ take screenshot if failed!");
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
