
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mouseActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		
		try {
			
			WebElement doubleClick = driver.findElement(By.xpath("(//p[@ondblclick])[1]"));
			
			System.out.println(doubleClick.isDisplayed());
			System.out.println(doubleClick.isEnabled());
			
			act.doubleClick(doubleClick).perform();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Thread.sleep(5000);
			driver.quit();
		}
	}
}
