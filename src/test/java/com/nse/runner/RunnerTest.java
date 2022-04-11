package com.nse.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature"}
		,glue = {"com.nse.stepdefn","com.nse.base"}
		,publish = true
		,monochrome = true
		,plugin = {"pretty","html:target/index.html"}
		//,dryRun = true
		//,tags = "@invalid and @login"
		//,tags = "not @invalid"
		//,tags="@valid or @invalid"
		,tags="@patient"
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}
