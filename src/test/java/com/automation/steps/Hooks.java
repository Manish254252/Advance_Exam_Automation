package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        ConfigReader.initConfig();
        DriverManager.createDriver();
    }

    @AfterStep
    public void delay() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void cleanUp() {
        DriverManager.getDriver().quit();
    }

}
