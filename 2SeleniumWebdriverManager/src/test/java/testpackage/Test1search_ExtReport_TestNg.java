package testpackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1search_ExtReport_TestNg {
	
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	WebDriver driver = null;
	
	@BeforeSuite
	public void setup_Extent() {
		
		htmlReporter = new ExtentSparkReporter("demoTestng_extentfile.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@BeforeTest
	public void launchBrowser(){
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.get("http://automationpractice.com/index.php");	
	}
	
	@Test(priority=0)
	public void searchProduct() throws InterruptedException {
		test1 = extent.createTest("Product Search","Home Page Search Functionality Testing");
		test1.log(Status.INFO, "Starting the Test case");

		Thread.sleep(2000);
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		test1.pass("Entered Printed Dress for Product search");
		
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		test1.pass("Clicked on search button: Shows the search result");

		Thread.sleep(2000);
		driver.findElement(By.linkText("All best sellers")).click();
		test1.pass("Clicked on All Best Sellers button: Listed All Best sellers product");

	}
	
	@Test(priority=1)
	public void navigate() throws InterruptedException, IOException {
		Thread.sleep(2000);
		test1 = extent.createTest("Navigate"," Navigate to Google Home page");
		test1.log(Status.INFO," Starting Navigation test");
		
		driver.navigate().to("https://www.google.com/");
		String expectedTitle = "My Google";
        String actualTitle = driver.getTitle();
		System.out.println("The page title is:" +driver.getTitle());		
		
	        if(actualTitle.equalsIgnoreCase(expectedTitle))
			{
	        	test1.log(Status.PASS,"Navigated to Google");
	
			}
			else
			{
				test1.log(Status.FAIL,"Navigation to Google Failed");
	
			}
	      
	        
		Thread.sleep(3000);
		driver.navigate().back();
		//System.out.println("The page title is:" +driver.getTitle());		
}
	@Test(priority=2)
	public void logotest_AutopracEcom() {
		test1 = extent.createTest("Logo Test", "Checks for logo in automationpractise.com");
		test1.log(Status.INFO, "Starting the Logo Test");
		
		Boolean status = driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed();
		Assert.assertTrue(status);	
		
	}
	@AfterTest
	public void CloseBrowser() {
		driver.close();
		driver.quit();
		test1.pass("Test completed");
		
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	
	

}
