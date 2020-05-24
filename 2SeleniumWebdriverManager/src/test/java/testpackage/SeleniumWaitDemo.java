package testpackage;

//import java.time.Duration;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	private static WebDriver driver = null; 

	

	public static void SeleniumWaits() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Note : Fixed error: added to remove chrome timeout error 0.100
		driver = new ChromeDriver();
		//defined implicit wait of 10 seconds //default poll time of implicit wait is 250ms
		//Implicit wait is applicable for the entire session of browser
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Automation steps");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(10)); 		//Creating Explicit wait
		WebDriverWait wait  = new WebDriverWait(driver,10); 		//Creating Explicit wait

		// as deprecated tried so tried to add guava 29.0 jar via through pom.xml but didn't work at first, later found syntax-change from seleniumhq the Duration.ofSeconds when added it worked
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		driver.findElement(By.name("fsdf")).click();
		driver.close();
		driver.quit();
	}
	public static void main(String[] args) {
		SeleniumWaits();
		
	}
}

