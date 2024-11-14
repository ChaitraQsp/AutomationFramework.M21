package practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void test()
	{
		System.out.println("step 1");
		Assert.fail();
		System.out.println("Step 2");
	}

}
