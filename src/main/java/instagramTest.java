import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//Timeout
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class instagramTest {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.get("https://www.instagram.com");
			
			WebElement userNameBox = driver.findElement(By.xpath("//input[@aria-label='Phone number, username or email address']"));
			userNameBox.sendKeys("Jack2000k");
			
			WebElement passwordBox = driver.findElement(By.xpath("//input[@aria-label='Password']"));
			passwordBox.sendKeys("Beast1983*****");
			
			WebElement forgotPassword = driver.findElement(By.linkText("Forgotten your password?"));
			forgotPassword.click();
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement cantReset = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Can't reset your password?")));
			cantReset.click();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if (driver != null) {
                scheduler.schedule(() -> {
                	driver.quit();
                }, 5, TimeUnit.SECONDS);
            }
            scheduler.shutdown();
		}
	}
}
