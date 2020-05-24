package testpackage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

//page imported
import pages.AutopractiseHSearchPage;

public class AutopractiseHSearchTest {
	
	 static WebDriver driver = null;
	
	public void launchBrowser(){
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
	
		driver.get("http://automationpractice.com/index.php");		
	}
	
	public void searchProduct() throws InterruptedException {
		Thread.sleep(2000);
			//driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		AutopractiseHSearchPage.textbox_Search(driver).sendKeys("Printed Dress");
		
			//driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		AutopractiseHSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		System.out.println("The page title is:" +driver.getTitle());		
		
	}
	

	public void CloseBrowser() {
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		AutopractiseHSearchTest ob = new AutopractiseHSearchTest();
		ob.launchBrowser();
		ob.searchProduct();
		ob.CloseBrowser();
		
	}
}

