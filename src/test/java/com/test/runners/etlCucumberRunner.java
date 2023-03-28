package com.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = false, features = { "/src/test/resources/featureFiles/etlAutomation.feature" }, glue = {
		"classpath:test.stepDefinitions.etlAutomationGluecodes.java" }, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@etl and")

public class etlCucumberRunner {

}
