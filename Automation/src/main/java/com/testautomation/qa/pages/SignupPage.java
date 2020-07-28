package com.testautomation.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.qa.base.TestBase;

public class SignupPage extends TestBase  {
	
	@FindBy(id="email-or-phone")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement sugnupBtn;
	
	//Initializing the Page Objects:
			public SignupPage(){
				PageFactory.initElements(driver, this);
			}
	

			public String validateSignupPageTitle(){
				return driver.getTitle();
			}
			
			
			public SignupPage sugnup(String un, String pwd){
				username.sendKeys(un);
				password.sendKeys(pwd);
			     sugnupBtn.click();
				    	
				return new SignupPage();//landing to home page
			}
		

}
