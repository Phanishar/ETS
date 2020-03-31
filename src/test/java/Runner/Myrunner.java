package Runner;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.cucumber.listener.Reporter;

import Dataprovider.ConfigFileReader;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
features = "src//test//resources//ETSStories//AdvanceSearch.feature",
glue= {"AdvanceScreen"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
monochrome = true,tags="@tc-03")

public class Myrunner {
static ConfigFileReader cfr= new ConfigFileReader();

 @AfterClass
public static void writeExtentReport() {
Reporter.loadXMLConfig(new File(cfr.getReportConfigPath()));

String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//ExtentReports extent = new ExtentReports ("C:\\someFolder"+ " +"\\target\\" + timeStamp + "cucumber-reports/report.html", true);
   Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
   Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));  
   Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
   Reporter.setSystemInfo("Selenium", "3.141.59");
   Reporter.setSystemInfo("Maven", "3.6.3");
   Reporter.setSystemInfo("Java Version", "1.8.0_231");
   
}
}