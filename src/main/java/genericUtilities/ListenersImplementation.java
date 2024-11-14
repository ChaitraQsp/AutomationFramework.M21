package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ITestListener Interface of TestNG
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener
{
	
	//Capture current system date to use in screenshot name and Report name
	Date d = new Date();
	SimpleDateFormat sd = new SimpleDateFormat(" dd-MM-yyyy hh-mm-ss");
	String date = sd.format(d);
	
	/*For Extent Report*/
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		/*@Test - Test Method has started execution*/
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> Test Script Execution started");
		
		/*Intimate @Test execution for extent Reports*/
		test = report.createTest(methodName);
		test.log(Status.INFO,methodName+" -> Test Script Execution started" );
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		/*@Test - Test Method has passed*/
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> Test script is PASS");
		
		/*Log PASS status in Extent Report*/
		test.log(Status.PASS, methodName+" -> Test script is PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		/*@Test - Test Method has Failed*/
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> Test script FAIL");
		
		/*Capture the exception*/
		System.out.println(result.getThrowable());

		/*Log the status in extent Reports*/
		test.log(Status.FAIL, methodName+" -> Test script FAIL");
		
		/*Log the exception in extent reports*/
		test.log(Status.WARNING, result.getThrowable());
		
		/*Capture the screenshot*/
		SeleniumUtility s = new SeleniumUtility();
		
		String screenshotName = methodName+date; //AddProductToCratTest 30-10-2024 08-20-45.png
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver,screenshotName);
			
			/*Attach the captured screenshot to extent Reports*/
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		/*@Test - Test Method has skipped*/
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> Test Script SKIP");
		
		/*Capture the exception*/
		System.out.println(result.getThrowable());
		
		/*Log Skip status to Extent Reports*/
		test.log(Status.SKIP, methodName+" -> Test Script SKIP");
		
		/*Log the exception to extent reports*/
		test.log(Status.WARNING, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("Suite execution started");
		
		/*Extent report Configuration*/
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report-"+date+".html");
		esr.config().setTheme(Theme.DARK);
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setReportName("Swag Labs Report - Build version 1.21");
		
		/*Attach the configuration to extent Reports*/
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Environment", "Test Environmtent");
		report.setSystemInfo("Base Browser", "Microsoft edge");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("Reporter Name", "Chaitra");
	
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("Suite Execution Finished");
		
		/*Generate Extent Report after suite execution is complete*/
		report.flush();
		
	}
   
}
