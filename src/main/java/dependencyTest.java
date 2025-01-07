import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// Timeout
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class dependencyTest {

	public static void main(String[] args) {
        // Set up ChromeDriver path 
        System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Create a scheduled executor with a single thread
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        try {
            // Open Google homepage
            driver.get("https://www.google.com");

            // Print the title to the console
            System.out.println("Page title is: " + driver.getTitle());
            // Locate the text area field
            WebElement searchBar = driver.findElement(By.tagName("textarea"));
            // Type text into toxtBox
            searchBar.sendKeys("Youtube");
            // Click Enter to search
            searchBar.sendKeys(Keys.RETURN);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after 5 seconds
            if (driver != null) {
                scheduler.schedule(() -> {
                	driver.quit();
                }, 5, TimeUnit.SECONDS);
            }
            scheduler.shutdown();
        }
    }
}
