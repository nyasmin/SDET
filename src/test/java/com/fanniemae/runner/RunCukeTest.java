package com.fanniemae.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com\fannie/features"},
		glue = {"/test/java/com/fanniemae/steps"}
//		plugin = { 
//					"pretty",
//					"html:target/cucumber-reports",
//					"json:target_json/cucumber.json",
//	    	        "junit:target_junit/cucumber_junit.xml"
//				},
		
		
		)
public class RunCukeTest {

}