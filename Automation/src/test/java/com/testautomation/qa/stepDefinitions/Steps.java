package stepDefinitions;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Steps extends TestBase {
	
	
	

	@Given("^when open chrome browser$")
	public void startBrowser()
	{
		TestBase.initialization();
	}
	
	
	
	@When("^i entered User and password$")
	public void enteredUserNameAndPassword() {
		
	}
	
	
	@When("^logged in into LinkedIn application$")
	public void loginLinkedInApplication() {
		LoginPage log=new LoginPage();
		log.login("Neeraj9kumarpathak@gmail.com", "Ganga90$");
	}





}
