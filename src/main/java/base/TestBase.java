package base;

import java.security.Signature;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import listener.WebEventListener;
import pages.ContactUsPage;
import pages.CreateAccountPage;
import pages.Homepage;
import pages.LoginHomePage;
import pages.OrdersHistoryAndDetailsPage;
import pages.SearchResultPage;
import pages.SignInPage;
import pages.TShirtsPage;
import pages.WomenPage;
import testcases.ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestBase {
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static WebDriver driver;
	
	public static Properties prop;
	public static FileInputStream fis;
	
	public static ExcelReader datatable = null; 
	
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
	public void setup() throws IOException {
		
		datatable = new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\resources\\Config\\inputdata.xlsx");
		
		if(datatable.getCellData("Sheet2", "URL", 3).contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Santosh\\Class\\TestingClass\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(datatable.getCellData("Sheet2", "URL", 3).contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Santosh\\Class\\TestingClass\\drivers\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver(); 	
		} else if(datatable.getCellData("Sheet2", "URL", 3).contains("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Santosh\\Class\\TestingClass\\drivers\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
		WebEventListener ecapture = new WebEventListener(); 
		eventHandler.register(ecapture);
		
		eventHandler.manage().window().maximize();
		eventHandler.navigate().to(datatable.getCellData("Sheet2", "URL", 2));
		eventHandler.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eventHandler.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		eventHandler.manage().window().maximize();

		homepageObj = new Homepage(eventHandler);
		contactUsObj = new ContactUsPage(eventHandler);
		createAccObj = new CreateAccountPage(eventHandler);
		loginHomePageObj = new LoginHomePage(eventHandler);
		ordersHistoryObj = new OrdersHistoryAndDetailsPage(eventHandler);
		searchResPageObj = new SearchResultPage(eventHandler);
		signInObj = new SignInPage(eventHandler);
		tShirtsObj = new TShirtsPage(eventHandler);
		womenObj = new WomenPage(eventHandler);
		
		prop = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Config\\config.properties");
		
		//load the file using below command
		prop.load(fis);
		
		

	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		extent.endTest(logger);
		extent.flush();
	}
	
	@BeforeTest
	public void testbefore() {
		extent = new ExtentReports(System.getProperty("user.dir")+"\\report.html", false);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\target\\Config\\extent-config.xml"));
	}
	
	@AfterTest
	public void testafter() {
		extent.close();
	}
}
