package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import reports.ExtentTestManager;

public class Testcase01 extends TestBase {
//	public ExtentReports extent;
//	public ExtentTest logger;
	
	@Test(enabled=true, groups= {"smoke","regression"})
	public void Validate_HomePage() {
		//to get current method name
		String TestcaseId = new Object() {}.getClass().getEnclosingMethod().getName();
		logger = extent.startTest(TestcaseId, "validating of home page");
		
		logger.log(LogStatus.INFO, "validating the home page text");
		String homepageText = homepageObj.getAutomationPracticeWebSiteText();
		
		Assert.assertEquals(homepageText, "Automation Practice Website");
		logger.log(LogStatus.PASS, "validated the home page text");
	}
	
	@Test(enabled=true, groups= {"regression"})
	public void Validate_contactUsPage() {
		//to get current method name
		String TestcaseId = new Object() {}.getClass().getEnclosingMethod().getName();
		logger = extent.startTest(TestcaseId, "validating the contact us page");
		
		logger.log(LogStatus.INFO, "clicking on the contact us link");
		homepageObj.getContactUsLink().click();
		String result = contactUsObj.getContanctUsText();
		
		Assert.assertEquals(result, "CUSTOMER SERVICE - CONTACT US");
		contactUsObj.setContanctUsSubHeading("Customer service");
		logger.log(LogStatus.PASS, "ContactUs Text found is " + result);
	}
	
	@Test(enabled=true, groups= {"smoke","regression"})
	public void Validate_CreateAccount() {
		//to get current method name
		String TestcaseId = new Object() {}.getClass().getEnclosingMethod().getName();
		logger = extent.startTest(TestcaseId, "Create account");

		homepageObj.getSignInLink().click();
		
		signInObj.setCreateAccount("santosh1@dc.com");
		signInObj.getCreateAccountButton().click();
		logger.log(LogStatus.INFO, "User is creating an account");
		createAccObj.setFirstName("Santosh");
		createAccObj.setLastName("kumar");
		logger.log(LogStatus.PASS, "Created the account");
	}
	
	@Test(enabled=false)
	public void Test4() {
		homepageObj.getSignInLink().click();
		logger.log(LogStatus.INFO, "User is trying to login");
		signInObj.setEmail("santosh@test.com");
		signInObj.setpassword("123456");
		signInObj.getSignInButton().click();
		logger.log(LogStatus.INFO, "User Login Done");
	}
	
	
	@Test(enabled=false)
	public void Test5() {
		homepageObj.getSignInLink().click();
		
		logger.log(LogStatus.INFO, "User is trying to login");
		signInObj.setEmail("santosh@test.com");
		signInObj.setpassword("123456");
		signInObj.getSignInButton().click();
		logger.log(LogStatus.INFO, "User Login Done");
		
		loginHomePageObj.getLogoutLink().click();
		logger.log(LogStatus.INFO, "User Logged out");
	}
	
}
