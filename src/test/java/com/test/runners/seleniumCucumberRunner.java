package com.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = false, features = { "/src/test/resources/featureFiles/seleniumAutomation.feature" }, glue = {
		"classpath:test.stepDefinitions.uiFunctionalSeleniumGluecodes.java" }, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@selenium and")

public class seleniumCucumberRunner {

}
