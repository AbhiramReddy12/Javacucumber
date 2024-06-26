package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "../../Features/homepage.feature",
		glue = "StepDefinations",//package name
		dryRun =false,//this will cross check whether all the feature files has corresponding step def file
		tags = "@Smoke",
		//plugin = {"pretty","html:target/HTMLReports"}
		plugin = {"json:target/cucumber.json"} // to generate results 
		)


public class Runner {
	
	

}
