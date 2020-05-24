package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg_MultiBrowserTestDemo {
	//Notes: As we created maven project so we need to add the TestNg library through pom.xml file. Otherwise add to Project as BuildPath->Add Libraries->TestNg->Finish
	
	WebDriver driver = null;
	
	@Parameters("browserName") // to get the parameter named browserName we use this testng annatations and mention it in the Testng.xml file (testngMB.xml)
	@BeforeTest
	public void launchBrowser(String browserName){
		System.out.println("Browser Name is: "+browserName);
		System.out.println("Thread ID is :"+Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		
		//driver.get("http://automationpractice.com/index.php");		
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(4000);
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		
		
	}
	
	@AfterTest
	public void CloseBrowser() {
		System.out.println("Test Successfull");
		driver.quit();
	}

}

