package com.cloudzen.ets.stepdef;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cloudzen.ets.utils.ConfigFileReader;
import com.cloudzen.ets.utils.DriverManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class LoginSteps {

	private static final WebElement title = null;
	private static final WebElement keyAttributesMenu = null;
	private static final Actions actions3 = null;
	private static final WebElement fileUploaded = null;
	DriverManager dm = new DriverManager();
	ConfigFileReader cfgreader = new ConfigFileReader();
	String currentUser = "";

	@Given("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(DataTable usercredentials) throws Throwable {
		List<Map<String, String>> list = usercredentials.asMaps(String.class, String.class);
		if(currentUser.equals("")){
			System.out.println(list.get(0).get("Username"));
			System.out.println(list.get(0).get("Password"));
			currentUser = list.get(0).get("Username");
			this.loginToApp(list.get(0).get("Username"), list.get(0).get("Password"));
		}else if (!currentUser.equalsIgnoreCase(list.get(0).get("Username"))) {
			currentUser = list.get(0).get("Username");
			this.logout();
			this.loginToApp(list.get(0).get("Username"), list.get(0).get("Password"));
		}
	}

	public void loginToApp(String userName, String password) throws InterruptedException {
		if (cfgreader.getEnvironment().equalsIgnoreCase("Dev")) {
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='userName']")).clear();
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='userName']")).sendKeys(userName);
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).clear();
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
			DriverManager.getDriver().findElement(By.xpath("//span[text()='LOGIN']")).click();
			Thread.sleep(30000);
		} else if (cfgreader.getEnvironment().equalsIgnoreCase("Test")) {
			DriverManager.getDriver().findElement(By.id("userNameInput")).clear();
			DriverManager.getDriver().findElement(By.id("userNameInput")).sendKeys(userName);
			DriverManager.getDriver().findElement(By.id("passwordInput")).clear();
			DriverManager.getDriver().findElement(By.id("passwordInput")).sendKeys(password);
			DriverManager.getDriver().findElement(By.xpath("//span[text()='Sign in']")).click();
			Thread.sleep(5000);
		}
		try {
			String Title = DriverManager.getDriver().getTitle(); // trade
																	// browser
			if (Title.equalsIgnoreCase("Trade Browser")) {
				System.out.println("login success");
			} else if (DriverManager.getDriver().getTitle().contains("Login")) {
				WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'login')]")));
				WebElement errormsg = DriverManager.getDriver()
						.findElement(By.xpath("//span[contains(text(),'This is your login attempt')]"));
				if (errormsg.isDisplayed()) {
					System.out.println("dshgfj");
				}
			} else if (DriverManager.getDriver().findElement(By.xpath("///div[@class='ets-login--error']/span"))
					.isDisplayed()) {
				System.out.println(" login failed ");
			} else {
				System.out.println("User is locked ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'login')]")));
			WebElement errormessage = DriverManager.getDriver()
					.findElement(By.xpath("//div[@class='ets-login--error']/span"));
			System.out.println("login failed " + errormessage.getText());
		}
	}
	
	public void logout(){
	
		WebElement DropDownicon = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-shell--toolbar-logo']//following::mat-icon[@class='ets-shell--toolbar-avatar mat-icon notranslate material-icons mat-icon-no-color']"));
		DropDownicon.click();
		
	}
}
