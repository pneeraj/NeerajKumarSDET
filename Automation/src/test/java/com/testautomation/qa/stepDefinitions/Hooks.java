package com.testautomation.qa.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testautomation.qa.base.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class Hooks extends TestBase  {



//@After
//public void iniWebDriver() {
//	driver.close();
//}



@Before 
public void intiBASEURI() throws IOException {
	
	//RestAssured.baseURI="https://rahulshettyacademy.com";
	
	TestBase.inititializationAPIProp();
	//String browserName = propAPI.getProperty("BASEURI");
	
	//String baseURIBOOK=propAPI.getProperty("BASEURIBook");
	
	//System.out.println("Bookkkkkkk"+baseURIBOOK);
	
String baseURIJIRA=propAPI.getProperty("JiraBaseURI");
	
	//System.out.println("Bookkkkkkk"+baseURIBOOK);
	
	
	RestAssured.baseURI=baseURIJIRA;
	
	//System.out.println("In Hooks"+browserName);
	
	//BASEURIBook
}

}