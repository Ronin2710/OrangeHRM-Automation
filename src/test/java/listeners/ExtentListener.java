package listeners;

import com.aventstack.extentreports.*;
import org.testng.*;
import Utilities.ExtentManager;

public class ExtentListener implements ITestListener {

    ExtentReports extent = ExtentManager.getExtentReport();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}