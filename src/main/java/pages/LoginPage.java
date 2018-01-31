package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import methods.TestBase;
import pageobjectlocators.LoginPageLocators;


public class LoginPage extends TestBase{
	
	/* Initializing WebDriver for the page*/
	public WebDriver driver;
	
	/* Mapping the Object locators to the page*/
	@FindBy(xpath =LoginPageLocators.mainloginButton)
	@CacheLookup
	public WebElement mainloginButton;
	
	@FindBy(xpath =LoginPageLocators.userID)
	@CacheLookup
	public WebElement userID;
	
	@FindBy(xpath =LoginPageLocators.password)
	@CacheLookup
	public WebElement password;
	
	@FindBy(xpath =LoginPageLocators.loginButton)
	@CacheLookup
	public WebElement loginButton;
	
	@FindBy(xpath =LoginPageLocators.errorMsg)
	@CacheLookup
	public WebElement errorMsg;
	
	public LoginPage(WebDriver dr)
	{
		driver=dr;
	}
	
	public void clickmainloginButton()
	{
		letsWait();
		mainloginButton.click();
		letsWait();
	}
	
	public void clickuserID()
	{
		userID.click();
		letsWait();
	}
	public void enterUserId(String userId)
	{
		Actions actions = new Actions(driver);

		letsWait();
		actions.sendKeys(userId);
		System.out.println("User ID is " +userId);
		actions.build().perform();
		letsWait();
	}
	
	public void clickpwd()
	{
		password.click();
		letsWait();
	}
	public void enterPassword(String usrPassword)
	{
		Actions actions = new Actions(driver);

		letsWait();
		actions.sendKeys(usrPassword);
		System.out.println("Password is " +usrPassword);
		actions.build().perform();
		letsWait();
	}
	
	public void clickloginButton()
	{
		loginButton.click();
		letsWait();
	}
	
	
	public String errorMsgValidate()
	{
		String message = errorMsg.getText();
		return message;
		
		
	}
		
	
	
	public void letsWait()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	

}
