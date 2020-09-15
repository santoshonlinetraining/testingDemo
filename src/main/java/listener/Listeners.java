package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import testcases.LogTest;

public class Listeners extends TestBase implements ITestListener {
	public Logger log = LogManager.getLogger(LogTest.class.getName());
	//@Test
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Testcase started Running");
	}

	//@Test
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("i am from onTestSuccess");
	}
	
	//@Test
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("i am from onTestFailure");
	}
	
	//
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("i am from onTestSkipped");
	}
	
	//
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("i am from onTestFailedButWithinSuccessPercentage");
	}

	//<test>
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("i am from onStart");
	}
	
	//<test>
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("i am from onFinish");
	}

	

}
