package stepDefinitions;

import com.testautomation.qa.base.TestBase1;
import com.testautomation.qa.pages.LoginPage1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Steps extends TestBase1 {
	
	
	

	@Given("^when open chrome browser$")
	public void startBrowser()
	{
		TestBase1.initialization();
	}
	
	
	
	@When("^i entered User and password$")
	public void enteredUserNameAndPassword() {
		
	}
	
	
	@When("^logged in into LinkedIn application$")
	public void loginLinkedInApplication() {
		LoginPage1 log=new LoginPage1();
		log.login("Neeraj9kumarpathak@gmail.com", "Ganga90$");
	}





}
