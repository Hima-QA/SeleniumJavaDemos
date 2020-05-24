package listners;

//import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

//@Listeners(listners.Listners_TestNg.class)  //(packagename.classname)  //@Listeners commented as its included via testng1.xml file under class tag 
public class ListnerTNG_Demo2 {
	@Test
	public void test4() {
		System.out.println(" Now in Test4");
	}
	
	@Test
	public void test5() {
		System.out.println(" Now in Test5");
	// Assert.assertTrue(false);
	}
	
	@Test
	public void test6() {
		System.out.println(" Now in Test6");
		throw new SkipException("This test got skipped");
	}
	
	
}
