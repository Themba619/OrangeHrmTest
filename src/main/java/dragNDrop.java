import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class dragNDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		try {
			WebElement dragMe = driver.findElement(By.id("draggable"));
			WebElement dropMe = driver.findElement(By.id("droppable"));
			
			System.out.println(dragMe.isDisplayed());
			System.out.println(dropMe.isDisplayed());
			
			action.dragAndDrop(dragMe, dropMe).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Thread.sleep(5000);
			driver.quit();
		}
	}
}
