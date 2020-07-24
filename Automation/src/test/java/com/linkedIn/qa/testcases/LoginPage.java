package com.linkedIn.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedIn.qa.base.TestBase;
import com.linkedIn.qa.pages.HomePage;
import com.linkedIn.qa.util.TestUtil;

public class LoginPage extends TestBase{

	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	
	public LoginPage() {
		super();//it will call to perent class constructor  to intitialialize property file other wise it will give null pointer
	}	

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}



	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}

}
