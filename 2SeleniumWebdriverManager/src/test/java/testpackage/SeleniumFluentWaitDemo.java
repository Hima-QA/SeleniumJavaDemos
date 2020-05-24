package testpackage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;


public class SeleniumFluentWaitDemo {

	private static WebDriver driver = null; 



	public static void SeleniumFWaits() throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Note : Fixed error: added to remove chrome timeout error 0.100
		driver = new ChromeDriver();


		driver.get("http://automationpractice.com/index.php");		
		driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();


		//driver.findElement(By.linkText("All best sellers")).click();

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {

				WebElement linkElement = driver.findElement(By.linkText("All best sellers"));

					if(linkElement.isEnabled()) {
						System.out.println("Element Found");
					}
					return linkElement;
				}
		});
		element.click();
		Thread.sleep(3000);

		driver.close();
		driver.quit();
	}
	public static void main(String[] args) throws InterruptedException {
		SeleniumFWaits();

	}
}

