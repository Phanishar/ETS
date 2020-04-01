package com.cloudzen.ets.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.apache.http.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class CommonMethods {
	// final static Logger logger = Logger.getLogger(CommanMethods.class);

	public static HashMap<Integer, String> dateref = new HashMap<Integer, String>();

	// public static HashMap<String, By> navigationMap = new HashMap<String,
	// By>();

	// public static HashMap<String, By> navigationReferenceMap = new

	// HashMap<String, By>();

	// public static final List<String> mREmenu = asList("maintenance",

	// "makercheckersummary", "dashboardreport",

	// "main_merchantrepository", "main_batchscheduler",

	// "main_trackingandfulfilmenttemplate",

	// "eligibilitycriteriamaintenance", "batchschedulersummary",

	// "mkck_merchantrepository", "mkck_batchscheduler",

	// "mkck_trackingandfulfilmenttemplate", "merchantdashboard",

	// "mredatadashboard", "mrerewardsdashboard",

	// "channeldashboard");

	// public static final List<String> maintenancemenu =

	// asList("compaignmaintenance", "productmaintenance",

	// "workgroupmaintenance");

	// public static WebDriver DriverManager.getDriver();

	public static Properties logproperty;

	public static String currentImagePath = "";

	DriverManager dm = new DriverManager();

	/**
	 * 
	 * @author Phani and Lavannya
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 *            - verify the element is displayed in DOM or not
	 * 
	 * @return
	 * 
	 */

	public boolean isWebElementDisplayed(By locator) {

		boolean elementDisplayed = false;

		try {

			boolean isPresent = DriverManager.getDriver().findElements(locator).size() > 0;

			if (isPresent) {

				moveToElement(locator);

				elementDisplayed = DriverManager.getDriver().findElement(locator).isDisplayed();

			}

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Displayed in DOM");

		}

		return elementDisplayed;

	}

	public void movetoSpecificLocation(String objectReference) {

		WebElement ele = DriverManager.getDriver().findElement(getLocator(objectReference));

		Actions act = new Actions(DriverManager.getDriver());

		act.moveToElement(ele);

	}

	public boolean isWebElementDisplayed(String objectReference) {

		boolean elementDisplayed = false;

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} /*
			 * catch (ParseException e) {
			 * 
			 * logger.error("Error: ", e);
			 * 
			 * }
			 */

		By locator = getLocator(objectReference);

		try {

			boolean isPresent = DriverManager.getDriver().findElements(locator).size() > 0;

			// logger.info("checkinggg " + isPresent);

			if (isPresent) {

				moveToElement(locator);

				elementDisplayed = DriverManager.getDriver().findElement(locator).isDisplayed();

				// logger.debug("element Displayed : " + elementDisplayed);

			}

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Displayed in DOM");

		}

		return elementDisplayed;

	}

	/**
	 * 
	 * Verify element is enabled in the WebPage
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 * @return
	 * 
	 */

	public boolean isWebElementEnabled(By locator) {

		boolean elementEnabled = false;

		try {

			boolean isPresent = DriverManager.getDriver().findElements(locator).size() > 0;

			if (isPresent && DriverManager.getDriver().findElement(locator).isDisplayed())

				elementEnabled = DriverManager.getDriver().findElement(locator).isEnabled();

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Enabled");

		}

		return elementEnabled;

	}

	public boolean isWebElementEnabled(String objectReference) {

		boolean elementEnabled = false;

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		try {

			boolean isPresent = DriverManager.getDriver().findElements(locator).size() > 0;

			if (isPresent && DriverManager.getDriver().findElement(locator).isDisplayed())

				elementEnabled = DriverManager.getDriver().findElement(locator).isEnabled();

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Enabled");

		}

		return elementEnabled;

	}

	/**
	 * 
	 * Verify element is Checked in the WebPage
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 * @return
	 * 
	 */

	public boolean isWebElementSelected(By locator) {

		boolean elementEnabled = false;

		try {

			boolean isPresent = DriverManager.getDriver().findElements(locator).size() > 0;

			if (isPresent && DriverManager.getDriver().findElement(locator).isDisplayed())

				elementEnabled = DriverManager.getDriver().findElement(locator).isSelected();

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Selected");

		}

		return elementEnabled;

	}

	public boolean isWebElementSelected(String objectReference) {

		boolean elementSelected = false;

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} /*
			 * catch (ParseException e) {
			 * 
			 * logger.error("Error: ", e);
			 * 
			 * }
			 */

		By locator = getLocator(objectReference);

		try {

			boolean isPresent = DriverManager.getDriver().findElements(locator).size() > 0;

			if (isPresent && DriverManager.getDriver().findElement(locator).isDisplayed())

				elementSelected = DriverManager.getDriver().findElement(locator).isSelected();

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Selected");

		}

		return elementSelected;

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 *            - used to wait till the element is visible in DOM
	 * 
	 */

	public void waitForPresence(By locator) {

		try {

			Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.withTimeout(Duration.ofSeconds(30))

					.pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);

			// WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
			// 30);

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Displayed in DOM");

		}

	}

	public void waitForPresence(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} // catch (ParseException e) {

		// logger.error("Error: ", e);

		// }

		By locator = getLocator(objectReference);

		try {

			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		} catch (NoSuchElementException e) {

			// logger.info(locator + " is not Displayed in DOM");

		}

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 *            - Used to set the mouse focus to desired locator
	 * 
	 */

	public void moveToElement(By locator) {

		waitForPresence(locator);

		WebElement element = DriverManager.getDriver().findElement(locator);

		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

		// new
		// Actions(DriverManager.getDriver()).moveToElement(element).build().perform();

	}

	public void moveToElement(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (IOException e) {

			// logger.error("Error: ", e1);

		}

		By locator = getLocator(objectReference);

		waitForPresence(locator);

		WebElement element = DriverManager.getDriver().findElement(getLocator(objectReference));

		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

		try {

			Thread.sleep(500);

		} catch (InterruptedException e) {

			// logger.error("Error: ", e);
		}

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 *            - Used to set the mouse focus to desired locator and to select
	 *            the
	 * 
	 *            option
	 * 
	 */

	public void moveToElement_andClick(By locator) {

		waitForPresence(locator);

		WebElement element = DriverManager.getDriver().findElement(locator);

		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

		try {

			Thread.sleep(500);

		} catch (InterruptedException e) {

			// logger.error("Error: ", e);

		}

		clickByJS(locator);

		// new
		// Actions(DriverManager.getDriver()).moveToElement(element).click().build().perform();

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 *            - Navigate to frame
	 * 
	 * @param framereference
	 * 
	 *            - Enter frame reference like 1 , framename, //div
	 * 
	 * @param frametype
	 * 
	 *            - Enter the frame type index, name or webelement
	 * 
	 */

	public void movetoframe(String framereference, String frametype) {

		if (frametype.equalsIgnoreCase("index")) {

			DriverManager.getDriver().switchTo().frame(Integer.parseInt(framereference));

		} else if ((frametype.equalsIgnoreCase("name"))) {

			DriverManager.getDriver().switchTo().frame(framereference);

		}

		else if ((frametype.equalsIgnoreCase("webelement"))) {

			WebElement ele = DriverManager.getDriver().findElement(By.xpath(framereference));

			DriverManager.getDriver().switchTo().frame(ele);

		}

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 *            Exit from the current frame
	 * 
	 */

	public void moveoutofframe() {

		DriverManager.getDriver().switchTo().defaultContent();

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 *            - Click the desired element
	 * 
	 */

	public void click(By locator) {

		waitForPresence(locator);

		DriverManager.getDriver().findElement(locator).click();

	}

	public void click(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} // catch (ParseException e) {

		// logger.error("Error: ", e);

		// }

		// By locator = getLocator(objectReference);

		// waitForPresence(locator);

		DriverManager.getDriver().findElement(getLocator(objectReference)).click();

	}

	public void click(String objectReference, String lang) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} /*
			 * catch (ParseException e) {
			 * 
			 * logger.error("Error: ", e);
			 * 
			 * }
			 */

		By locator = getLocator(objectReference);

		waitForPresence(locator);

		WebElement element = DriverManager.getDriver().findElement(locator);

		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);

		// DriverManager.getDriver().findElement(locator).click();

	}

	/**
	 *
	 * 
	 * 
	 * @param driverL
	 * 
	 * @param locator
	 * 
	 *            - Click the element using JavaScript
	 * 
	 */

	public void clickByJS(By locator) {

		WebElement element = DriverManager.getDriver().findElement(locator);

		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);

	}

	public void clickByJS(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} /*
			 * catch (ParseException e) {
			 * 
			 * // logger.error("Error: ", e);
			 * 
			 * }
			 */

		By locator = getLocator(objectReference);

		waitForPresence(locator);

		WebElement element = DriverManager.getDriver().findElement(locator);

		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", element);

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 *            - Enter the values in desired location
	 * 
	 * @param value
	 * 
	 *            - any non empty value
	 * 
	 * @return
	 * 
	 */

	/*
	 * public void setProperty(String testcaseID) {
	 * 
	 * Properties logproperty = new Properties();
	 * 
	 * try {
	 * 
	 * logproperty.load(new FileInputStream("./configs/log4j.properties"));
	 * 
	 * logproperty.setProperty("TestcaseName", testcaseID);
	 * 
	 * PropertyConfigurator.configure(logproperty);
	 * 
	 * 
	 * 
	 * } catch (FileNotFoundException e) {
	 * 
	 * logger.error("Error: ", e);
	 * 
	 * } catch (IOException e) {
	 * 
	 * logger.error("Error: ", e);
	 * 
	 * }
	 * 
	 * }
	 */

	@SuppressWarnings("null")

	public String enterValues(By locator, String value) {

		if (value != null || !(value.equalsIgnoreCase(""))) {

			waitForPresence(locator);

			DriverManager.getDriver().findElement(locator).clear();

			DriverManager.getDriver().findElement(locator).sendKeys(value);

		}

		return value;

	}

	public void enterValues(String objectReference, Keys keys) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		waitForPresence(locator);

		DriverManager.getDriver().findElement(locator).sendKeys(keys);

	}

	@SuppressWarnings("null")

	public String enterValues(String objectReference, String value) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		// moveToElement(locator);

		if (value != null || !(value.equalsIgnoreCase(""))) {

			waitForPresence(locator);

			DriverManager.getDriver().findElement(locator).clear();

			DriverManager.getDriver().findElement(locator).sendKeys(value);

		}

		return value;

	}

	public void enterValues(By locator, Keys keys) {

		if (keys != null) {

			waitForPresence(locator);

			DriverManager.getDriver().findElement(locator).sendKeys(keys);

		}

	}

	public void clear(By locator) {

		waitForPresence(locator);

		DriverManager.getDriver().findElement(locator).clear();

	}

	public void clear(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		waitForPresence(locator);

		moveToElement(locator);

		DriverManager.getDriver().findElement(locator).clear();

	}

	public String getColor(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		return DriverManager.getDriver().findElement(locator).getCssValue("color");

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 * @return the description in the label / message of the locator
	 * 
	 */

	public String getElementText(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		String text = DriverManager.getDriver().findElement(locator).getText();

		return text;

	}

	public String getElementText(By locator) {

		String text = DriverManager.getDriver().findElement(locator).getText();

		return text;

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 * @param locator
	 * 
	 * @return the value of the locator
	 * 
	 */

	public String getElementValue(By locator) {

		String text = DriverManager.getDriver().findElement(locator).getAttribute("value");

		return text;

	}

	public String getElementValue(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		moveToElement(locator);

		String text = DriverManager.getDriver().findElement(locator).getAttribute("value");

		return text;

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 *            - Compare the UI text against the given text
	 * 
	 * @param locator
	 * 
	 *            - Element of the textBox or label to compare
	 * 
	 * @param expectedText
	 * 
	 *            - Actual value to compare with UI value
	 * 
	 * @param fieldType
	 * 
	 *            - Text field or label. i.e., if getText() then enter label or
	 * 
	 *            getAttribute() enter value
	 * 
	 * @return
	 * 
	 */

	public boolean compareText(By locator, String expectedText, String fieldType) {

		boolean matches = false;

		String actualText = "";

		try {

			if (fieldType.trim().toLowerCase().equals("label")) {

				actualText = DriverManager.getDriver().findElement(locator).getText();

			} else

				actualText = DriverManager.getDriver().findElement(locator).getAttribute("value");

		} catch (Exception e) {

			// logger.error("Error: ", e);

			// Assert.fail(locator + "is not found");

		} //

		if ((actualText != null) && (expectedText != null)) {

			if (expectedText.equalsIgnoreCase(actualText)) {

				matches = true;

				// logger.info(actualText + "is matches with " + expectedText);

			}

		}

		return matches;

	}

	public boolean compareText(String objectReference, String expectedText, String fieldType) {

		boolean matches = false;

		String actualText = "";

		try {

			loadObjects(objectReference.split("-")[0].toLowerCase());

		} catch (IOException | ParseException e1) {

			// logger.error("Error: ", e1);

		}

		By locator = getLocator(objectReference);

		try {

			if (fieldType.trim().toLowerCase().equals("label")) {

				actualText = DriverManager.getDriver().findElement(locator).getText();

			} else

				actualText = DriverManager.getDriver().findElement(locator).getAttribute("value");

		} catch (Exception e) {

			// logger.error("Error: ", e);

			// Assert.fail(locator + "is not found");

		}

		if ((actualText != null) && (expectedText != null)) {

			if (expectedText.equalsIgnoreCase(actualText)) {

				matches = true;

				// logger.info(actualText + "is matches with " + expectedText);

			}

		}

		return matches;

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 *            - To Launch the URL
	 * 
	 * @param URL
	 * 
	 *            - URL address
	 * 
	 */

	public void openURL(String user) {

		if (user.equalsIgnoreCase("merchant"))

			DriverManager.getDriver().get(getPropertyValue(user.toLowerCase() + "_URL"));

		else

			DriverManager.getDriver().get(getPropertyValue(user.substring(0, 4).toLowerCase() + "_URL"));

		// DriverManager.getDriver().manage().timeouts().implicitlyWait(10,
		// TimeUnit.SECONDS);

	}

	/**
	 *
	 * 
	 * 
	 * @param propertyValue
	 * 
	 *            Read the value from property file
	 * 
	 * @return the value of the desired Key in the config.properties
	 * 
	 */

	public String getPropertyValue(String propertyValue) {

		String value = "";

		Properties prop = new Properties();

		try {

			prop.load(new FileInputStream("configs//Config.properties"));

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		}

		value = prop.getProperty(propertyValue);

		return value;

	}

	/**
	 *
	 * 
	 * 
	 * @param DriverManager.getDriver()
	 * 
	 *            - Return the list of identified elements
	 * 
	 * @param locator
	 * 
	 * @return
	 * 
	 */

	public java.util.List<WebElement> getAllelements(By locator) {

		return DriverManager.getDriver().findElements(locator);

	}

	public java.util.List<WebElement> getAllelements(String objectReference) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		return DriverManager.getDriver().findElements(locator);

	}

	@SuppressWarnings({ "deprecation" })

	public void launchbrowser(String user) throws InterruptedException {

		String browser = getPropertyValue("Browser").toLowerCase().replace(" ", "");

		if (user.equalsIgnoreCase("merchant")) {

			browser = "chrome";

		} else if (user.substring(0, 4).equalsIgnoreCase("citi")) {

			browser = "Internet Explorer";

		}

		/*
		 * if (browser.equals(""))
		 * 
		 * browser = LoginPage_Stepdef.i;
		 */

		switch (browser) {

		case "chrome": {

			// logger.info("Killing chrome.exe");

			dm.CloseChromeDriver();

			dm.ChromeDriver();

			break;

		}

		case "Firefox": {

			System.setProperty("webdriver.gecko.DriverManager.getDriver()",

					System.getProperty("user.dir") + "/src/test/resources/drivers/Firefox/geckodriver.exe");

			// FirefoxDriver FD = new FirefoxDriver();

			DriverManager.getDriver().manage().window().maximize();

		}

		case "Internet Explorer": {

			// logger.info("Killing IEDriverServer.exe");

			dm.CloseIEBrowserDriver();

			dm.InternetDriver();

			break;

		}

		default: {

			// logger.info("Killing IEDriverServer.exe");

			dm.CloseIEBrowserDriver();

			dm.InternetDriver();

		}

		}

	}

	public String responseDuration(long starttime, long endtime) {

		long duration = endtime - starttime;

		int hrs = (int) ((duration / 1000) / 60) / 60;

		hrs %= 60;

		int min = (int) (duration / 1000) / 60;

		min %= 60;

		int sec = (int) (duration / 1000);

		sec = sec %= 60;

		int millisec = (int) (duration - (sec * 1000) + (min * 60 * 1000) + (hrs * 60 * 60 * 1000));

		millisec %= 1000;

		return hrs + "h " + min + "m " + sec + "s+" + millisec + "ms";

	}

	public String responseDuration(long time) {

		int hrs = (int) ((time / 1000) / 60) / 60;

		hrs %= 60;

		int min = (int) (time / 1000) / 60;

		min %= 60;

		int sec = (int) (time / 1000);

		sec = sec %= 60;

		int millisec = (int) (time - (sec * 1000) + (min * 60 * 1000) + (hrs * 60 * 60 * 1000));

		millisec %= 1000;

		return hrs + "h " + min + "m " + sec + "s+" + millisec + "ms";

	}

	public void selectValuefromDropdown(String objectReference, String selectType, String passvalue) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		By locator = getLocator(objectReference);

		waitForPresence(locator);

		// Select value = new
		// Select(DriverManager.getDriver().findElement(locator));

		// if (selectType.toLowerCase().replace(" ",
		// "").equalsIgnoreCase("visibletext"))

		// value.selectByVisibleText(passvalue);

		// else if (selectType.toLowerCase().replace(" ",
		// "").equalsIgnoreCase("value"))

		// value.selectByValue(passvalue);

		// else if (selectType.toLowerCase().replace(" ",
		// "").equalsIgnoreCase("index"))

		// value.selectByIndex(Integer.parseInt(passvalue));

	}

	public void selectValuefromDropdown(By locator, String selectType, String passvalue) {

		// Select value = new
		// Select(DriverManager.getDriver().findElement(locator));

		// if (selectType.toLowerCase().replace(" ",
		// "").equalsIgnoreCase("visibletext"))

		// value.selectByVisibleText(passvalue);

		// else if (selectType.toLowerCase().replace(" ",
		// "").equalsIgnoreCase("value"))

		// value.selectByValue(passvalue);

		// else if (selectType.toLowerCase().replace(" ",
		// "").equalsIgnoreCase("index"))

		// value.selectByIndex(Integer.parseInt(passvalue));

	}

	public byte[] convertImagetoBytes() {
		return null;

		// return ((TakesScreenshot)
		// DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);

	}

	/*
	 * 
	 * public void captureFullScreenshot(String screenShotName) { Date date =
	 * new
	 * 
	 * Date(); SimpleDateFormat dateformat = new
	 * 
	 * SimpleDateFormat("dd-MM-yy'_'HH-mm-ss"); final Screenshot screenshot =
	 * new
	 * 
	 * AShot().shootingStrategy( new
	 * 
	 * ViewportPastingStrategy(500)).takeScreenshot(DriverManager.getDriver());
	 * final BufferedImage
	 * 
	 * image = screenshot.getImage(); try { ImageIO.write(image, "JPG", new
	 * 
	 * File(BasicDefinitions.Screenshotpath+screenShotName+"_"+dateformat.
	 * format(
	 * 
	 * date)+".jpg")); } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * captureScreenshot(); }
	 * 
	 */

	public void captureScreenshot() {

		// DriverManager.getDriver().manage().timeouts().implicitlyWait(30,
		// TimeUnit.SECONDS);

		// BasicDefinitions.getScenario().embed(convertImagetoBytes(),
		// "image/jpeg");

	}

	public void captureScreenshot(String screenshotName) {

		try {

			Thread.sleep(7000);

		} catch (InterruptedException e1) {

			// logger.error("Error: ", e1);

		}

		// BufferedImage image = null;

		// try {

		// image = new Robot().createScreenCapture(new
		// Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		// } catch (HeadlessException e1) {

		// TODO Auto-generated catch block

		// logger.error("Error while capturing screenshot: ",e1);

		// } catch (AWTException e1) {

		// TODO Auto-generated catch block

		// logger.error("Error while capturing screenshot: ",e1);

		// }

		// File srcFile =
		// ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		// Date date = new Date();

		// SimpleDateFormat dateformat = new
		// SimpleDateFormat("dd-MM-yy'_'HH-mm-ss");

		// try {

		// String path = screenshotName + "_" + dateformat.format(date) +
		// ".png";

		// currentImagePath = "TestReport" + File.separator + "TestEvidence" +
		// File.separator + path;

		// currentImagePath =
		// "C:\\Users\\lt32494\\ExecutionReport"+File.separator+"TestEvidence"+File.separator+path;

		// FileUtils.copyFile(srcFile, new File (currentImagePath));

		// ImageIO.write(image, "png", new File(currentImagePath));

		// } catch (IOException e) {

		// logger.error("Folder Not Exists to save a file: ",e);

		// }

		// captureScreenshot();

	}

	public void test() {

		File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		// String encodstring = encodeFileToBase64Binary(srcFile);

	}

	public void DemocaptureScreenshot(String screenshotName, String filepath) throws IOException {

		File srcFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

		Date date = new Date();

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yy'_'HH-mm-ss");

		captureScreenshot();

	}

	public String getfontfamily(By locator) {

		return DriverManager.getDriver().findElement(locator).getCssValue("font-family");

	}

	public int getFontSize(By locator) {

		return Integer.parseInt(DriverManager.getDriver().findElement(locator).getCssValue("font-size"));

	}

	public boolean fieldValidation(String objectReference, String fieldtype, String supports, int size) {

		boolean flag = false, success = false;

		String value = getElementValue(objectReference);

		String val = "";

		switch (fieldtype.toLowerCase().replace(" ", "")) {

		case "numeric":

			if (value.matches("\\D"))

				// Assert.fail("Value contains Alphabets or Special
				// characters");

				// else

				flag = true;

			break;

		case "alphanumeric":

			if (value.matches("\\D"))

				// Assert.fail("Value contains Special Characters");

				// else

				flag = true;

			break;

		case "characters":

			if (value.matches("\\d") || value.matches("[^a-zA-Z]"))

				// Assert.fail("Value contains Numbers or Special characters");

				// else

				flag = true;

			break;

		case "specialcharacters":

			val = value.replaceAll("[a-zA-Z0-9]", "");

			if (val.length() > 0)

				flag = true;

		case "alphanumeric&specialcharacters":

			// val = value.replaceAll("[a-zA-Z0-9]", "");

			// logger.debug("length" + value);

			flag = true;

		}

		switch (supports.toLowerCase().replace(" ", "")) {

		case "<":

			if (flag && size >= value.length()) {

				success = true;

				// logger.debug("Less than:" + success);

			}

			break;

		case "=":

			if (flag && size == value.length()) {

				success = true;

				// logger.debug("Equal:" + success);

			}

			break;

		case ">":

			if (flag && size <= value.length()) {

				success = true;

				// logger.debug("Greaterthan:" + success);

			}

			break;

		case "upto":

			if (flag && size >= value.length()) {

				success = true;

			}

			break;

		case "exact":

			if (flag && size == value.length()) {

				success = true;

			}

			break;

		case "morethan":

			if (flag && size <= value.length()) {

				success = true;

			}

			break;

		}

		return (success && flag);

	}

	private enum LocatorType {

		id, name, cssselector, tagname, partiallinktext, linktext, xpath, classname;

	}

	public void loadObjects(String fileName) throws FileNotFoundException, IOException, ParseException {

		// JSONParser parser = new JSONParser();

		// Object obj = parser.parse(new
		// FileReader("./src/test/resources/testDataResources/" + fileName +
		// ".json"));

		// BasicDefinitions.objectRepo = (JSONObject) obj;

	}

	public By getLocator(String objectReference) {

		if (objectReference != null) {

			// String dataReference = (String)
			// BasicDefinitions.objectRepo.get(objectReference);

			// By locator = null;

			// if (dataReference != null &&
			// dataReference.split(Pattern.quote("|")).length == 2) {

			// LocatorType locatorType =
			// LocatorType.valueOf(dataReference.split(Pattern.quote("|"))[0]);

			// switch (locatorType) {

			// case id:

			// locator = By.id(dataReference.split(Pattern.quote("|"))[1]);
			//
			// break;
			//
			// case name:

			// locator = By.name(dataReference.split(Pattern.quote("|"))[1]);

			// break;

			// case xpath:

			// locator = By.xpath(dataReference.split(Pattern.quote("|"))[1]);

			// break;

			// case cssselector:

			// locator =
			// By.cssSelector(dataReference.split(Pattern.quote("|"))[1]);

			// break;

			// case linktext:

			// locator =
			// By.linkText(dataReference.split(Pattern.quote("|"))[1]);

			// break;

			// case partiallinktext:

			// locator =
			// By.partialLinkText(dataReference.split(Pattern.quote("|"))[1]);

			// break;

			// case classname:

			// locator =
			// By.className(dataReference.split(Pattern.quote("|"))[1]);

			// break;

			// case tagname:

			// locator = By.tagName(dataReference.split(Pattern.quote("|"))[1]);

			// break;

		}

		// }

		// return locator;

		// }

		// Assert.fail("Locator is Not Available");

		return null;

	}

	public String getCurrentDate() {

		Date date = new Date();

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

		return dateformat.format(date);

	}

	public String getReportDate() {

		Date date = new Date();

		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");

		return dateformat.format(date);

	}

	public String getCurrentTime() {

		Date date = new Date();

		// SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");

		SimpleDateFormat dateformat = new SimpleDateFormat("HH-mm-ss");

		return dateformat.format(date);

	}

	public void dateMap1() {

		dateref.put(1, "January");

		dateref.put(2, "February");

		dateref.put(3, "March");

		dateref.put(4, "April");

		dateref.put(5, "May");

		dateref.put(6, "June");

		dateref.put(7, "July");

		dateref.put(8, "August");

		dateref.put(9, "September");

		dateref.put(10, "October");

		dateref.put(11, "November");

		dateref.put(12, "December");

	}

	public HashMap<Integer, String> dateMap() {

		HashMap<Integer, String> monthRef = new HashMap<Integer, String>();

		monthRef.put(1, "January");

		monthRef.put(2, "February");

		monthRef.put(3, "March");

		monthRef.put(4, "April");

		monthRef.put(5, "May");

		monthRef.put(6, "June");

		monthRef.put(7, "July");

		monthRef.put(8, "August");

		monthRef.put(9, "September");

		monthRef.put(10, "October");

		monthRef.put(11, "November");

		monthRef.put(12, "December");

		return monthRef;

	}

	public void navigateBack() {

		DriverManager.getDriver().navigate().back();

	}

	public void navigateForward() {

		DriverManager.getDriver().navigate().forward();

	}

	public void flushproperty(Properties property) {

		property = null;

	}

	public void alert_accept() {

		Alert alert = DriverManager.getDriver().switchTo().alert();

		alert.accept();

	}

	public void alert_dismiss() {

		Alert alert = DriverManager.getDriver().switchTo().alert();

		alert.dismiss();

	}

	public String alert_readstring() {

		Alert alert = DriverManager.getDriver().switchTo().alert();

		return alert.getText();

	}

	public String decryptText(String encryptedText) {

		// byte[] passworddecoded = Base64.decodeBase64(new
		// String(encryptedText));

		// String password = new String(passworddecoded);

		return null;

	}

	public void SelectDateRangeFromDatePicker(String startdate, String enddate)

			throws InterruptedException, ParseException {

		int dat = Integer.parseInt(getToday());

		Random r = new Random();

		int sranNum = 30 - dat + 1;

		int sDate = r.nextInt(sranNum) + dat;

		int eranNum = 30 - sDate + 1;

		int eDate = r.nextInt(eranNum) + sDate + 1;

		if (eDate == 31)

			eDate = eDate - 1;

		// logger.debug("sdate******" + sDate);

		// logger.debug("edate******" + eDate);

		for (int i = 1; i <= 6; i++) {

			// logger.debug("i****" + i);

			if (isWebElementEnabled(By.xpath(

					"//table[@class='days weeks']/tbody/tr[" + i + "]/td/span[contains(text(),'" + sDate + "')]"))) {

				WebElement ele = DriverManager.getDriver().findElement(By.xpath(

						"//table[@class='days weeks']/tbody/tr[" + i + "]/td/span[contains(text(),'" + sDate + "')]"));

				String color = ele.getCssValue("color");

				// logger.debug("sDate color*****" + color);

				if (color.equalsIgnoreCase("rgba(5, 109, 174, 1)")) {

					ele.click();

					for (int j = i; j < 6; j++) {

						// logger.debug("j****" + j);

						if (isWebElementEnabled(By.xpath("//table[@class='days weeks']/tbody/tr[" + j

								+ "]/td/span[contains(text(),'" + eDate + "')]"))) {

							Actions act = new Actions(DriverManager.getDriver());

							WebElement ele1 = DriverManager.getDriver()
									.findElement(By.xpath("//table[@class='days weeks']/tbody/tr[" + j

											+ "]/td/span[contains(text(),'" + eDate + "')]"));

							// String color1=ele.getCssValue("color");

							// logger.info("eDate color*****"+color1);

							// if(color.equalsIgnoreCase("rgba(5, 109, 174,
							// 1)"))

							// {

							act.moveToElement(ele1).click().build().perform();

							// ele.click();

							break;

							// }

						}

					}

					break;

				}

			}

		}

	}

	public void SelectDateFromDatePicker(String objectReference, String selectDate)

			throws InterruptedException, ParseException {

		int selectdate = Integer.parseInt(selectDate.substring(0, 2));

		int selectmonth = Integer.parseInt(selectDate.substring(3, 5));

		int selectyear = Integer.parseInt(selectDate.substring(6, 10));

		int yeardifference = Integer.parseInt(this.getCurrentDate().substring(6, 10)) - selectyear;

		// Select Year

		if (yeardifference > 0) {

			this.click(objectReference);

			this.click("BasicInfo_Select_Year");

			if (DriverManager.getDriver()

					.findElements(By

							.xpath("//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

					.size() > 0

					&& DriverManager.getDriver()

							.findElement(By.xpath(

									"//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

							.isDisplayed()) {

				DriverManager.getDriver().findElement(

						By.xpath("//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

						.click();

			} else {

				for (int i = 0; i < (Math.abs(yeardifference) / 12); i++) {

					if (isWebElementEnabled("BasicInfo_Select_Previousbutton")) {

						this.click("BasicInfo_Select_Previousbutton");

						Thread.sleep(1500);

					}

				}

				DriverManager.getDriver().findElement(

						By.xpath("//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

						.click();

				Thread.sleep(1000);

			}

		} else if (yeardifference < 0) {

			this.clickByJS(objectReference);

			this.clickByJS("BasicInfo_Select_Year");

			if (DriverManager.getDriver()

					.findElements(By

							.xpath("//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

					.size() > 0

					&& DriverManager.getDriver()

							.findElement(By.xpath(

									"//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

							.isDisplayed()) {

				DriverManager.getDriver().findElement(

						By.xpath("//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

						.click();

			} else {

				for (int i = 0; i < (Math.abs(yeardifference) / 12); i++) {

					if (isWebElementEnabled("BasicInfo_Select_Nextbutton")) {

						this.click("BasicInfo_Select_Nextbutton");

						Thread.sleep(1500);

					}

				}

				DriverManager.getDriver().findElement(

						By.xpath("//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

						.click();

				Thread.sleep(1000);

			}

		} else {

			this.click(objectReference);

			this.click("BasicInfo_Select_Year");

			// logger.debug("Date Selected : " +
			// Integer.parseInt(selectDate.substring(6, 10)));

			DriverManager.getDriver().findElement(

					By.xpath("//span[contains(text(),'" + Integer.parseInt(selectDate.substring(6, 10)) + "')]"))

					.click();

			Thread.sleep(1000);

		}

		dateMap1();

		// Select Month

		DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'" + dateref.get(selectmonth) + "')]"))
				.click();

		// Select Date

		List<WebElement> rows = DriverManager.getDriver().findElements(

				By.xpath("//table[@class='days weeks']/tbody//td/span[contains(text(),'" + selectdate + "')]"));

		for (WebElement webElement : rows) {

			if (webElement.isEnabled() && webElement.getCssValue("color").equalsIgnoreCase("rgba(5, 109, 174, 1)")) {

				webElement.click();

				break;

			}

		}

	}

	public String getToday() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date curdate = new Date();

		String date = sdf.format(curdate);

		String[] dt = date.split("/");

		int datetmp = Integer.parseInt(dt[0]);

		if (datetmp <= 9) {

			String tmp[] = dt[0].split("0");

			dt[0] = tmp[1];

		}

		return dt[0];

	}

	public void uploadFile(String filePath) throws AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(2000);
		String fileloc = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\testDataResources\\testData\\Downloads\\";
		StringSelection stringSelection = new StringSelection(fileloc + filePath);
		robot.setAutoDelay(2000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
		robot.setAutoDelay(3500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(3500);
		robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// robot.setAutoDelay(3500);
	}

	// public void SaveFile() throws AWTException {

	// Robot robot = new Robot();

	// robot.setAutoDelay(1000);

	// robot.keyPress(KeyEvent.VK_ALT);

	// robot.keyPress(KeyEvent.VK_S);

	// robot.keyRelease(KeyEvent.VK_S);

	// robot.keyRelease(KeyEvent.VK_ALT);

	// robot.setAutoDelay(2000);

	// }

	// public void scrollDown() {

	// JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();

	// jse.executeScript("window.scrollBy(0,1000)");

	// }

	// public void scrollUp() {

	// JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();

	// jse.executeScript("window.scrollBy(0,-250)", "");

	// }

	// public String osdetails() {

	// String realarch = System.getenv("PROCESSOR_ARCHITECTURE").endsWith("64")

	// || System.getenv("PROCESSOR_ARCHITEW6432") != null

	// && System.getenv("PROCESSOR_ARCHITEW6432").endsWith("64") ? "64" : "32";

	// realarch = System.getProperty("os.name") + " " + realarch + "-Bit";

	// return realarch;

	// }

	// public void waitExplicitly() {

	// try {

	// Thread.sleep(3000);

	// } catch (InterruptedException e) {

	// logger.error("Error: ", e);

	// }

	// }

	// public void isFileDownloaded(String downloadPath, String fileName) {

	// File f = new File(downloadPath + "\\" + fileName);

	// if (f.exists() && !f.isDirectory()) {

	// logger.info(fileName + " is downloded in the local system");

	// logger.info(fileName + " is downloded in the local system");

	// } else {

	// logger.error(fileName + " is not downloded in the local system");

	// logger.error(fileName + " is not downloded in the local system");

	// Assert.fail();

	// }

	// }

	public boolean selectRadioButton(String objectReference, String value) {
		boolean elementenabled = false;
		try {
			List<WebElement> options = DriverManager.getDriver().findElement(getLocator(objectReference))
					.findElements(By.xpath("./md-radio-button"));
			for (WebElement ele : options) {
				if (ele.getAttribute("value").equalsIgnoreCase(value)) {
					if (!ele.isEnabled()) {
						elementenabled = true;
						if (!(ele.isSelected())) {
							ele.click();
							break;
						}
					}
					// else if (ele.isSelected())

					// logger.info("By default " + ele.getAttribute("value") + "
					// is selected");

				}

			}
		} catch (Exception e) {
		}

		return elementenabled;

	}

	public void dummy(String objectReference, String value) {

		String ele = "";

		try {

			moveToElement(objectReference);

			clickByJS(objectReference);

			List<WebElement> menus = DriverManager.getDriver().findElements(By.xpath("//mat-option"));

			for (WebElement webElement : menus) {

				// logger.info(webElement.getAttribute("value"));

				if (value.equalsIgnoreCase(webElement.getAttribute("value"))) {

					try {

						WebElement elem = webElement.findElement(By.xpath("./span"));

						((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", elem);

					} catch (Exception e) {

						try {

							e.printStackTrace();

							webElement.click();

						} catch (Exception e1) {

							// logger.error("Error: ", e);

							ele = "//mat-option[@value='" + webElement.getAttribute("value") + "']";

							DriverManager.getDriver().findElement(By.xpath(ele));

							// logger.error("Error: ", e);

						}

						// logger.error("Error: ", e);

					}

					break;

				}

			}

		} catch (Exception e) {

			// logger.error("Error: ", e);

			// Assert.fail();

		}

	}

	public String encodeFileToBase64Binary(File file) throws IOException {

		String encodedfile = null;
		return encodedfile;

		// return encodedfile;

	}

	/*
	 * @SuppressWarnings({ "deprecation" })
	 * 
	 * public void InternetDriver() {
	 * 
	 * 
	 * 
	 * try {
	 * 
	 * Thread.sleep(10000);
	 * 
	 * DesiredCapabilities ie_cap = DesiredCapabilities.internetExplorer();
	 * 
	 * System.setProperty("webdriver.ie.DriverManager.getDriver()",
	 * 
	 * System.getProperty("user.dir") +
	 * "/src/test/resources/drivers/IE_32bit/IEDriverServer.exe");
	 * 
	 * System.setProperty("webdriver.ie.DriverManager.getDriver()",
	 * "C:\\Drivers\\IEDriverServer_Win32_3.11.0\\IEDriverServer.exe");
	 * 
	 * ie_cap.setCapability("ignoreProtectedModeSettings", true);
	 * 
	 * ie_cap.setCapability("ie.ensureCleanSession", true);
	 * 
	 * ie_cap.setCapability(InternetExplorerDriver.
	 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	 * 
	 * ie_cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
	 * 
	 * ie_cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP,
	 * true);
	 * 
	 * ie_cap.setCapability("enablePersistentHover", true);
	 * 
	 * ie_cap.setCapability("ignoreZoomSetting", true);
	 * 
	 * DriverManager.getDriver() = new InternetExplorerDriver(ie_cap);
	 * 
	 * } catch (InterruptedException e) {
	 * 
	 * // TODO Auto-generated catch block
	 * 
	 * logger.error("Error: ", e);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void CloseIEBrowserDriver() {
	 * 
	 * try {
	 * 
	 * Runtime.getRuntime().exec(
	 * "taskkill /f /fi 'pid get 0' /im IEDriverServer.exe");
	 * 
	 * Runtime.getRuntime().exec("taskkill /f /fi 'pid get 0' /im iexplore.exe"
	 * );
	 * 
	 * Runtime.getRuntime().exec(
	 * "RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 'pid get 0'");
	 * 
	 * } catch (IOException e) {
	 * 
	 * // TODO Auto-generated catch block
	 * 
	 * logger.error("Error: ", e);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * private void ChromeDriver() {
	 * 
	 * System.setProperty("webdriver.chrome.DriverManager.getDriver()",
	 * "C:\\Drivers\\Chrome\\chromedriver.exe");
	 * 
	 * ChromeOptions option = new ChromeOptions();
	 * 
	 * option.setExperimentalOption("useAutomationExtension", false);
	 * 
	 * option.addArguments("--start-maximized");
	 * 
	 * DriverManager.getDriver() = new ChromeDriver(option);
	 * 
	 * System.setProperty("webdriver.chrome.DriverManager.getDriver()",
	 * 
	 * System.getProperty("user.dir") +
	 * "/src/test/resources/drivers/Chrome/chromedriver.exe");
	 * 
	 * Proxy proxy = new Proxy();
	 * 
	 * proxy.setHttpProxy("myhttpproxy:3337");
	 * 
	 * ChromeOptions option = new ChromeOptions();
	 * 
	 * option.setExperimentalOption("useAutomationExtension", false);
	 * 
	 * option.addArguments("--start-maximized");
	 * 
	 * option.setCapability("proxy", proxy);
	 * 
	 * DriverManager.getDriver() = new ChromeDriver(option);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void CloseChromeDriver() {
	 * 
	 * try {
	 * 
	 * Runtime.getRuntime().exec(
	 * "taskkill /f /fi 'pid get 0' /im chromedriver.exe");
	 * 
	 * Runtime.getRuntime().exec("taskkill /f /fi 'pid get 0' /im chrome.exe");
	 * 
	 * } catch (IOException e) {
	 * 
	 * // TODO Auto-generated catch block
	 * 
	 * logger.error("Error: ", e);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 */

	public void gotoEndAndDelete(String objectReference)

	{

		try

		{

			By locator = getLocator(objectReference);

			DriverManager.getDriver().findElement(locator).sendKeys(Keys.END);

			DriverManager.getDriver().findElement(locator).sendKeys(Keys.SHIFT, Keys.HOME);

			DriverManager.getDriver().findElement(locator).sendKeys(Keys.DELETE);

		}

		catch (Exception ex)

		{

			// logger.error("Error: ", ex);

		}

	}

	@SuppressWarnings("null")

	public String enterValuesCopy(String objectReference, int choice, String value) {
		boolean flag = false;
		String returnValue = "Not returned!!!";
		WebElement ele = DriverManager.getDriver().findElement(getLocator(objectReference));
		try {
			loadObjects(objectReference.split("_")[0].toLowerCase());
		} catch (FileNotFoundException e) {
			// logger.error("Error: ", e);
		} catch (IOException e) {
			// logger.error("Error: ", e);
		} catch (ParseException e) {
			// logger.error("Error: ", e);
		}
		By locator = getLocator(objectReference);
		moveToElement(locator);
		if (choice == 1) {
			if (value != null || !(value.equalsIgnoreCase(""))) {
				waitForPresence(locator);
				((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].value = arguments[1];",
						ele, value);
				flag = true;
			}
		} else {
			if (value != null || !(value.equalsIgnoreCase(""))) {
				waitForPresence(locator);
				DriverManager.getDriver().findElement(locator).sendKeys(value);
				// ((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].value
				// = arguments[1];",ele,copyValues);
				flag = false;
			}
		}
		return value;
	}

	public String enterValuesEmpty(String objectReference, String value) {

		try {

			loadObjects(objectReference.split("_")[0].toLowerCase());

		} catch (FileNotFoundException e) {

			// logger.error("Error: ", e);

		} catch (IOException e) {

			// logger.error("Error: ", e);

		} catch (ParseException e) {

			// logger.error("Error: ", e);

		}

		// By locator = getLocator(objectReference);

		// moveToElement(locator);

		if (value != null || !(value.equalsIgnoreCase(""))) {

			if (value.contains("Citi"))

			{

				// DriverManager.getDriver().findElement(locator).clear();

			}

			else

			{

				if (objectReference.contains("merchmaint_stores_StoreAddress"))

				{

					// waitForPresence(locator);

					// logger.info("Empty values: "+objectReference);

					// DriverManager.getDriver().findElement(locator).sendKeys(Keys.SHIFT,Keys.HOME);

					// DriverManager.getDriver().findElement(locator).sendKeys(Keys.BACK_SPACE);

				}

				else

				{

					// waitForPresence(locator);

					// logger.info("Empty values: "+objectReference);

					// DriverManager.getDriver().findElement(locator).sendKeys(Keys.CONTROL,"A");

					// DriverManager.getDriver().findElement(locator).sendKeys(Keys.BACK_SPACE);

				}

			}

			//

			// DriverManager.getDriver().findElement(locator).sendKeys(value);

			// DriverManager.getDriver().manage().timeouts().implicitlyWait(1,
			// TimeUnit.SECONDS);

			// logger.info(value);

			// DriverManager.getDriver().findElement(locator).sendKeys()

			// }

			// return value;

		}

		// @SuppressWarnings("null")

		// public String enterValuesHTUSteps( String objectReference, String
		// value) {

		// By locator=By.xpath(objectReference);

		// moveToElement(locator);

		// gotoEndAndDelete(locator);

		if (value != null || !(value.equalsIgnoreCase(""))) {

			// waitForPresence(locator);

			// DriverManager.getDriver().findElement(locator).sendKeys(value);

		}
		return null;

		// }

		// return value;

	}

	public void gotoEndAndDelete(By locator)

	{

		try

		{

			DriverManager.getDriver().findElement(locator).sendKeys(Keys.END);

			DriverManager.getDriver().findElement(locator).sendKeys(Keys.SHIFT, Keys.HOME);

			DriverManager.getDriver().findElement(locator).sendKeys(Keys.DELETE);

		}

		catch (Exception ex)

		{

			ex.printStackTrace();

		}

	}

	// public boolean fieldValidation(By locator, String fieldtype, String
	// supports, int size) {

	// boolean flag = false, success = false;

	// String value = "";

	// String val="";

	// value=getElementText(locator);

	// switch(fieldtype.toLowerCase().replace(" ", " ")) {

	// case "numeric":

	// if(value.matches("\\D")){}

	// Assert.fail("Value contains Alphabets or Special characters");

	// else flag = true;

	// break;

	// case "alphanumeric":

	// if(value.matches("\\D"))

	// Assert.fail("Value contains Special Characters");

	// else flag = true;

	//// break;

	// case "characters":

	// if(value.matches("\\d") || value.matches("[^a-zA-Z]"))

	// Assert.fail("Value contains Numbers or Special characters");

	// else flag = true;

	// break;

	// case "alphanumeric&specialcharacters":

	// flag=true;

	// break;

	// case "specialcharacters":

	// val = value.replaceAll("[a-zA-Z0-9]", "");

	// if(val.length()>0)

	// flag = true;

	// else

	// {

	// logger.info("Test Data doesn't have special characters");

	// Assert.fail("Value doesn't support specialcharacters / Test Data doesn't
	// have special characters");

	// }

	// }

	// switch(supports.toLowerCase().replace(" ", "")) {

	// case "upto":

	// if(flag && size>=value.length()) {

	// success = true;

	// }

	// break;

	// case "exact":

	// if(flag && size==value.length()) {

	// success = true;

	// }

	// break;

	// case "morethan":

	// if(flag && size<=value.length()) {

	// success = true;

	// }

	// break;

	// }

	// return (success && flag);

	// }

	// }}

}
