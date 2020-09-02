package com.testautomation.qa.commonAPI;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.testautomation.qa.stepDefinitions.Steps;

import cucumber.api.java.en.Given;
import static org.hamcrest.Matchers.*;//Using for equals

public class commMethods {
	static String  place = "";

	public static String addLocationBody() {

		String location = "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n" + "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n" + "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n" + "  ],\r\n" + "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n" + "}\r\n" + "";

		return location;

	}
	
	
	
	public static String CoursePrice()
	{
		
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 1162,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    },\r\n" + 
				"     {\r\n" + 
				"      \"title\": \"Appium\",\r\n" + 
				"      \"price\": 36,\r\n" + 
				"      \"copies\": 7\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"  ]\r\n" + 
				"}\r\n" + 
				"";
		
		
		
}
	public static String getComplex2() {
		String ss="{\r\n" + 
				"\r\n" + 
				"\"Afghanistan\": {\r\n" + 
				"\r\n" + 
				"\"Currency\": \"Afghan afghani\",\r\n" + 
				"\r\n" + 
				"\"ISO-4217\": \"AFN\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"Akrotiri and Dhekelia (UK)\": {\r\n" + 
				"\r\n" + 
				"\"Currency\": \"European euro\",\r\n" + 
				"\r\n" + 
				"\"ISO-4217\": \"EUR\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"Aland Islands (Finland)\": {\r\n" + 
				"\r\n" + 
				"\"Currency\": \"European euro\",\r\n" + 
				"\r\n" + 
				"\"ISO-4217\": \"EUR\"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"}";
		return ss;
	}
	
	public static String addBooksBody() {
		
		String body="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"bczd\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}";
	
	return body;
	}
	
	public static String getIssueBody() {
		String body="{\r\n" + 
				" \"fields\": {\r\n" + 
				"        \"project\": {\r\n" + 
				"            \"key\": \"AX\"\r\n" + 
				"        },\r\n" + 
				"        \"summary\": \"CreditCardDefect\",\r\n" + 
				"        \"description\": \"description\",\r\n" + 
				"        \"issuetype\": {\r\n" + 
				"            \"name\": \"Bug\"\r\n" + 
				"        }\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" }";
	return body;
	}
	
	public static String getJIRACredBody() {
		
	String credBody="{ \"username\": \"Neeraj\", \"password\": \"Ganga90$\" }";
	
	return credBody;
	}
	
	public static String deleteLocationBody() {
		
		String loc=Steps.place;
		System.out.println(loc);
		
	String delLocation="{\r\n" + 
			"    \"place_id\":\""+loc+"\"\r\n" + 
			"}";
		return delLocation;
	}
	
public static String updateLocationBody(String updateLoc) {
		
		String loc=Steps.place;
		System.out.println(loc);
		
	String updateLocation="{\r\n" + 
			"\"place_id\":\"29e2031e195646fe2e199f2c71233be4\",\r\n" + 
			"\"address\":\"80 "+updateLoc+" walk, USA\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}";
		return updateLocation;
	}
	public static JsonPath toJsonPath(Response res) {
		String str = res.asString();
		JsonPath js = new JsonPath(str);
		return js;
	}
	public static Response postMethod(HashMap mp,String ress,String body) {
		//Response res = given().log().all().queryParams(mp).header("", "");
		//SessionFilter session=new SessionFilter();
		//filter(session) after when we will add
		Response res = given().header("Content-Type", "application/json").header("cookie","JSESSIONID=47EA1C3392A62F1E4AF39910D9FC929F").log().all().queryParams(mp).body(body).when()
				.post(ress).then().log().all().assertThat().extract().response();
		//assertThat().statusCode(200).body("scope", equalTo("app123")).header("server","Apache/2.4.18/Ubantu")
		return res;
	
	//
	}
	
	public static Response updatetMethod(HashMap mp,String ress,String body) {
		Response res = given().queryParams(mp).body(body).when()
				.put(ress).then().extract().response();
		return res;
	}
	
	public static Response getMothod(String ress,HashMap mp) {
		
		Response res = given().queryParams(mp).when()
				.get(ress).then().extract().response();
		return res;
	}

}
