package com.amber.listeners;

import com.amber.factories.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Vinaykumar Gupta
 * @Date 26/03/23
 */
public class TestListeners extends BaseTest implements ITestListener{
        private Logger log = Logger.getLogger(TestListeners.class);

        private static String getTestMethodName(ITestResult iTestResult) {
            return iTestResult.getMethod().getConstructorOrMethod().getName();
        }

        @Override
        public void onStart(ITestContext iTestContext) {
            log.info("Test Suite Execution Started :" + iTestContext.getName());
            if (driver.get() != null) {
                iTestContext.setAttribute("WebDriver", driver.get());
            } else {
                iTestContext.setAttribute("WebDriver", driver.get());
            }
        }

        @Override
        public void onFinish(ITestContext iTestContext) {
            log.info("Test Suite Execution completed :" + iTestContext.getName());

        }

        @Override
        public void onTestStart(ITestResult iTestResult) {
            log.info("TestExecution started :" + getTestMethodName(iTestResult));
        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {
            log.info("Test executed Successfully!!! :" + getTestMethodName(iTestResult));
            String methodName = "MethodName :" + getTestMethodName(iTestResult);

        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {
            String methodName = "MethodName: " + getTestMethodName(iTestResult);
            String failureReason = "Reason: " + iTestResult.getThrowable();
            String parameters = "Parameters: " + Arrays.toString(iTestResult.getParameters());
            File screenShot= ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
            try {
                Path path = Paths.get("screenshot",methodName+".png");
                FileUtils.copyFile(screenShot, new File(path.toString()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {
            log.warn("Testcase Skipped :" + getTestMethodName(iTestResult));
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
            log.error("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
        }

        public byte[] saveScreenshotPNG() {
            if ((driver.get() != null)) {
                return ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
            }
            return new byte[0];
        }
    }
