package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import methods.TestBase;
import pages.LoginPage;

public class UserStepDefinitions extends TestBase{

	LoginPage loginPage;

	@Before
	public void before()
	{
		try {
			launch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loginPage=PageFactory.initElements(driver, LoginPage.class);
	}
	
	@Given("^Open browser and hit url$")
	public void open_browser_and_hit_url() throws Throwable {
		navigatePage();
	}
	
	@Given("^I click on main login button$")
	public void i_click_on_main_login_button() throws Throwable {
		loginPage.clickmainloginButton();
	}

	@Given("^I enter user name as \"([^\"]*)\"$")
	public void i_enter_user_name_as(String usn) throws Throwable {
		loginPage.clickuserID();
		loginPage.enterUserId(usn);
	   
	}

	@Given("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String psw) throws Throwable {
		loginPage.clickpwd();
		loginPage.enterPassword(psw);
	 
	}
	
	@Given("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		loginPage.clickloginButton();
	    
	}
	
	@Then("^I validate error message$")
	public void i_validate_error_message() throws Throwable {
		assertEquals(loginPage.errorMsgValidate(), "User ID and password invalid.");
	}
	
}
