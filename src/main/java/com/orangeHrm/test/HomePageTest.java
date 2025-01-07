package com.orangeHrm.test;

import org.testng.annotations.Test;

import com.orangeHrm.pages.HomePage;

public class HomePageTest extends BaseTest{

	@Test
	public void logoutOfHomePage() throws InterruptedException {
		HomePage homePage = new HomePage();
		
		homePage.accessMenu();
		homePage.logout();
	}
}
