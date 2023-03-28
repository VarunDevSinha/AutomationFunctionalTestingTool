package com.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, dryRun = false, features = { "/src/test/resources/featureFiles" }, glue = {
		"classpath:test.stepDefinitions" }, plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, tags = "@etl or @api or @appium or @selenium")

public class MasterCucumberRunner {

}
