package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginHomePage {
	
	WebDriver driver = null;

	public LoginHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath ="//p[@class='info-account']")
	private WebElement loginHomepageText;
	
	public String getLoginHomepageText() {
		return loginHomepageText.getText().trim();
	}
	
	//womenlink
	@FindBy(xpath ="//a[@class='sf-with-ul'][contains(text(),'Women')]")
	private WebElement womenLink;
	public WebElement getwomenLink() {
		return womenLink;
	}
	
	@FindBy(xpath ="//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
	private WebElement dressesLink;
	public WebElement getdressesLink() {
		return dressesLink;
	}
	
	@FindBy(xpath ="//body[@id='my-account']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[1]")
	private WebElement TShirts;
	public WebElement getTShirts() {
		return TShirts;
	}
	
	@FindBy(xpath ="//span[contains(text(),'Order history and details')]")
	private WebElement orderHistoryButton;
	public WebElement getorderHistoryButton() {
		return orderHistoryButton;
	}
	
	@FindBy(xpath ="//input[@id='search_query_top']")
	private WebElement searchText;
	public void getSearchText(String name) {
		searchText.sendKeys(name);
	}
	
	@FindBy(xpath ="(//a[contains(text(),'Sign out')])[1]")
	private WebElement logoutLink;
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	
}
