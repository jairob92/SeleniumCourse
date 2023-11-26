package testListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {
	    System.out.println("Test started....");
	  }
	
	public void onTestSuccess(ITestResult result) {
		 System.out.println("on test success....");
	  }
	
	public void onTestFailure(ITestResult result) {
		 System.out.println("on test failure....");
	  }
	
	public void onTestSkipped(ITestResult result) {
		 System.out.println("on Test skipped....");
	  }
	
	public void onFinish(ITestContext context) {
		 System.out.println("on test finished....");
	  }
	
	
}
