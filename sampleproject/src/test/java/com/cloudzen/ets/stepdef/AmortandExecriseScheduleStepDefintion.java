package com.cloudzen.ets.stepdef;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.DriverAction;
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

public class AmortandExecriseScheduleStepDefintion {
	
	 @Then("^user clicks on \"(.*?)\" option$")
	  public static void user_click_on_Trade_capture_option(String arg1){
		  DriverManager.getDriver().findElement(By.xpath("//*[text()=' TRADE CAPTURE ']")).click();
	  }
	  @Then("^user select the \"(.*?)\" option$")
	  public static void user_selects_the_Advance_option(String arg1){
		  DriverManager.getDriver().findElement(By.xpath("//a[@href='/trade-browser(product:advance/new)']")).click();
		  
	  }
	  @Then("^user validate new pop window with \"(.*?)\" title$")
		public static void user_validate_new_pop_window_with_title_is_displayed(String arg1) {
			System.out.println(DriverManager.getDriver().getTitle());

		}

		// Product DropDown
		@Then("^user clicks 'Product' DropDown under \"(.*?)\"$")
		public static void clickProduct(String Product) {
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		WebElement DropDown_product = DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='product_code']"));
		DropDown_product.click();
		}
	 
		 //ST-FIX
			@Then("^user selects 'ST-FIX' from 'Product' dropdown under \"(.*?)\"$")
			public static void user_select_ST_FIX_from_Product_dropdown_under(String arg1) {
				DriverManager.getDriver().findElement(By.xpath("//span[text()=' ST-FIX ']")).click();
				DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			}
	
	private static final WebElement value = null;
	@Then("^user click \"(.*?)\" option$")
	public static void userclickAddoption(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//div[@class='ag-menu ag-ltr']")).click();
	}
	
	//AmortSchedule with ST-FIX
	@Then("user click on userinfo \"(.*?)\"$")
	public static void user_click_on_userinfo_icon(String arg1){
		DriverManager.getDriver().findElement(By.xpath("//span[@class='mat-button-wrapper']/child::mat-icon[text()='info'][1]")).click();
		
	}
@Then("^user verify \"(.*?)\" screen is displayed$")
public static void userverifyAmortExcriseschedulescreenisdisplayed(String arg1){
	
}
@Then("^user click the Amort \"(.*?)\" Button$")
public static void userclicktheAmortgenerateButton(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[contains (text(),'GENERATE')][1]")).click();
}
@And("^user click \"(.*?)\" Execrise schedule$")
public static void userclickNotificationdateExecriseschedule(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Notification, days')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']")).click();

}
@And("^user enter some \"(.*?)\"$")
public static void userentersomevalue(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Notification, days')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']")).sendKeys(arg1);
	value.click();
}
@And("^user clicks \"(.*?)\"$")
public static void userclickscallput(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Call/Put')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']")).click();
}
@And("^user clicks \"(.*?)\" option")
public static void userclicksHolderoption(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'Option Holder')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']")).click();
}

@And("^user selects \"(.*?)\" option$")
public static void userselectsshortlongoption(String arg1){
	DriverManager.getDriver().findElement(By.xpath("")).click();
}

@Then("^user clicks on \"(.*?)\" button$")
public static void userclicksoncloseoption(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//button[@class='mat-icon-button mat-button-base']/following::mat-icon[text()='close'][2]")).click();
}
@Then("^user verify new \"(.*?)\"is populated$")
public static void userverifynewconfirmationwindowispopulated(String arg1){
	
}
@And("^user click the \"(.*?)\" button$")
public static void userclickthesavebutton(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),' YES ')]")).click();
}
@Then("^user verify \"(.*?)\" Icon button Grey to Orange$")
public static void userverifyAmortExecrisescheduleIconbuttonGreytoOrange(String arg1){
	
}
@And("^user selects \"(.*?)\" under emenu button$")
public static void userselectsPincolumnunderemenubutton(String Pincolumn){
	WebElement DropDown_pincolumn = DriverManager.getDriver().findElement(By.xpath("//Span[@class='ag-tab ag-tab-selected']"));
	DropDown_pincolumn.click();
}
@And("^user click \"(.*?)\" column")
public static void userclickPinTorightcolumn(String PinToright){
	DriverManager.getDriver().findElement(By.xpath("//Span[text() ='Pin Right']")).click();
}
@Then("^user click \"(.*?)\" button and click checkbox option$")
public static void userclickFilterbuttonandclickcheckboxoption(String filter){
WebElement DropDown_filter = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-exercise-toolbar-title']//following::mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color'][4]"));
	DropDown_filter.click();
}
@And("^user selects \"(.*?)\" in filter$")
public static void userslectedSingleormultiplecheckboxinfilter(String arg){
	DriverManager.getDriver().findElement(By.xpath("")).click();
}
}
