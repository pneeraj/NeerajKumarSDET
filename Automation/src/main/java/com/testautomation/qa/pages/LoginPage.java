package com.testautomation.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.graph.SuccessorsFunction;
import com.testautomation.qa.base.TestBase;

import cucumber.api.java.Before;
import stepDefinitions.Hooks;

public class LoginPage extends TestBase{

	
	@FindBy(xpath="//input[@id=\"usernameField\"]")
	 WebElement username1;
	
	@FindBy(id="password")
	 WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	 WebElement loginBtn;
	
	
	@FindBy(xpath="//span[contains(text(),\"Sign in with Google\")]")
	WebElement sin;
	
	//span[contains(text(),"Sign in with Google")]
	
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	
	//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver,this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		public void login(String un, String pwd) {
			
			System.out.println( " Hello"+un);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			String ss=driver.getTitle();
			
			System.out.println("Get text...................."+ss);
			username1.sendKeys(un);;
		
//			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
//			password.sendKeys(pwd);
//			loginBtn.click();
		
			//return new HomePage();
		}
	
	


}
