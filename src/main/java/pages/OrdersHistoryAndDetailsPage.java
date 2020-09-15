package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersHistoryAndDetailsPage {
	WebDriver driver = null;

	public OrdersHistoryAndDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
	private WebElement orderDetailsText;
	
	public String getOrderDetailsText() {
		return orderDetailsText.getText().trim();
	}
	
	
}
