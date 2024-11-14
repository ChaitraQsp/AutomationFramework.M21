package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample()
	{
		System.out.println("hi");
		System.out.println("1");
		System.out.println("2");
		
		Assert.assertEquals(false, true);
		Assert.assertTrue(true);
		
		System.out.println("3");
		System.out.println("4");
		
	}
	
	@Test
	public void sample1()
	{
		SoftAssert sa= new SoftAssert();
		
		System.out.println("hi");
		System.out.println("1");
		
		sa.assertEquals(false, true);;
		
		System.out.println("2");
		
		sa.assertEquals(false, true);;
		
		System.out.println("3");
		System.out.println("4");
		
		sa.assertAll();
		
		System.out.println("5");
		sa.assertEquals(false, true);;
		
	}

}
