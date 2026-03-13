package com.automation.v1.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.automation.v1.BaseClass.BaseClass;

public class ReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "\\reports\\ExtentReport.html");

        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Selenium Automation Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Tester", "Nishant");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(Status.PASS, "Test Case Passed : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(Status.FAIL, "Test Case Failed : " + result.getName());
        test.get().log(Status.FAIL, result.getThrowable());

        WebDriver driver = BaseClass.getDriver();

        if (driver != null) {

            String screenshotPath = System.getProperty("user.dir")
                    + "\\FailedScreenShot\\"
                    + result.getName() + ".png";

            try {

                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File(screenshotPath);

                FileUtils.copyFile(src, dest);

                test.get().fail("Screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().log(Status.SKIP, "Test Case Skipped : " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}