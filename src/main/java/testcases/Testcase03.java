package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import base.TestBase3;
import reports.ExtentTestManager;

public class Testcase03 extends TestBase {
//	public ExtentReports extent;
//	public ExtentTest logger;
	
	@Parameters({"username","password"})
	@Test(enabled=true, groups= {"regression", "login"})
	public void Valiate_Login(String uname, String pword) {
		//to get current method name
		String TestcaseId = new Object() {}.getClass().getEnclosingMethod().getName();
		logger = extent.startTest(TestcaseId, "verify the login");

		homepageObj.getSignInLink().click();
		logger.log(LogStatus.INFO, "User is trying to login");
		signInObj.setEmail(uname);
		signInObj.setpassword(pword);
		signInObj.getSignInButton().click();
		logger.log(LogStatus.PASS, "User Login Done");
	}
	
	@Parameters({"username","password"})
	@Test(enabled=true, groups= {"regression", "login"})
	public void Validate_LoginAnLogout(String uname, String pword) {
		//to get current method/testcase name
		String TestcaseId = new Object() {}.getClass().getEnclosingMethod().getName();
		logger = extent.startTest(TestcaseId, "Verify the login and logout");

		homepageObj.getSignInLink().click();
		
		logger.log(LogStatus.INFO, "User is trying to login");
		signInObj.setEmail(uname);
		signInObj.setpassword(pword);
		signInObj.getSignInButton().click();
		logger.log(LogStatus.INFO, "User Login Done");
		
		loginHomePageObj.getLogoutLink().click();
		logger.log(LogStatus.PASS, "User Logged out");
	}
	
	@Test
	void testing() {
		
	}

}
