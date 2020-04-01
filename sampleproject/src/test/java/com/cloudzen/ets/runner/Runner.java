package com.cloudzen.ets.runner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.cloudzen.ets.utils.ConfigFileReader;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/ETSStories/login.feature", glue = {
		"com.cloudzen.ets.stepdef" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true, tags = "@tc-01")

public class Runner {
	static ConfigFileReader cfr = new ConfigFileReader();

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(cfr.getReportConfigPath()));

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		// ExtentReports extent = new ExtentReports ("C:\\someFolder"+ "
		// +"\\target\\" + timeStamp + "cucumber-reports/report.html", true);
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.141.59");
		Reporter.setSystemInfo("Maven", "3.6.3");
		Reporter.setSystemInfo("Java Version", "1.8.0_231");

	}
}