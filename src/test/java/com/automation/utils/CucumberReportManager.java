package com.automation.utils;


import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CucumberReportManager {
    public static Scenario scenario;

    public static void initReport(Scenario scenario) {
        CucumberReportManager.scenario = scenario;
    }

    public static void attachScreenShot() {
        scenario.attach(takeScreenShot(),"image/png","FailedTestSnap");
    }

    public static byte[] takeScreenShot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        return ts.getScreenshotAs(OutputType.BYTES);
    }
}
