package com.orangeHrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.test.BaseTest;
import com.report.ExtentReportUtils;

public class HomePage extends BaseTest{

	@FindBy(xpath = "//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']")
	WebElement menuBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
	WebElement adminLink;
	
	@FindBy(xpath = "//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	WebElement logoutDropDown;
	
	@FindBy(xpath = "//a[@href = '/web/index.php/auth/logout']")
	WebElement logoutBtn;
	
	public HomePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void accessMenu() {
		// menuBar.click();
		adminLink.click();
		ExtentReportUtils.addStep("Menu Bar clicked");
	}
	
	public void logout() {
		logoutDropDown.click();
		ExtentReportUtils.addStep("logout dropdown option clicked");
		logoutBtn.click();
		ExtentReportUtils.addStep("Logout button clicked");
	}
}
