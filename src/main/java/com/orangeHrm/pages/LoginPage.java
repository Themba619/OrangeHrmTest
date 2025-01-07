package com.orangeHrm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.test.BaseTest; // Access driver
import com.report.ExtentReportUtils;


public class LoginPage {

	// username locator
	@FindBy(name = "username")
	WebElement usernameTextBox;
	
	// password locator
	@FindBy(name = "password")
	WebElement passwordTextBox;
	
	// login button
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginBtn;
	
	public LoginPage() {
		// The this keyword reference the object of the current class
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	Logger logger = LogManager.getLogger(LoginPage.class);
	
	public void loginToApplication(String username, String password) {
		usernameTextBox.sendKeys(username);
		logger.info("Username has been entered in username text box");
		ExtentReportUtils.addStep("Username has been entered");
		
		passwordTextBox.sendKeys(password);
		logger.info("Password has been entered in password text box");
		ExtentReportUtils.addStep("Password has been entered");
		
		loginBtn.click();
		logger.info("Submit button has been clicked");
		ExtentReportUtils.addStep("Submit button has been clicked");
	}
}
