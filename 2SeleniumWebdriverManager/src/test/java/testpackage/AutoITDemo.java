package testpackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class AutoITDemo {
	public static WebDriver driver=null;
	public static void test() throws Exception {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Note : Fixed error: added to remove chrome timeout error 0.100
		driver = new ChromeDriver();
		
		driver.get("http://www.tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("D:\\A-Selenium\\SciTE Scripts\\FileUploadScript.exe");
		Thread.sleep(3000);
		
		//driver.close();
		
	}
	public static void main(String[] args) throws Exception {
		test();

	}
	
}
