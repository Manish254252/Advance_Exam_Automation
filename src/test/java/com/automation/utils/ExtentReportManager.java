package com.automation.utils;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ExtentReportManager {
    static ExtentReports extentReports;
    static ExtentTest extentTest;
    static ExtentSparkReporter sparkReporter;

    public static void initExtentReport() {
        sparkReporter = new ExtentSparkReporter("ExtentReport/extentReport.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Extent Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    public static void flush() {
        extentReports.flush();
    }

    public static void createTest(String name) {
        extentTest = extentReports.createTest(name);
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    public static void attachScreenShot() {
        extentTest.addScreenCaptureFromPath(takeScreenShot());
    }

    public static String takeScreenShot() {
        TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        Random num = new Random();
        int n = num.nextInt(100);
        String path = "src/test/resources/screenshots/screenshot" + n + ".png";
        try {
            FileUtils.copyFile(file, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return System.getProperty("user.dir") + "/" + path;
    }
}
