package com.linkedIn.qa.CucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(   
		
		features="E:\\NeerajSDET\\Automation\\src\\test\\java\\com\\linkedIn\\qa\\features\\LinkedInSanity.feature",
		glue="stepDefinitions",
		//tags="@Smoke,@Reg",
		//tags="@Smoke",
		//tags="@WebTest",
		//,@WebTest,@APITest",
		strict=true,
		//dryRun=true,
		plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml","rerun:rerun/failed_scenarios.txt"},
		monochrome=true)


public class TestRunner {

}
