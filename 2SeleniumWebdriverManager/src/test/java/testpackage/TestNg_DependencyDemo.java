package testpackage;

import org.testng.annotations.Test;

public class TestNg_DependencyDemo {
	
	@Test 
	//@Ignore This annotation here is not supported s it is expected to be available from TestNG version6.14.2
	public void test1() {
		System.out.println("Inside Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside Test2");
	}
	@Test
	public void test3() {
		System.out.println("Inside Test3");
	}
	
}
 

