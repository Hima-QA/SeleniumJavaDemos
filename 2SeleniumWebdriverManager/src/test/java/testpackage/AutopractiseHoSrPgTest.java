package testpackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.AutopractiseHoSrObjectsPage;

public class AutopractiseHoSrPgTest {
	
	private static WebDriver driver =null;
	
	public void launchBrowser(){
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		//AutopractiseHoSrObjectsPage srchpageobj = new AutopractiseHoSrObjectsPage(driver); 
		driver.get("http://automationpractice.com/index.php");		
	}
	
	public void searchProduct() throws InterruptedException {
		Thread.sleep(2000);
		AutopractiseHoSrObjectsPage srchpageobj = new AutopractiseHoSrObjectsPage(driver); 
		srchpageobj.searchInTextBox("Printed Dress");
		srchpageobj.clickSearchBtn();
		
		System.out.println("The page title is:" +driver.getTitle());
	}
	
	public void CloseBrowser() {
		driver.quit();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AutopractiseHoSrPgTest ob = new AutopractiseHoSrPgTest();
		ob.launchBrowser();
		ob.searchProduct();
		ob.CloseBrowser();
		
	}

}
