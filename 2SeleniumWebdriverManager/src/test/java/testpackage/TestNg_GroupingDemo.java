package testpackage;

import org.testng.annotations.Test;

@Test(groups= {"WillTakeAllTests"})  //adding group at class level
public class TestNg_GroupingDemo {
	@Test(groups= {"sanity"})  //adding groups
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(groups= {"sanity", "smoke"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(groups= {"sanity","regression"})
	public void test3() {
		System.out.println("Test3");
	}
	
	@Test(groups= {"windows.regression"})
	public void test4() {
		System.out.println("Test4");
	}
	
	@Test(groups= {"linux.regression"})
	public void test5() {
		System.out.println("Test5");
	}
	//to run this create an xml file here testngGD.xml
}
