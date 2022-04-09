package com.nse.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature/Login.feature"}
		,glue = {"com.nse.stepdefn"}
		,publish = true
		,monochrome = true
		,plugin = {"pretty","html:target/index.html"}
		//,dryRun = true
		,tags = "@valid"
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}
