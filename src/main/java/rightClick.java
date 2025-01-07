import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class rightClick {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		
		
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		
		WebElement usernameBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input"))
		);
		
		System.out.println("Display status: " + usernameBox.isDisplayed());
		System.out.println("Enabled status: " + usernameBox.isEnabled());
		
		act.contextClick(usernameBox).build().perform();
	}
}
