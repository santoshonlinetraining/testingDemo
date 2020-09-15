package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Santosh\\Class\\TestingClass\\drivers\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver;
		driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");

	}

}
