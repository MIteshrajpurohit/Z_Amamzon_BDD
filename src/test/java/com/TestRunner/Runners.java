package com.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/Features",
		glue = "com.Stepdef",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty" ,"html:target/cucumber-report"},
		tags = " @K"
		
		
		
		
		)







public class Runners {

}
