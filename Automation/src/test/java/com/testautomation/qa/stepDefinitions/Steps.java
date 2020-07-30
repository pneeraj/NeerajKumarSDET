package com.testautomation.qa.stepDefinitions;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.pages.HomePage;
import com.testautomation.qa.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Steps extends TestBase {

	HomePage homepage;
	

	@Given("^when open chrome browser$")
	public void startBrowser()
	{
		TestBase.initialization();
	}
	@When("^logged in into LinkedIn application$")
	public void loginLinkedInApplication() {
		LoginPage loginpage=new LoginPage();
		
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@When("^i get home page title$")
	public void enteredUserNameAndPassword() {
		String HomePageTitle=homepage.verifyHomePageTitle();
		System.out.println("Home page title"+HomePageTitle);
		homepage.editProfile();
	}




}
