package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver = null;
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Automation Practice Website')]")
	private WebElement automationPracticeWebSiteText;
	
	public String getAutomationPracticeWebSiteText() {
		String value = automationPracticeWebSiteText.getText().trim();
		return value;
	}
	
	//contact  us
	@FindBy(xpath = "//a[text()='Contact us']")
	private WebElement contactUsLink;
	
	public WebElement getContactUsLink() {
		return contactUsLink;
	}
	
	//sign in
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	private WebElement signInLink;
	
	public WebElement getSignInLink() {
		return signInLink;
	}
	
}
