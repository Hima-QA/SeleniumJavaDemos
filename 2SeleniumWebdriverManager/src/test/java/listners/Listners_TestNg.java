package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners_TestNg implements ITestListener {

	
	public void onStart(ITestContext arg0) {
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Test Started: "+arg0.getName());
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("Test Failed: "+arg0.getName());
		
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Skipped: "+arg0.getName());
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("Test Started: "+arg0.getName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Test Success: "+arg0.getName());
		
	}
	public void onFinish(ITestContext arg0) {
		System.out.println("Test Finish: "+arg0.getName());
	}


}
