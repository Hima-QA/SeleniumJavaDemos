package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Note in this session we are just identifying the web locators in a class and all the actions will be in testcases
//Next session will identify the weblocators(objects)as well as the actions in a single class for every webpage and just refer all the objects and there actions directly in the testcase
public class AutopractiseHSearchPage {

	private static WebElement element =null;
	
	public static WebElement textbox_Search(WebDriver driver) {
		element = driver.findElement(By.id("search_query_top"));
		return element;
		

	}
	
	public static WebElement button_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
		return element;
	}
		
	public static void main(String[] args) {


	}

}
