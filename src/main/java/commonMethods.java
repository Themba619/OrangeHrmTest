
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		String url = driver.getCurrentUrl();
		System.out.println("Url: " + url);
		
		
		Thread.sleep(2000);
		
		WebElement searchInput = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchInput.sendKeys("lol");
		Thread.sleep(2000);
		searchInput.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();
		
//		Thread.sleep(2000);
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
//		try {
//			driver.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
	}
}
