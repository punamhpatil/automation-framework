package generic_Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listnerImplementation implements ITestListener
{
	 ExtentReports report;
	 ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "Test Execution Start");
		//create @test in extent report
		 test = report.createTest(methodName);
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-----Test Pass----");
		//log status as pass in extent report
		test.log(Status.PASS, methodName+ "-----Test Pass----");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-------Test Fail-------");
		
		//log status as FAIL in extent report
		test.log(Status.FAIL, methodName+ "-----Test Fail----");
		
		seleniumUtility s = new seleniumUtility();
		javaUtility j = new javaUtility();
		
		
		String screenShotname = methodName+"-"+j.getDate();
		try
		{
			String path = s.captureScreenShot(baseClass.Sdriver, screenShotname);
			
			//attach screenshot to extent report
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}


	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ "-------Test Skipped-------");
		
		//log status as Skip in extent report
		test.log(Status.SKIP, methodName+ "-----Test Skipped----");
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Start");
		
		//configuration of extent report
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReport\\Report-"+new javaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("vtigre Execution report");
		rep.config().setTheme(Theme.DARK);
		
	    report = new ExtentReports();
	        report.attachReporter(rep);
	        report.setSystemInfo("Base Browser", "Chrome");
	        report.setSystemInfo("Base Platform", "Window");
	        report.setSystemInfo("Base URL", "http://localhot:8888");
	        report.setSystemInfo("Reporter name", "Punam");
	        
		
	
	}

	
	public void onFinish(ITestContext context) {
		
		System.out.println("Suite Execution Finish");
		//generate the extent report
		report.flush();
		
	}
   
}
