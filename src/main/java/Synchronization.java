import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Synchronization {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		
		// Initialize WebDriver and WebDriverWait
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Open the browser
		driver.get("https://www.leagueoflegends.com/en-us");
		driver.manage().window().maximize();
	}
	
	@Test
	public void clickLink() throws InterruptedException{
		
		// Click on PLAY NOW link
		driver.findElement(By.linkText("PLAY NOW")).click();
		
		WebElement createAccount = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.linkText("CREATE ONE"))
		);
		
		if (createAccount.isDisplayed() && createAccount.isEnabled()) {
			System.out.println("Button is ready");
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", createAccount);
		}
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
