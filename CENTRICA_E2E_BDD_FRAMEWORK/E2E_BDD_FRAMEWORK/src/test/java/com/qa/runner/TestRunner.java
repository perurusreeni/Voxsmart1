package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resource/Feature"},
		glue = {"com.qa.stepDefinition"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"},
		//tags = "@loginandshopaproductwithlowprice",
		monochrome = true,
		publish = true
		
		
		)
public class TestRunner {

}
