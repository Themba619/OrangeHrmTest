
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class dropDownPrac {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.goto.com/meeting");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement featuresDrop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div/nav/ul/li[1]/a"))); 
		
		System.out.println("Display stasis of features: " + featuresDrop.isDisplayed());
		System.out.println("Enable stasis of features: " + featuresDrop.isEnabled());
		featuresDrop.click();
		
		
		try {
			List<WebElement> options = wait.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='sub-menu__link']"))
			);
			
			System.out.println("\n");
			
			for(WebElement option : options) {
				System.out.println("Display statis of option list item: " + option.isDisplayed());
				System.out.println("Enabled statis of option list item: " + option.isEnabled());
			}
			
			WebElement call = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Call in Meeting']")));
			System.out.println("Call drop down display statis: " + call.isDisplayed());
			System.out.println("Call drop down enabled statis: " + call.isEnabled());
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", call);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			Thread.sleep(4000);
			driver.quit();
		}
	}
}
