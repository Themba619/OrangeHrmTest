
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class radioButtonPrac {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://brota-radio-animation.webflow.io/");
		Thread.sleep(3000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			// Wait for elements to be present in the DOM
			List<WebElement> radioBtns = wait.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@value='Radio']"))
			); 
			
			for(WebElement radio : radioBtns) {
				// Click on all the radio buttons
				if(!radio.isSelected()) {
					// Web site has animation and i didn't know how else to click 
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio);
					Thread.sleep(1000);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Thread.sleep(5000);
			driver.quit();
		}
		
	}
}
