
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class facebook {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://web.facebook.com/index.php/?_rdc=1&_rdr#");
		
		WebElement emailBox = driver.findElement(By.name("email"));
		
		boolean isDisplayed = emailBox.isDisplayed();
		
		boolean isEnabled = emailBox.isEnabled();
		
		if(isDisplayed && isEnabled) {
			try {
				emailBox.sendKeys("fakeEmail_23@gmail.com");
				
				String emailValue = emailBox.getAttribute("value");
				
				System.out.println("Entered email: " + emailValue);
				
				emailBox.clear();
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				scheduler.schedule(() -> {
					driver.quit();
				}, 5, TimeUnit.SECONDS);
			}
		}
	}
}
