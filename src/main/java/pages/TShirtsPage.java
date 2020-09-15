package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirtsPage {
	WebDriver driver = null;

	public TShirtsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='cat-name']")
	private WebElement tShirtText;
	
	public String getTShirtText() {
		return tShirtText.getText().trim();
	}
}
