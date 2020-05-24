package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelUtilDataProvider_TestNg {
	
	WebDriver driver =null;
	
	
	@BeforeTest
	public void launch(){
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // added to remove chrome timeout error 0.100
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		
	}
	
	@Test(dataProvider="Test1data")
	public void test1(String username,String password) throws InterruptedException {
		System.out.println(username+" | "+password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);
		
	}
	
	@DataProvider(name="Test1data")
	public static Object[][] getData() throws IOException {
		String projectPath= System.getProperty("user.dir");
		Object data[][]=testData(projectPath+"\\Excel\\data.xlsx","Sheet1"); // passing parameter to the fn testData(excelPath,sheetName)
		return data;
	}
	
	
	
	public static Object[][] testData(String excelPath, String sheetName) throws IOException {
		
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();	
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				String cellData = excel.getCellData(i,j);
				//System.out.println(cellData); //Commented it as it is printing in @Test
				data[i-1][j] =cellData; //inside loop keep on adding Data
				
			}
		}
		return data;
	}
	
	
}
