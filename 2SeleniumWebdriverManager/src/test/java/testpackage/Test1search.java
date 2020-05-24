package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1search {
	
	WebDriver driver = null;
	
	public void launchBrowser(){
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
	
		driver.get("http://automationpractice.com/index.php");		
	}
	
	public void searchProduct() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("All best sellers")).click();
		
	}
	
	public void navigate() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(3000);
		driver.navigate().back();
		System.out.println("The page title is:" +driver.getTitle());		
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		Test1search ob = new Test1search();
		ob.launchBrowser();
		ob.searchProduct();
		ob.navigate();
		ob.CloseBrowser();
		
	}
}

