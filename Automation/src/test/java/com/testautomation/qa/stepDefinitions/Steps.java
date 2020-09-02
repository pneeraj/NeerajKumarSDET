package com.testautomation.qa.stepDefinitions;

import com.testautomation.qa.base.TestBase;
import com.testautomation.qa.commonAPI.commMethods;
import com.testautomation.qa.pages.HomePage;
import com.testautomation.qa.pages.LoginPage;
import com.testautomation.qa.pages.SignupPage;
import io.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

public class Steps extends TestBase {

	HomePage homepage;
	SignupPage signup;
	LoginPage loginpage;
	String token;

	public static String place = "";
	Properties prop = new Properties();

	@Given("^prepared basURI and properties$")
	public void startSetupAPI() throws IOException {
		TestBase.inititializationAPIProp();
	}

	@Given("^when open chrome browser$")
	public void startBrowser() {
		// TestBase.initialization();
	}

	@When("^logged in into LinkedIn application$")
	public void loginLinkedInApplication() {
		loginpage = new LoginPage();

		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@When("^i get home page title$")
	public void enteredUserNameAndPassword() throws Throwable {
		String HomePageTitle = homepage.verifyHomePageTitle();
		System.out.println("Home page title" + HomePageTitle);
		signup = homepage.editProfile();
		signup.validateSignupPageTitle();
	}

	@When("^i add place in google$")
	public void addPlace() throws Throwable {
		HashMap addPlace=new HashMap();
		addPlace.put("key", "qaclick123");
		String ress=propAPI.getProperty("addplaceRes");
		String body=commMethods.addLocationBody();
		System.out.println("Bodyyyyyyyyy"+body);
		Response res=commMethods.postMethod(addPlace,ress,body);
		System.out.println("Respinse Body" + res.getBody().asString());
		JsonPath js = commMethods.toJsonPath(res);
		this.place = js.get("place_id");
	}
	@When("^i get place in google$")
	public void getPlace() throws Throwable {
		HashMap mp=new HashMap();
		String ress=propAPI.getProperty("getPlace");
		mp.put("key", "qaclick123");
		mp.put("place_id", place);
		Response res=commMethods.getMothod(ress, mp);
		System.out.println("Respinse Body" + res.getBody().asString());
	}

	@When("^i delete place in google$")
	public void deltePlace() {
		String body=commMethods.deleteLocationBody();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+body);
		String ress=propAPI.getProperty("deletePlace");
		HashMap delPlace=new HashMap();
		delPlace.put("key", "qaclick123");
		Response res=commMethods.postMethod(delPlace,ress,body);
		System.out.println("Respinse Body---" + res.getBody().asString());
	}

//

	@And("\"([^\"]*)\" place in google$")
	public void updatePlacePlace(String updatePlace1) {
		System.out.println("@@@@@@@@@@@@@$$$$$$$$$$$"+updatePlace1);
		String body=commMethods.updateLocationBody(updatePlace1);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+body);
		String ress=propAPI.getProperty("updatePlace");
		HashMap updatePlace=new HashMap();
		updatePlace.put("key", "qaclick123");
		updatePlace.put("place_id", place);
		
