import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumMTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();   
		
		//Note: Writing these two statements we don't have to download chromedriver and nor have to set the path.
		
		driver.get("http://automationpractice.com/index.php");
		driver.quit();
		driver.close();
		
		
		
	}

}
