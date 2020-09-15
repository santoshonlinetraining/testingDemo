package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementUsingActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Santosh\\Class\\TestingClass\\drivers\\chromedriver.exe");
		
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get("http://www.bigbasket.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'About Us')]"))).build().perform();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		
		driver.navigate().back();
		
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'bb Daily')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'bb Daily')]")).click();
	}

}