		Response res=commMethods.updatetMethod(updatePlace,ress,body);
		System.out.println("Respinse Body---" + res.getBody().asString());
	}


	//get complexJson json2
	
	@And("get complexJson json2$")
	public void parseComplex2() {
		JsonPath js=new JsonPath(commMethods.getComplex2());
		System.out.println("Complex json"+js);
		System.out.println(commMethods.getComplex2());
	
		HashMap<Object, Object> value=js.get("");
		
//		Map<String, Map<String, String>> map = 
//			    new HashMap<String, Map<String, String>>();
		for(Map.Entry<Object,Object>mp:value.entrySet()) {
			
		System.out.println(mp.getKey());
		System.out.println("---------------");
		System.out.println(mp.getValue());
		
		HashMap<String,String> valueMap=(HashMap<String, String>) mp.getValue();
		
		//System.out.println("$$$$$$"+valueMap);
		System.out.println("Map has started");
		for(Map.Entry<String,String>mp2:valueMap.entrySet() ) {
			
		System.out.println(mp2.getKey());
		System.out.println("##########");
		System.out.println(mp2.getValue());
		}
		}
		
		//System.out.println(value);
	}
	
	@And("get desire value$")
	public void parseComplex() {
		
		JsonPath js=new JsonPath(commMethods.CoursePrice());
		int count=	js.getInt("courses.size()");
		System.out.println("Cource count is"+count);
		
		
		//Print Purchase Amount
		int totalAmount= js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		//Print Title of the first course


		  String titleFirstCourse=js.get("courses[2].title");
		  System.out.println(titleFirstCourse);
		  
		  //Print All course titles and their respective Prices
		  
		  for(int i=0;i<count;i++)
		  {
			  String courseTitles=js.get("courses["+i+"].title");
			  System.out.println(js.get("courses["+i+"].price").toString());
			  
			  System.out.println(courseTitles);
			  
		  }
		  //Print no of copies sold by RPA Course
		  
		 System.out.println("Print no of copies sold by RPA Course");
		 
		 for(int i=0;i<count;i++)
		 {
			  String courseTitles=js.get("courses["+i+"].title");
			  if(courseTitles.equalsIgnoreCase("RPA"))
			  {
				  int copies=js.get("courses["+i+"].copies");
				  System.out.println(copies);
				  break;
			  }
			
			  
		 }
	}
	@And("get the price$")
	public void getPrice() {
		
		{
			int sum = 0;
			JsonPath js=new JsonPath(commMethods.CoursePrice());
			int count=	js.getInt("courses.size()");
			for(int i=0;i<count;i++)
			{
				int price=js.getInt("courses["+i+"].price");
				int copies=js.getInt("courses["+i+"].copies");
				int amount = price * copies;
				System.out.println(amount);
				sum = sum + amount;
				
			}
			System.out.println(sum);
			int purchaseAmount =js.getInt("dashboard.purchaseAmount");
			Assert.assertEquals(sum, purchaseAmount);
			
		}
	}

@When("added books in Librrary API")
 public void addBook() {
	HashMap mp=new HashMap();
	mp.put("Content-Type", "application/json");
	String body=commMethods.addBooksBody();
	String ress=propAPI.getProperty("addBook");
	Response res=commMethods.postMethod(mp, ress, body);
	System.out.println("Respinse Body---" + res.getBody().asString());
	
	
}
@When("create Auth from login")
public void getAuth() {
	HashMap mp=new HashMap();
	String body=commMethods.getJIRACredBody();
	String ress=propAPI.getProperty("creatAuthJira");
	Response res=commMethods.postMethod(mp, ress, body);
	System.out.println("STatus code"+res.getStatusCode());
	System.out.println("Respinse Body---" + res.getBody().asString());
	
	JsonPath js= commMethods.toJsonPath(res);
	String name=js.get("session.name");
	String value=js.get("session.value");
	String token=name+value;
	System.out.println("auth is "+this.token);
}

@And("create issue in jira")
public void createIssue() {
	//createJiraIssue
	HashMap mp=new HashMap();
	String issue=propAPI.getProperty("createJiraIssue");
	String body=commMethods.getIssueBody();
	Response res=commMethods.postMethod(mp, issue, body);
	System.out.println("STatus code"+res.getStatusCode());
	System.out.println("Respinse Body---" + res.getBody().asString());   
}

@And("atched the file")
public void sendFile() {
	String attchement=propAPI.getProperty("jiraAttchment");
	SessionFilter session=new SessionFilter();
	
	given().header("cookie","JSESSIONID=5A9BE6F25D96F5A7F8B093A964EF315C").header("X-Atlassian-Token","no-check")
	.pathParam("key", "10207").header("Content-Type","multipart/form-data").
	multiPart("file",new File("E:\\NeerajSDET\\Automation\\src\\test\\java\\com\\testautomation\\qa\\stepDefinitions\\jira.txt")).when().
	post("rest/api/2/issue/{key}/attachments").then().log().all();
}
}