package com.automation.utils;

import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;


public class CucumberReportManager {
    public static Scenario scenario;

    public static void initReport(Scenario scenario) {
        CucumberReportManager.scenario = scenario;
    }

    public static void attachScreenShot() {
        scenario.attach(takeScreenShot(), "image/png", "FailedTestSnap");
    }

    public static byte[] takeScreenShot() {
        Page page = DriverManager.getPage();
        return page.screenshot() ;
    }
}
