import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class jsExecutorPrac {

	public static void main(String[] main) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		System.out.println(username.isDisplayed());
		System.out.println(username.isEnabled());
		
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		System.out.println(password.isDisplayed());
		System.out.println(password.isEnabled());
		
		((JavascriptExecutor) driver).executeScript("arguments[0].value='fake usernamesdasdas';", username);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='fakedssapassword';", password);
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement forgotBtn = wait.until(
				ExpectedConditions.elementToBeClickable(
						By.linkText("Forgotten your password?")
				)
		);
		System.out.println("forgot button: " + forgotBtn.isDisplayed());
		System.out.println("forgot button: " + forgotBtn.isEnabled());
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", forgotBtn);
		
	}
}
