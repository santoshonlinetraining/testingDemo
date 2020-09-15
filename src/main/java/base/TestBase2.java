package base;

import java.security.Signature;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pages.ContactUsPage;
import pages.CreateAccountPage;
import pages.Homepage;
import pages.LoginHomePage;
import pages.OrdersHistoryAndDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;
import pages.TShirtsPage;
import pages.WomenPage;
import java.io.File;

public class TestBase2 {
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static WebDriver driver;
	
	protected Homepage homepageObj;
	protected ContactUsPage contactUsObj;
	protected CreateAccountPage createAccObj;
	protected LoginHomePage loginHomePageObj;
	protected OrdersHistoryAndDetailsPage ordersHistoryObj;
	protected SearchResultPage searchResPageObj;
	protected SignInPage signInObj;
	protected TShirtsPage tShirtsObj;
	protected WomenPage womenObj;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\Santosh\\AmeerpetClass\\drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		homepageObj = new Homepage(driver);
		contactUsObj = new ContactUsPage(driver);
		createAccObj = new CreateAccountPage(driver);
		loginHomePageObj = new LoginHomePage(driver);
		ordersHistoryObj = new OrdersHistoryAndDetailsPage(driver);
		searchResPageObj = new SearchResultPage(driver);
		signInObj = new SignInPage(driver);
		tShirtsObj = new TShirtsPage(driver);
		womenObj = new WomenPage(driver);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		extent.endTest(logger);
		extent.flush();

	}
	
	@BeforeTest
	public void testbefore() {
		extent = new ExtentReports(System.getProperty("user.dir")+"\\report.html", true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\target\\Config\\extent-config.xml"));
	}
	
	@AfterTest
	public void testafter(ITestResult result) {
		 
		extent.close();
	}
}
