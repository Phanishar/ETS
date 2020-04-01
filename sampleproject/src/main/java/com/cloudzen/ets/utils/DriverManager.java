package com.cloudzen.ets.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
	
      

	       ConfigFileReader configFileReader = new ConfigFileReader();

	 

	       private static WebDriver driver;

	       @SuppressWarnings({ "deprecation" })

	       public void InternetDriver() {

	 

	             try {

	                    Thread.sleep(10000);

	                    DesiredCapabilities ie_cap = DesiredCapabilities.internetExplorer();

	                    /*System.setProperty("webdriver.ie.driver",

	                                 System.getProperty("user.dir") + "/src/test/resources/Drivers/IE_32bit/IEDriverServer.exe");*/

	                    System.setProperty("webdriver.ie.driver", configFileReader.getDriverPathforIE());

	                    ie_cap.setCapability("ignoreProtectedModeSettings", true);

	                    ie_cap.setCapability("ie.ensureCleanSession", true);

	             ie_cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

	             ie_cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);

	             ie_cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);

	                    ie_cap.setCapability("enablePersistentHover", true);

	                    ie_cap.setCapability("ignoreZoomSetting", true);

	                    driver = new InternetExplorerDriver(ie_cap);

	             } catch (InterruptedException e) {

	                    // TODO Auto-generated catch block

	                    e.printStackTrace();

	             }

	 

	       }

	 

	       public void CloseIEBrowserDriver() {

	             try {

	                    Runtime.getRuntime().exec("taskkill /f /fi 'pid get 0' /im IEDriverServer.exe");

	                    Runtime.getRuntime().exec("taskkill /f /fi 'pid get 0' /im iexplore.exe");

	                    Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 'pid get 0'");

	             } catch (IOException e) {

	                    // TODO Auto-generated catch block

	                  

	             }

	       }

	 

	       public void ChromeDriver() {

	             System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPathforChrome());

	             ChromeOptions option = new ChromeOptions();

	             /*Proxy proxy = new Proxy();

	             proxy.setHttpProxy("myhttpproxy:3337");*/

	              option.setExperimentalOption("useAutomationExtension", false);

	             option.addArguments("--start-maximized");

	             driver = new org.openqa.selenium.chrome.ChromeDriver(option);

	            

	 

	       }

	 

	       public void CloseChromeDriver() {

	             try {

	                    Runtime.getRuntime().exec("taskkill /f /fi 'pid get 0' /im chromedriver.exe");

	                    Runtime.getRuntime().exec("taskkill /f /fi 'pid get 0' /im chrome.exe");

	             } catch (IOException e) {

	                    // TODO Auto-generated catch block

	                    e.printStackTrace();

	             }

	 

	       }

	      

	         public static WebDriver getDriver() {

	               return driver;

	           }

	      

	      

	         

	}


