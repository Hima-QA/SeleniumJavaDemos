package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//This session will identify the weblocators(objects)as well as the actions in a single class for every webpage and just refer all the objects and there actions directly in the testcase

public class AutopractiseHoSrObjectsPage {
	WebDriver driver= null;
	
	//Locating web-objects
	By textbox_srch = By.id("search_query_top");
	
	By btn_srch = By.xpath("//*[@id=\"searchbox\"]/button");
	
	//Adding Constructor to call the driver instance from the test-case class rather than taking driver here in pageclass 
	public AutopractiseHoSrObjectsPage(WebDriver driver){
		this.driver= driver;
	}
	
	//Adding the actions
	public void searchInTextBox(String text) {
		driver.findElement(textbox_srch).sendKeys(text); //
		
	}
	
	public void clickSearchBtn() {
		driver.findElement(btn_srch).sendKeys(Keys.RETURN); 
		
	}
	


}
