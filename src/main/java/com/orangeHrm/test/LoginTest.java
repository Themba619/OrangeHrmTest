package com.orangeHrm.test;

import org.testng.annotations.Test;

import com.orangeHrm.pages.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void loginWithValidUsernameAndPassword() {
		LoginPage loginPage = new LoginPage();
		
		loginPage.loginToApplication("Admin", "admin123");
	}
}
