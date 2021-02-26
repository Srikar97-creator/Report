package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import BaseTest.BaseTest;
import ExtentManager.ExtentManager;

public class Listeners extends ExtentManager implements ITestListener {
	BaseTest basetest = new BaseTest();
	WebDriver driver;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Failed Test case is: " + result.getName());
			test = extent.createTest(result.getName());
			String pathString = basetest.screenShot(BaseTest.driver, result.getName());
			try {
				test.addScreenCaptureFromPath(pathString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

}
