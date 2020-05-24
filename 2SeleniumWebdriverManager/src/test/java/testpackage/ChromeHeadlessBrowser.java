package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessBrowser {

	private static WebDriver driver = null; 



	public static void SeleniumFWaits() throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Note : Fixed error: added to remove chrome timeout error 0.100

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		
		driver = new ChromeDriver(option);

		
		driver.get("http://automationpractice.com/index.php");		
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
		System.out.println(driver.getTitle());

		

		driver.close();
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		SeleniumFWaits();

	}
}

