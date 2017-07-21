package com.fanniemae.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/com/github/feature"},
		glue = {"com/github/steps"},
//		plugin = { 
//					"pretty",
//					"html:target/cucumber-reports",
//					"json:target_json/cucumber.json",
//	    	        "junit:target_junit/cucumber_junit.xml"
//				},
		tags = {"@ddInvalidLogin"}
		
		)
public class RunCukeTest {

}