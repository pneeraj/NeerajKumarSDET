package com.testautomation.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id="email-or-phone")
	WebElement username;
	
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
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();//landing to home page
		}
	
	


}
