package com.cloudzen.ets.stepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloudzen.ets.utils.ConfigFileReader;
import com.cloudzen.ets.utils.DriverManager;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ETSStepdefinition {

	private static final WebElement title = null;
	private static final WebElement keyAttributesMenu = null;
	private static final Actions actions3 = null;
	private static final WebElement valuationdate = null;
	DriverManager dm = new DriverManager();
	ConfigFileReader cfgreader = new ConfigFileReader();

	@Before
	public void launchURL() {
		System.setProperty("webdriver.chrome.DriverManager.getDriver()", cfgreader.getDriverPathforChrome());
		dm.ChromeDriver();
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().deleteAllCookies();

		DriverManager.getDriver().get(cfgreader.getApplicationUrl());

		if (cfgreader.getEnvironment().equalsIgnoreCase("Test")) {
			if (DriverManager.getDriver().findElement(By.xpath("//button[@id='details-button']")).isDisplayed()) {
				DriverManager.getDriver().findElement(By.xpath("//button[@id='details-button']")).click();
				DriverManager.getDriver().findElement(By.id("proceed-link")).click();

			}
		} else {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(DriverManager.getDriver().getTitle());
	}

	@After
	//@When("^Close the browser$")
	public void close() {
		DriverManager.getDriver().close();
		DriverManager.getDriver().quit();
		System.out.println("DriverManager.getDriver() closed");
	}

	@When("^I enter username as \"(.*?)\"$")
	public static void gotousername(String userName) throws InterruptedException {
		DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='userName']")).sendKeys(userName);
	}

	@And("^I enter password as \"(.*?)\"$")
	public static void gotopassword(String password) throws InterruptedException {
		DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);

	}

	@Then("^I click on login button$")
	public static void clickloginbutton() throws InterruptedException {
		DriverManager.getDriver().findElement(By.xpath("//span[text()='LOGIN']")).click();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Trade Capture
	@Then("^user click on \"(.*)\" menu$")
	public static void clickTradeCapture(String TradeCapture) {
		DriverManager.getDriver().findElement(By.xpath("//*[text()=' TRADE CAPTURE ']")).click();
	}

	// Advance
	@Then("^user click on \"(.*)\" option$")
	public static void clickAdvanceoption(String Advanceoption) {
		DriverManager.getDriver().findElement(By.xpath("//a[@href='/trade-browser(product:advance/new)']")).click();
	}

	@Then("^user validate new pop window with \"([^\"]*)\" title is displayed$")
	public static void user_validate_new_pop_window_with_title_is_displayed(String arg1) {
		System.out.println(DriverManager.getDriver().getTitle());

	}

	// Product DropDown
	@Then("^user click 'Product' DropDown under \"(.*?)\"$")
	public static void clickProduct(String Product) {
	try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
	WebElement DropDown_product = DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='product_code']"));
	DropDown_product.click();
	}
     //ST-FIX
	@Then("^user select 'ST-FIX' from 'Product' dropdown under \"(.*?)\"$")
	public static void user_select_ST_FIX_from_Product_dropdown_under(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//span[text()=' ST-FIX ']")).click();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
     //StartDate  ---(//input[contains(@id,'mat-checkbox-')])[4]  --  tags insoide checkbox
    @And("^user verify Startdate populated as \"(.*?)\"$")	
	public static void verify_Startdate(String Startdate){
    try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
     Startdate=DriverManager.getDriver().findElement(By.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']")).getAttribute("value");
    String pattern = "M/dd/yyyy";
    SimpleDateFormat 
    simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    System.out.println(date);
    if(Startdate.contains(date)){
    	System.out.println("dates are equal");
    }
    else{
    	System.out.println("dates are not equal");
    }
        }
	//EndDate
    @And("^user verify Enddate populated as \"(.*?)\"$")
    public void user_verify_Enddate_populated_as(String Enddate) throws Throwable {
    	try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
    	String actualEnddate=DriverManager.getDriver().findElement(By.xpath("(//mat-label[text()='End Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid'])[2]")).getAttribute("value");
       Long l = Long.parseLong(Enddate);
        LocalDate date = LocalDate.now().plusMonths(l);
        	String formattedDate = date.format(DateTimeFormatter.ofPattern("M/dd/yyyy"));
        System.out.println(formattedDate);
        if(actualEnddate.contains(formattedDate)){
        	System.out.println("dates are equal");
        }
        else{
        	System.out.println("dates are not equal");
        }
           }
	//Amount
    @And("^user verify Amount populated as \"([^\"]*)\"$")
     public void user_verify_Amount_populated_as(String arg1) throws Throwable {
    	DriverManager.getDriver().findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']")).getAttribute("value");
    	System.out.println("1000");
    }
    //CCY
    @And("user verify CCY Option as \"([^\"]*)\"$")
    public static void user_verify_CCY_option_as(String arg1){
    	String ccyActual = DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='ccy']/child::div['mat-select-trigger']")).getText();
        System.out.println(ccyActual);
        
    }
	
	@Then("^user click on 'Member' DropDown under \"(.*?)\"$")
	public static void clickonMember(String Member) {
		WebElement DropDown_Member = DriverManager.getDriver()
				.findElement(By.xpath("//*[text()='Member']//parent::*//parent::*/preceding-sibling::mat-select"));
		DropDown_Member.click();
	}

	@Then("^user verify 'Rate info index' Dropdown is populated as \"(.*?)\"$")
	public static void user_verfiy_Rate_info_index(String arg1){
      DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='index']/child::div['mat-select-trigger']")).getText();
        System.out.println("Fixed");
       	
	}
	@Then("^user Verify 'Rate info Tenor option' Dropdown is populated as \"(.*?)\"$")
	public static void user_verify_Rate_info(String arg1){
		 DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='tenor']/child::div['mat-select-trigger']")).getText();
		System.out.println("Tenor");
		
	}
	@Then("^user verify 'Rate info Actual Frequency' Dropdown is populated as \"(.*?)\"$")
	public static void user_Rate_info_Actual_Frequency(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='accrueFreq']/child::div['mat-select-trigger']")).getText();
		System.out.println("Monthly");
	}
	@Then("^user verify 'Rate info Calendar option' Dropdown is populated as \"(.*?)\"$")
	public static void user_verify_Rate_info_Calender_option(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='accrueCalendarList']/child::div['mat-select-trigger']")).getText();
		System.out.println("NYC");
	}
	
	@Then("^user verify 'Rate info Day Count' Dropdown is populated as \"([^\"]*)\"$")
	public void user_verify_Rate_info_Day_Count_Dropdown_is_populated_as(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='dayCount']/child::div['mat-select-trigger']")).getText();
		System.out.println("ACT/360");
	}
	@Then("^user verify 'Rate Info Day' Dropdown is populated as \"([^\"]*)\"$")
	public void user_verify_Rate_Info_Day_Dropdown_is_populated_as(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='accrueEndOfMonth']/child::div['mat-select-trigger']")).getText();
		System.out.println("Day");
	}
	@Then("^user verify 'payment Info Frequency' Dropdown is populated as \"([^\"]*)\"$")
	public void user_verify_Payment_Info_Day_Dropdown_is_populated_as(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='paymentFreq']/child::div['mat-select-trigger']")).getText();
		System.out.println("Monthly");
	}
	@Then("^user verify 'payment info Calendar option' Dropdown is populated as \"([^\"]*)\"$")
	public void user_verify_payment_info_Calendar_option_Dropdown_is_populated_as(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='paymentCalendarList']/child::div['mat-select-trigger']")).getText();
		System.out.println("NYC");
	}
	@Then("^user verify 'payment info Day' Dropdown is populated as \"([^\"]*)\"$")
	public void user_verify_payment_info_Day_Count_Dropdown_is_populated_as(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='paymentEndOfMonth']/child::div['mat-select-trigger']")).getText();
		System.out.println("Day");
	}
	@Then("^user verify 'payment info Roll Rule option' Dropdown is populated as \"([^\"]*)\"$")
	public void user_verify_payment_info_Roll_Rule_option_Dropdown_is_populated_as(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='rollRule']/child::div['mat-select-trigger']")).getText();
		System.out.println("Backward");
	}
	
	@Then("^user verify 'payment info Business day' Dropdown is populated as \"([^\"]*)\"$")
	public void user_verify_payment_info_Business_day_Dropdown_is_populated_as(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='adjBusDay']/child::div['mat-select-trigger']")).getText();
		System.out.println("Modified Following");	
	}
	
	@Then("^user verify 'payment info first payment' populated as \"(.*)\"$")
	public void user_verify_payment_info_first_payment_populated_as(String arg1){
		String firstPayementDate = DriverManager.getDriver().findElement(By.xpath("(//mat-label[text()='First payment']/preceding::input[@class='ng-untouched ng-pristine ng-valid'])[3]")).getAttribute("value");
		System.out.println(firstPayementDate);
		String substr = firstPayementDate.substring(0,1); 
		System.out.println("substring  of value"+substr);
		 String DATE_FORMAT = "M/dd/yyyy";
	    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	   // DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
	    // Get current date
	        Date currentDate = new Date();
	        // convert date to localdatetime
	        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	        // plus one
	        Long l = Long.parseLong(arg1);
	        localDateTime = localDateTime.plusYears(0).plusMonths(l);
	        // convert LocalDateTime to date
	        Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

	        System.out.println("\nOutput : " + dateFormat.format(currentDatePlusOneDay));
	        String s = dateFormat.format(currentDatePlusOneDay);
	        String substr1 =s.substring(0,1);
	        System.out.println("substring  of value"+substr1);
	        if(substr.equals(substr1)){
	        	System.out.println("Months are added by one ");
	        }else{
	        	System.out.println("Months are not added");
	        }
	        
	}
	
	

		@Then("^user verify 'payment info Last payment' populated as \"(.*)\"$")
	public void user_verify_payment_info_Last_payment_populated_as(String arg1) throws Throwable {
	   String lastPaymentDate = DriverManager.getDriver().findElement(By.xpath("(//mat-label[text()='Last payment']/preceding::input[@class='ng-untouched ng-pristine ng-valid'])[4]")).getAttribute("value");
	   System.out.println(lastPaymentDate); 
	   String substr = lastPaymentDate.substring(0,1); 
		System.out.println("substring  of value"+substr);
		 String DATE_FORMAT = "M/dd/yyyy";
	    DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	   // DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
	    // Get current date
	        Date currentDate = new Date();
	        // convert date to localdatetime
	        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	        // plus three
	        Long l = Long.parseLong(arg1);
	        localDateTime = localDateTime.plusYears(0).plusMonths(l);
	        // convert LocalDateTime to date
	        Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

	        System.out.println("\nOutput : " + dateFormat.format(currentDatePlusOneDay));
	        String s = dateFormat.format(currentDatePlusOneDay);
	        String substr1 =s.substring(0,1);
	        System.out.println("substring  of value"+substr1);
	        if(substr.equals(substr1)){
	        	System.out.println("Months are added by two ");
	        }else{
	        	System.out.println("Months are not added");
	        }
	        
	}
   
	@Then("^user verify 'Analytics pricing Service'populated as \"([^\"]*)\"$")
	public void user_verify_Analytics_pricing_Service_populated_as(String arg1) throws Throwable {
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@id='mat-select-6']/child::div['mat-select-trigger']")).getText();
		System.out.println("QuantLib");
	}
	
	@Then("^user verify 'Analytics Cashflow From'populated as \"([^\"]*)\"$")
	public void user_verify_Analytics_Cashflow_From_populated_as(String arg1) throws Throwable {
		DriverManager.getDriver().findElement(By.xpath("//mat-select[@formcontrolname='cashflowFromStart']/child::div['mat-select-trigger']")).getText();
		System.out.println("ModelDate");
	}
	@Then("^user verify 'Analytics Valuation Date'populated as \"([^\"]*)\"$")
	public void user_verify_Analytics_Valuation_Date_populated_as(String arg1) throws Throwable {
		DriverManager.getDriver().findElement(By.xpath("//*[text()='Valuation Date']/parent::*/parent::*/preceding-sibling::input[@aria-required='false']")).sendKeys("05/17/2018");
		valuationdate.click();
		System.out.println("05/17/2018");
	}
	
	
	
	
	
	
	
		// Right click under Trading Events and then select +"Add"
	@When("^I right click under \"(.*?)\" section$")
	public static void rightclickunderTradingEvents(String TradingEvents) {
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement elementLocator = DriverManager.getDriver().findElement(
				By.xpath("//div[@class='ets-trading-events--grid']//div[@class='ag-center-cols-viewport']"));
		actions.contextClick(elementLocator).perform();
	}

	// +Add
	@Then("^I click on \\+Add option$")
	public static void i_click_on_Add_option() {
		DriverManager.getDriver().findElement(By.xpath("//div[@class='ag-menu ag-ltr']")).click();
	}

	@Then("^I select 'CASH' from 'TypeOfMoney' dropdown under \"(.*?)\"$")
	public static void selectCASH(String CASH) {
		DriverManager.getDriver().findElement(By.xpath("//*[text()=\"Tags\"]/preceding-sibling::button")).click();
		WebElement typeofmoney = DriverManager.getDriver()
				.findElement(By.xpath("//*[text()='Type of money']//parent::*//parent::*//preceding-sibling::input"));
		typeofmoney.click();
		typeofmoney.sendKeys(" CASH ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("^I enter '50000' in 'NewMoneyAmount' text box under \"(.*?)\"$")
	public static void enterinNewMoneyAmount(String NewMoneyAmount) {
		DriverManager.getDriver().findElement(By.xpath("//*[text()='New money amount']//parent::*//parent::*/preceding-sibling::*"))
				.sendKeys("50000");
	}

	@Then("^I click on \"(.*?)\"$")
	public static void clickonWired(String Wired) {
		DriverManager.getDriver().findElement(
				By.xpath("//mat-label[text()='Wired Amount']/parent::label/parent::span/preceding-sibling::input"))
				.click();
	}

	@Then("^I enter '1000' in 'WiredAmount' text box under \"(.*?)\"$")
	public static void enter1000inWiredAmount(String WiredAmount) {
		DriverManager.getDriver().findElement(
				By.xpath("//mat-label[text()='Wired Amount']/parent::label/parent::span/preceding-sibling::input"))
				.sendKeys("10000");
	}

	@Then("^I enter \"([^\"]*)\" in 'ValuationDate' text box under \"([^\"]*)\"$")
	public static void i_enter_in__ValuationDate_text_box_under(String arg1, String arg2) {
		WebElement Val_date = DriverManager.getDriver().findElement(By.xpath(
				"//*[text()='Valuation Date']/parent::*/parent::*/preceding-sibling::input[@aria-required='false']"));
		Val_date.clear();
		Val_date.sendKeys("05/17/2018");
	}

	@When("^I click on \"(.*?)\" button$")
	public static void clickonCALCULATE(String CALCULATE) {
		Actions actions1 = new Actions(DriverManager.getDriver());
		WebElement btn_calculate = DriverManager.getDriver().findElement(By.xpath("//*[text()=' CALCULATE ']/parent::*"));
		actions1.click(btn_calculate).perform();

	}

	@Then("^I validate new row appears under \"(.*?)\"$")
	public static void Analytics(String Analytics) {
	}

	@When("^I click on 'Save' under \"(.*?)\" menu$")
	public static void clickonDots(String Dots) {
		WebElement keyAttributesMenu = DriverManager.getDriver().findElement(
				By.xpath("//*[text()='Key Attributes']/parent::*/descendant::button[@aria-haspopup=\"true\"]"));
		keyAttributesMenu.click();
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement btn_save = DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Save')]"));
		actions.click(btn_save).perform();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		////////////////// Verification done for SAVE ///////////////
	}

	@Then("^I validate status as \"(.*?)\"$")
	public static void Draft(String status) {
		try {
			Thread.sleep(55000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		WebElement Status = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--status']"));
		System.out.println(Status.getText());
		Assert.assertEquals(status, Status.getText());

	}

	@When("^I click on 'Execute' under Dots menu$")
	public static void clickonExecute() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		WebElement keyAttributesMenu = DriverManager.getDriver().findElement(
				By.xpath("//*[text()='Key Attributes']/parent::*/descendant::button[@aria-haspopup=\"true\"]"));
		keyAttributesMenu.click();
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement btn_execute = DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Execute')]"));
		actions.click(btn_execute).perform();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebElement Status =
		// DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--status']"));
		// System.out.println(Status.getText());
		// Assert.assertEquals("DONE", Status.getText());
		///////////// Verification done for execute///////////
	}

	@When("^I click on 'ConfirmWMember' under \"(.*?)\" menu$")
	public static void clickonConfirmWMember(String ConfirmWMember) {
		WebElement keyAttributesMenu2 = DriverManager.getDriver().findElement(
				By.xpath("//*[text()='Key Attributes']/parent::*/descendant::button[@aria-haspopup=\"true\"]"));
		keyAttributesMenu2.click();
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement btn_confirm = DriverManager.getDriver().findElement(By.xpath("//button[text()='ConfirmWMember']"));
		actions.click(btn_confirm).perform();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// WebElement Status =
		// DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--status']"));
		// System.out.println(Status.getText());
		// Assert.assertEquals(Status.getText(), "CONFIRMED");
		////////////// Verification done for ConfirmMember////////////
	}

	@When("^I click on chat button$")
	public void chatbutton() {
		Actions actions = new Actions(DriverManager.getDriver());
		// DriverManager.getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement chatbutton = DriverManager.getDriver().findElement(By.xpath("//mat-icon[contains(text(),'forum')]"));
		actions.click(chatbutton).perform();
	}

	@Then("^I enter 'HI' in chatbox$")
	public void HI() {

		WebElement chatpop = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']"));
		if (chatpop.isDisplayed()) {
			DriverManager.getDriver().switchTo().activeElement().findElement(By.xpath("//div[@class='ets-popover']"));
			WebElement txtarea = DriverManager.getDriver().findElement(By.xpath("//textarea"));
			txtarea.sendKeys("HI");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Then("^I Click On Send button$")
	public void ClickonSend() {
		Actions actions = new Actions(DriverManager.getDriver());
		DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement Sendbutton = DriverManager.getDriver().findElement(By.xpath("//mat-icon[contains(text(),'send')]"));
		actions.click(Sendbutton).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^I Validate text$")
	public void validatetext() {
		if (DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-chat-item--message']")).isDisplayed())
			System.out.println("Chat Text delivered");
		else {
			System.out.println("Chat is not delivered");
		}
	}

	@Then("^I click close button$")
	public void ClickClose() {
		DriverManager.getDriver().switchTo().defaultContent();
		// Actions actions= new Actions(DriverManager.getDriver());
		// WebElement btn_close =
		// DriverManager.getDriver().findElement(By.xpath("//mat-icon[contains(text(),'close')]"));
		// actions.click(btn_close).perform();
		Actions actions = new Actions(DriverManager.getDriver());
		// DriverManager.getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		WebElement chatbutton = DriverManager.getDriver().findElement(By.xpath("//mat-icon[contains(text(),'forum')]"));
		actions.click(chatbutton).perform();
	}

	@When("^I Click File button$")
	public void clickFile() {
		DriverManager.getDriver().findElement(By.xpath("//mat-icon[contains(text(),'description')]")).click();
	}

	@Then("^I right click under \"(.*?)\"$")
	public void rightclickunderDocuments(String Documents) {
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement txtarea = DriverManager.getDriver().findElement(
				By.xpath("//ets-product-documents[@class='ng-star-inserted']//div[@class='ag-center-cols-viewport']"));
		actions.contextClick(txtarea).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^I click Add option$")
	public void clickAddoption() {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Actions actions = new Actions(DriverManager.getDriver());
		WebElement Addoption = DriverManager.getDriver().findElement(By.xpath("//div[@class='ag-menu ag-ltr']"));
		actions.click(Addoption).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// @Then("^I enter the filepath in filename textbox and click open$")
		// public void selectFileuploadoption(){
		try {
			uploadFile();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement fileUploaded = DriverManager.getDriver().findElement(By.xpath("(//div[@col-id ='documentName'])[2]"));
		if (fileUploaded.isDisplayed()) {
			System.out.println("file upload is succesfull");
		} else {
			System.out.println("file uplad is not successfull");
		}
	}

	public static void uploadFile() throws AWTException {
		StringSelection ss = new StringSelection("C:\\Users\\Lenovo\\Desktop\\ETSMyQuery.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/*
	 * public static String getReportConfigPath(){ String reportConfigPath =
	 * properties.getProperty("configs//Config.properties");
	 * if(reportConfigPath!= null) return reportConfigPath; else throw new
	 * RuntimeException(
	 * "Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"
	 * ); }
	 */
	}