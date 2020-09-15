package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {
	WebDriver driver = null;

	public WomenPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='cat-name']")
	private WebElement womenText;
	
	public String getWomenText() {
		return womenText.getText().trim();
	}
}
