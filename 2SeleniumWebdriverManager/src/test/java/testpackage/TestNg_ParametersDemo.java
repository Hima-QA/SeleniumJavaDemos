package testpackage;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNg_ParametersDemo {
	/*@Test
	@Parameters({"ParaName"})  //adding parameter in testng //Note: The name specified here must be same in xml file as parameter name 
	public void test1(String name) {
		System.out.println("My name is:"+name);
	}*/
	
	@Test
	@Parameters({"ParaName"})  //adding parameter in testng //Note: The name specified here must be same in xml file as parameter name 
	public void test2(@Optional("Abcd") String name) {
		System.out.println("My name is:"+name);
	}
	
	
	//to run this create an xml file here testngPD.xml
}
