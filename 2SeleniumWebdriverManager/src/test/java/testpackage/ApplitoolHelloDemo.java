package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class ApplitoolHelloDemo {

	private static WebDriver driver = null; 



	

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Note : Fixed error: added to remove chrome timeout error 0.100


		driver = new ChromeDriver();
		
		Eyes eye = new Eyes();
		eye.setApiKey("********************************************");
		try {
			
			//Start the test and set the browser viewport size to 800,600 
			eye.open(driver,"Hello Worl!","testName",new RectangleSize(800,600));
			
			//navigate to url
			driver.get("https://applitools.com/helloworld/?diff2");		

			//Visual checkpoint 1
			eye.checkWindow("Hello!");
			
			//Click on click btn
			driver.findElement(By.tagName("button")).click();
			
			//Visual checkpoint 2
			eye.checkWindow("Click!");
			
			//End
			eye.close();
		}
		finally {
			
			driver.quit();
			
			//
			eye.abortIfNotClosed();

		}
		
	}
}

