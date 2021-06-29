package com.epam.ta.util;

import com.epam.ta.driver.Driver;
import com.epam.ta.reporting.MyLogger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        MyLogger.info(iTestResult.getMethod().getMethodName() + " is started.");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        MyLogger.info(iTestResult.getMethod().getMethodName() + " is finished with success.");
    }

    public void onTestFailure(ITestResult iTestResult) {
        MyLogger.error(iTestResult.getMethod().getMethodName() + " is failed. Investigate screenshot in screenshots folder.");
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenCapture, new File(".//screenshots/" + getCurrentTimeAsString() + ".png"));
        } catch (IOException e) {
            MyLogger.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "uuuu-MM-dd_HH-mm-ss" );
        return ZonedDateTime.now().format(formatter);
    }
}
