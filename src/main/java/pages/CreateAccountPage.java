package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	
	WebDriver driver = null;
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//firstname
	@FindBy(xpath="//input[@id='customer_firstname']")
	private WebElement firstName;
	public String getFirstName() {
		return firstName.getAttribute("value");
	}
	
	public void setFirstName(String name) {
		firstName.sendKeys(name);
	}
	
	//lastname
	@FindBy(xpath="//input[@id='customer_lastname']")
	private WebElement lastName;
	public String getLastName() {
		return lastName.getAttribute("value");
	}
	
	public void setLastName(String name) {
		lastName.sendKeys(name);
	}
	
	//gender
	@FindBy(xpath="//input[@id='id_gender1']")
	private WebElement male;
	@FindBy(xpath="//input[@id='id_gender2']")
	private WebElement female;
	
	public void setGender(String value) {
		if(value.equals("male")) {
			male.click();
		} else if(value.equals("female")) {
			female.click();
		} else {
			System.out.println("invalid gender given");
		}
	}
	
	public void setMale() {
		male.click();
	}
	
	public void setFemale() {
		female.click();
	}
	
}
