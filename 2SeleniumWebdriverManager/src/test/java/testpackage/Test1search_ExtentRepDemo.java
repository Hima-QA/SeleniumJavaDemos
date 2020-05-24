package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//Note: ExtentHtmlReporter has been deprecated. ExtentSparkReporter is the default reporter starting version 4 and it now supports SPA-style view by default.

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1search_ExtentRepDemo {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		// Start Reporter
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("demo_extentfile.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Product Search", "Searches for product from home page search");
        
        
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		
		test1.log(Status.INFO, "Starting the Test case");
		driver.get("http://automationpractice.com/index.php");
		test1.pass("Navigated to ecom-demo site:Automationpractise.com");
		
		
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		test1.pass("Entered text in search box");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		test1.pass("Clicked on search button");
		
		driver.close();

		driver.quit();
		test1.pass("Closed the browser");
		test1.pass("Test successfull");
		
		extent.flush();
	}

}


