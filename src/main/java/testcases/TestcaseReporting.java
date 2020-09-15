package testcases;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;

public class TestcaseReporting extends TestBase {
	public ExtentReports extent;
	public ExtentTest logger;
	
	@BeforeClass
	void before() {
		extent = new ExtentReports(System.getProperty("user.dir")+"\\target\\ExtentReports\\SampleExtentReport.html", false);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\target\\Config\\extent-config.xml"));
	}
	
	@Test
	void ValidatingHomePageText_01() {
		String TestcaseId = new Object() {}.getClass().getEnclosingMethod().getName();
		//extent.startTest(TestcaseId);
		logger.log(LogStatus.INFO, "TestcaseStarted");
		logger.log(LogStatus.INFO, "Validating the Home Page Text");
		
		String homepageText = homepageObj.getAutomationPracticeWebSiteText();
		Assert.assertEquals(homepageText, "Automation Practice Website");
		
		logger.log(LogStatus.INFO, "Validated the Home page text");
		logger.log(LogStatus.PASS, "Testapass");
	}
	
	
	@AfterClass
	void after() {
		extent.endTest(logger);
		extent.flush();
		extent.close();

	}
	
}
