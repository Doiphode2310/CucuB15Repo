package com.B15Demo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = {"src/test/resources/com/B15Demo/CucumberPath.feature"},
		glue = {"com/B15Demo/"}
		
		)

public class RunCucumberPathStepDefsTest {


}
