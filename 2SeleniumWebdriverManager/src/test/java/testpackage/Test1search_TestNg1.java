package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1search_TestNg1 {
	//Notes: As we created maven project so we need to add the TestNg library through pom.xml file. Otherwise add to Project as BuildPath->Add Libraries->TestNg->Finish
	
	WebDriver driver = null;
	
	@BeforeTest
	public void launchBrowser(){
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
	
		driver.get("http://automationpractice.com/index.php");		
	}
	
	@Test
	public void searchProduct() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("All best sellers")).click();
		
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}

