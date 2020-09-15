package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver = null;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//email create
	@FindBy(xpath="//input[@id='email_create']")
	private WebElement createAccount;
	
	public WebElement getCreateAccount() {
		return createAccount;
	}
	
	public void setCreateAccount(String name) {
		createAccount.sendKeys(name);
	}
	
	//create account button
	@FindBy(xpath="//form[@id='create-account_form']//span[1]")
	private WebElement createAccountButton;
	
	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}
	
	//email
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	public WebElement getEmail() {
		return email;
	}
	
	public void setEmail(String name) {
		email.sendKeys(name);
	}
	
	//password
	@FindBy(xpath="//input[@id='passwd']")
	private WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
	
	public void setpassword(String name) {
		password.sendKeys(name);
	}
	
	//signinbutton
	@FindBy(xpath="//p[@class='submit']//span[1]")
	private WebElement signInButton;
	public WebElement getSignInButton() {
		return signInButton;
	}
	
	//forgetpassword
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	private WebElement forgotPasswordLink;
	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}
	
	
}
