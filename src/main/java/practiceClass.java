import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class practiceClass {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void startUp() throws InterruptedException {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
	}
	
	// Multiple Assertions
	@Test
	public void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		String expectedDashboardUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actualDashboardUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(expectedDashboardUrl, actualDashboardUrl, 
				"Failed to navigate to dashboard page");
		
		WebElement settingsBtn = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//i[contains(@class, 'bi-gear-fill')]"))
		);
		
		Assert.assertTrue(settingsBtn.isDisplayed(), "Is not displayed");
		settingsBtn.click();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(5000);
		if(driver != null) {
			driver.quit();
		}
	}
}
