package listners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(listners.Listners_TestNg.class)  //(packagename.classname)  //@Listeners commented as its included via testng1.xml file under class tag 
public class ListnerTNG_Demo {
	@Test
	public void test1() {
		System.out.println(" Now in Test1");
	}
	
	@Test
	public void test2() {
		System.out.println(" Now in Test2");
	Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		System.out.println(" Now in Test3");
		throw new SkipException("This test got skipped");
	}
	
	
}
