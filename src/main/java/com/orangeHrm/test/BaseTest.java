package com.orangeHrm.test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.report.ExtentReportUtils;

public class BaseTest {

	public static WebDriver driver;
	
	@BeforeSuite
	public void initDriver() {
		ExtentReportUtils.SetUpReport();
		
		driver = new ChromeDriver(); // Launch google Chrome browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait 10 seconds
		driver.manage().window().maximize(); // Maximize window
		
		// Go to page URL
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
