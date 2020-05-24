package testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNg_RetryFailDemo {
	
	@Test
	public void test1() {
		System.out.println("Inside Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside Test2");
		//int i=1/0;
	}
	
	@Test
	public void test3() {
		System.out.println("Inside Test3");
		Assert.assertTrue(0>1);
	}
	
	//Whenever a test fail u will get a testng-failed.xml file in test-output folder when its refreshed
	//U can re run this xml file by fixing the fail ,now here i'll comment int i=1/0; and run the xml file
}
 