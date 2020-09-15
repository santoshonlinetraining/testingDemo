package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	WebDriver driver=null;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
	private WebElement contanctUsText;
	
	public String getContanctUsText() {
		String text = contanctUsText.getText().trim();
		return text;
	}
	
	
	@FindBy(xpath = "//select[@id='id_contact']")
	private WebElement contanctUsSubHeading;
	
	//private Select sel =new Select(contanctUsSubHeading);
	
	
	public WebElement getContanctUsSubHeading() {
		return contanctUsSubHeading;
	}
	
	public void setContanctUsSubHeading(String value) {
		contanctUsSubHeading.sendKeys(value);
	}
	
/*	public void setContanctUsSubHeading2(String value) {
		sel.selectByVisibleText(value);
	}*/
	
}
