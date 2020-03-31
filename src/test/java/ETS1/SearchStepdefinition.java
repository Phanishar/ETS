package ETS1;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
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

import Dataprovider.ConfigFileReader;
import Dataprovider.DriverManager;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SearchStepdefinition {

	private static final WebElement title = null;
	private static final WebElement keyAttributesMenu = null;
	private static final Actions actions3 = null;
	private static final WebElement Searchbutton = null;
	private static final WebElement Search = null;
	private static final WebElement ST_FIX = null;
	private static final WebElement startdate = null;
	private static final WebElement currency = null;
	private static final WebElement valuationdate = null;
	private static final WebElement curreny = null;
	DriverManager dm = new DriverManager();
	ConfigFileReader cfgreader = new ConfigFileReader();

@And("^user clicks 'Search button'$")
public static void user_clicks_Search_button(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).click();
}
@And("^user enter with \"(.*?)\" in Search button$")
public static void user_enter_with_Date_in_Search_button(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).sendKeys("2020-01-03-0001");
	Search.click();
	
}
@And("^user verify \"(.*?)\" with title$")
public static void user_verify_Advance_Date_with_title(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name']"));
}
@And("^user enter with \"(.*?)\" details in Search button$")
public static void user_enter_witth_Product_in_Search_button(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).sendKeys("ST-FIX");
	ST_FIX.click();
}
@And("^user verify \"(.*?)\" product with title$")
public static void user_verify_Advance_product_with_title(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name"));
}
@And("^user click 'search button' to close$")
public static void user_click_search_button_to_close(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']")).click();
}
@Then("^user clicks Key Attributes \"(.*?)\"$")
public static void user_clicks_key_Attributes_Start_Date(String arg1){
 DriverManager.getDriver().findElement(By.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']")).click();

}

@And("^user enter 'date' as \"(.*?)\"$")
public static void user_enter_date_as_operation(String operation){
	DriverManager.getDriver().findElement(By.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']")).sendKeys("0d");
	startdate.click();
}
@And("^user verify 'date' in \"(.*?)\"$")
public static void user_verify_date_in_shortcuts(String shortcuts){
}
@And("^user click \"(.*?)\"$")
public static void user_click_Curreny_text_box(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']")).click();
}
@Then("^user enter shortcut \"(.*?)\"$")
public static void user_enter_shortcut_Currency_value(String arg1){
	DriverManager.getDriver().findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']")).sendKeys("1k");
	curreny.click();
	System.out.println("1000");
}
@Then("^user verify short cuts \"(.*?)\"$")
public static void user_verify_short_cuts_currencyvalue(String arg1){
	
}

}
