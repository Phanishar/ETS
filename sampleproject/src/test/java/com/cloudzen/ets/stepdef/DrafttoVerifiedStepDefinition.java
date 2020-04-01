package com.cloudzen.ets.stepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Driver;
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

public class DrafttoVerifiedStepDefinition {

//	private static final WebElement title = null;
//	private static final WebElement keyAttributesMenu = null;
//	private static final Actions actions3 = null;
//	private static final WebElement fileUploaded = null;
//	private static final WebElement search_button = null;
//	private static final WebElement ST_FIX = null;
//	private static final WebElement startdate = null;
//	private static final WebElement curreny = null;
//	DriverManager dm = new DriverManager();
//	ConfigFileReader cfgreader = new ConfigFileReader();
//
//	 @Before
//	public void launchURL() {
//		System.setProperty("webdriver.chrome.DriverManager.getDriver()", cfgreader.getDriverPathforChrome());
//		dm.ChromeDriver();
//		DriverManager.getDriver().manage().window().maximize();
//		DriverManager.getDriver().manage().deleteAllCookies();
//
//		DriverManager.getDriver().get(cfgreader.getApplicationUrl());
//
//		if (cfgreader.getEnvironment().equalsIgnoreCase("Test")) {
//			if (DriverManager.getDriver().findElement(By.xpath("//button[@id='details-button']")).isDisplayed()) {
//				DriverManager.getDriver().findElement(By.xpath("//button[@id='details-button']")).click();
//				DriverManager.getDriver().findElement(By.id("proceed-link")).click();
//
//			}
//		} else {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		System.out.println(DriverManager.getDriver().getTitle());
//	}
//
//	 @After
//	@When("^Close the browser$")
//	public void close() {
//		DriverManager.getDriver().close();
//		DriverManager.getDriver().quit();
//		System.out.println("DriverManager.getDriver() closed");
//	}
//	 
//	
//
//	  @Then("^user click on \"(.*?)\" options$")
//  public static void user_click_on_Trade_capture_options(String arg1){
//	  DriverManager.getDriver().findElement(By.xpath("//*[text()=' TRADE CAPTURE ']")).click();
//  }
//  @And("^user selects the \"(.*?)\" option$")
//  public static void user_selects_the_Advance_option(String arg1){
//	  DriverManager.getDriver().findElement(By.xpath("//a[@href='/trade-browser(product:advance/new)']")).click();
//	  
//  }
//  @Then("^user validate new pop window \"(.*?)\" title is displayed$")
//	public static void user_validate_new_pop_window_title_is_displayed(String arg1) {
//		System.out.println(DriverManager.getDriver().getTitle());
//
//	}
//
//	// Product DropDown
//	@Then("^user clicks on 'Product' DropDown under \"(.*?)\"$")
//	public static void clicksonProduct(String Product) {
//	try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
//	WebElement DropDown_product = DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='product_code']"));
//	DropDown_product.click();
//	}
// 
//			
//    @Then("^user select \"(.*?)\" option$")
//    public static void user_select_Member_option(String arg1){
//    	 WebElement DropDown_Member= DriverManager.getDriver().findElement(By.xpath("//*[text()='Member']//parent::*//parent::*/preceding-sibling::mat-select"));
//    	  DropDown_Member.click();
//    }
//    @Then("^user select 'BANK OF NY'from 'Member' dropdown under \"(.*?)\"$")
//    public static void user_select_BANK_OF_NY(String BANKOFNY){
//    	DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//   DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'BANK OF NY')]")).click();
//   
//    
//    }
//  //Right click under Trading Events and then select +"Add"
//    @When("^user right click under \"(.*?)\" section$")
//    public static void rightclickunderTradingEvents(String TradingEvents){
//   Actions actions = new Actions(DriverManager.getDriver());
//   WebElement elementLocator = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-trading-events--grid']//div[@class='ag-center-cols-viewport']"));
//   actions.contextClick(elementLocator).perform();  
//    }
//    
//    //+Add
//    @Then("^user click on \\+Add option$")
//    public static void i_click_on_Add_option(){
//   DriverManager.getDriver().findElement(By.xpath("//div[@class='ag-menu ag-ltr']")).click();
//   DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    } 
//    
//    @Then("^user enter \"([^\"]*)\" in 'ValuationDate' text box under \"([^\"]*)\"$")
//    public static void i_enter_in__ValuationDate_text_box_under(String arg1, String arg2){
//   WebElement Val_date= DriverManager.getDriver().findElement(By.xpath("//*[text()='Valuation Date']/parent::*/parent::*/preceding-sibling::input[@aria-required='false']"));
//    Val_date.clear();
//    Val_date.sendKeys("05/17/2018");
//    }
//    @When("^user click on \"(.*?)\" button$")
//    public static void clickonCALCULATE(String CALCULATE){
//   Actions actions1 = new Actions(DriverManager.getDriver());
//   WebElement btn_calculate = DriverManager.getDriver().findElement(By.xpath("//*[text()=' CALCULATE ']/parent::*"));
//   actions1.click(btn_calculate).perform();
//
//    }
//    @Then("^user validate new row appears under \"(.*?)\"$")
//    public static void Analytics(String Analytics){  
//    }
//    @When("^user click on 'Save' under \"(.*?)\" menu$")
//    public static void clickonDots(String Dots){
//   WebElement keyAttributesMenu = DriverManager.getDriver().findElement(
//   By.xpath("//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
//   keyAttributesMenu.click();
//   Actions actions = new Actions(DriverManager.getDriver());
//   WebElement btn_save = DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Save')]"));
//   actions.click(btn_save).perform();
//   try {
//   Thread.sleep(15000);
//   } catch (InterruptedException e1) {
//   // TODO Auto-generated catch block
//   e1.printStackTrace();
//   }
//      //////////////////Verification done for SAVE ///////////////
//    }
//    @Then("^user validate status as \"(.*?)\"$")
//    public static void status(String status){
//    	 try {
//   		  Thread.sleep(55000);
//   		  } catch (InterruptedException e1) {
//   		  // TODO Auto-generated catch block
//   		  e1.printStackTrace();
//   		  }
//  	  
//    	 WebElement Status = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--status']"));
//  	 System.out.println(Status.getText());
//	  Assert.assertEquals(status,Status.getText());
//    }
//    
//    @And("^user verify the audit status as \"(.*?)\"$")
//    public static void userverifytheauditstatusas(String arg1){
//    	DriverManager.getDriver().findElement(By.xpath("//button[@class='ets-product-title--toolbar-version mat-icon-button mat-button-base mat-primary ng-star-inserted']")).getText();
//    }
//    
//    @When("^user click on 'Execute' under \"([^\"]*)\" menu$")
//    public void user_click_on_Execute_under_menu(String arg1){
//    	try {
//  		  Thread.sleep(15000);
//  		  } catch (InterruptedException e1) {
//  		  // TODO Auto-generated catch block
//  		  e1.printStackTrace();
//  		  }
//  	 
//   WebElement keyAttributesMenu = DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
//   keyAttributesMenu.click();
//   Actions actions = new Actions(DriverManager.getDriver());
//   WebElement btn_execute = DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Execute')]"));
//   actions.click(btn_execute).perform();
//   try {
//   Thread.sleep(20000);
//   } catch (InterruptedException e) {
//   // TODO Auto-generated catch block
//   e.printStackTrace();
//   }
//   
////////////////Verification done for Execute////////////
// 
//    }  
//      @When("^user click on 'ConfirmWMember' under \"(.*?)\" menu$")
//    public static void clickonConfirmWMember(String ConfirmWMember){
//    WebElement keyAttributesMenu2 = DriverManager.getDriver().findElement( By.xpath("//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
//    keyAttributesMenu2.click();
//    Actions actions= new Actions(DriverManager.getDriver());
//    WebElement btn_confirm = DriverManager.getDriver().findElement(By.xpath("//button[text()='ConfirmWMember']"));
//    actions.click(btn_confirm).perform();
//    try {
//    Thread.sleep(10000);
//    } catch (InterruptedException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//    }
//   
//  //////////////Verification done for ConfirmMember////////////
//      }
//  @And("^user clicks on 'verify'under \"(.*?)\" menu$")
//  public static void clicksonverify(String verify){
//	  WebElement keyAttributesMenu3 = DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
//	  keyAttributesMenu3.click();
//	  Actions actions= new Actions(DriverManager.getDriver());
//	    WebElement btn_verify = DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Verify')]"));
//	    actions.click(btn_verify).perform();
//  }
//    
//  @Given("^User enters Credentials to LogIn$")
//	public void user_enters_Credentials_to_LogIn(DataTable usercredentials) throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		// For automatic transformation, change DataTable to one of
//		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//		// E,K,V must be a scalar (String, Integer, Date, enum etc)
//		// List<List<String>> data = usercredentials.raw();
//		if (cfgreader.getEnvironment().equalsIgnoreCase("Dev")) {
//			List<Map<String, String>> list = usercredentials.asMaps(String.class, String.class);
//			for (int i = 0; i < list.size(); i++) {
//				// for (Map<String, String> data :
//				// usercredentials.asMaps(String.class, String.class)) {
//				DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='userName']")).clear();
//				DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='userName']"))
//						.sendKeys(list.get(i).get("Username"));
//				DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).clear();
//				DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='password']"))
//						.sendKeys(list.get(i).get("Password"));
//			
//				DriverManager.getDriver().findElement(By.xpath("//span[text()='LOGIN']")).click();
//
//				Thread.sleep(30000);
//				try{
//				String Title = DriverManager.getDriver().getTitle(); //trade browser
//				if(Title.equalsIgnoreCase("Trade Browser")){
//					System.out.println("login success");
//					 
//
//				}
//				
//				else if(DriverManager.getDriver().getTitle().contains("Login")){
//					WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
//              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'login')]")));
//              WebElement errormsg = DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'This is your login attempt')]"));
//              if(errormsg.isDisplayed()){
//              	System.out.println("dshgfj");
//              }
//              
//				}
//				else if (DriverManager.getDriver().findElement(By
//						.xpath("///div[@class='ets-login--error']/span"))
//					.isDisplayed() ){
//						
//
//					System.out.println(" login failed ");
//					
//				} 
//				else{
//					System.out.println("User is locked ");
//					
//				}}
//				catch (Exception e) {
//					// TODO: handle exception
//					WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
//	                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'login')]")));
//	              WebElement errormessage =  DriverManager.getDriver().findElement(By
//							.xpath("//div[@class='ets-login--error']/span"));
//						
//					System.out.println("login failed " +errormessage.getText());
//				}
//				
//			}
//			
//		} else if (cfgreader.getEnvironment().equalsIgnoreCase("Test")) {
//			List<Map<String, String>> list = usercredentials.asMaps(String.class, String.class);
//			for (int i = 0; i < list.size(); i++) {
//				// for (Map<String, String> data :
//				// usercredentials.asMaps(String.class, String.class)) {
//				DriverManager.getDriver().findElement(By.id("userNameInput")).clear();
//				DriverManager.getDriver().findElement(By.id("userNameInput")).sendKeys(list.get(i).get("Username"));
//				DriverManager.getDriver().findElement(By.id("passwordInput")).clear();
//				DriverManager.getDriver().findElement(By.id("passwordInput")).sendKeys(list.get(i).get("Password"));
//				;
//				DriverManager.getDriver().findElement(By.xpath("//span[text()='Sign in']")).click();
//
//				Thread.sleep(5000);
//
//			}
//		}
//  }
//  //Chat button
//  @Then("^user click \"(.*?)\" button$")
//  public static void userclickchatbutton(String arg1){
//	  Actions actions = new Actions(DriverManager.getDriver());
//		// DriverManager.getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//		WebElement chatbutton = DriverManager.getDriver().findElement(By.xpath("//mat-icon[contains(text(),'forum')]"));
//		actions.click(chatbutton).perform();
//  }
//  
//  @And("^user enters some \"(.*?)\" words below \"(.*?)\"$")
//  public static void userenterssometextwords(String arg){
//	  WebElement chatpop = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']"));
//	  if (chatpop.isDisplayed()) {
//			DriverManager.getDriver().switchTo().activeElement().findElement(By.xpath("//div[@class='ets-popover']"));
//			WebElement txtarea = DriverManager.getDriver().findElement(By.xpath("//textarea[@aria-required='false']"));
//			txtarea.sendKeys("hi hello how are you what are you doing and where are you going so becareful and soon recovery shoul");
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//  }
//  @And("^user click \"(.*?)\" option$")
//  public static void userclickattachmentoption(String arg1){
//	  WebElement chatpop = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']"));
//	  if (chatpop.isDisplayed()) {
//			DriverManager.getDriver().switchTo().activeElement().findElement(By.xpath("//div[@class='ets-popover']"));
//	  DriverManager.getDriver().findElement(By.xpath("//*[text()='attach_file']")).click();
//	  }
// 	  if (fileUploaded.isDisplayed()) {
//			System.out.println("file upload is succesfull");
//		} else {
//			System.out.println("file uplad is not successfull");
//		}
//	}
//
//	public static void uploadFile() throws AWTException {
//		StringSelection ss = new StringSelection("C:\\Users\\Lenovo\\Desktop\\ETS_Automation\\ETSMyQuery.xls");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//
//		// imitate mouse events like ENTER, CTRL+C, CTRL+V
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//	}
//	  
//	  
//	@And("^user click \"(.*?)\" options$")
//	public static void userclicksendoption(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//*[text()='send']")).click();
//	}
//	@And("^user verify \"(.*?)\" in the above chatbox$")
//	public static void userverifynotificationintheabovechatbox(String arg1){
//		 WebElement text = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-chat-item--message']"));
//		 WebElement attach = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-chat-item--attach']"));
//	}
//	@And("^user click \"(.*?)\" button to close window$")
//	public static void userclickclosebutton(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//*[text()='forum']")).click();
//	}
//	@And("^user clicks 'Search button'$")
//	public static void user_clicks_Search_button(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).click();
//	}
//	@And("^user enter \"(.*?)\" in \"(.*?)\" textbox$")
//	public static void user_enter_with_Date_in_Search_button(String value1,String value2){
//	DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).sendKeys("value");	
//		search_button.click();
//	}
//	@And("^user verify \"(.*?)\" with title$")
//	public static void user_verify_Advance_Date_with_title(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name']"));
//	}
//	@And("^user enter with \"(.*?)\" details in Search button$")
//	public static void user_enter_witth_Product_in_Search_button(String arg1){
//	DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).sendKeys("ST-FIX");
//		ST_FIX.click();
//	}
//	@And("^user verify \"(.*?)\" product with title$")
//	public static void user_verify_Advance_product_with_title(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name"));
//	}
//	@And("^user click 'search button' to close$")
//	public static void user_click_search_button_to_close(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).click();
//	}
//	@Then("^user clicks Key Attributes \"(.*?)\"$")
//	public static void user_clicks_key_Attributes_Start_Date(String arg1){
//	 DriverManager.getDriver().findElement(By.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']")).click();
//
//	}
//
//	@And("^user enter 'date' as \"(.*?)\"$")
//	public static void user_enter_date_as_operation(String operation){
//		DriverManager.getDriver().findElement(By.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']")).sendKeys("value");
//		startdate.click();
//	}
//	@And("^user verify 'date' in \"(.*?)\"$")
//	public static void user_verify_date_in_shortcuts(String shortcuts){
//	}
//	@And("^user click \"(.*?)\"$")
//	public static void user_click_Curreny_text_box(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']")).click();
//	}
//	@Then("^user enter shortcut \"(.*?)\"$")
//	public static void user_enter_shortcut_Currency_value(String arg1){
//		DriverManager.getDriver().findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']")).sendKeys("value");
//		curreny.click();
//		System.out.println("1000");
//	}
//	@Then("^user verify short cuts \"(.*?)\"$")
//	public static void user_verify_short_cuts_currencyvalue(String arg1){
//		
//	}
//
//	
//	
//	
//	
  }
  
  
	


