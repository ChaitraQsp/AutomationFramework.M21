package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation to IRetryAnalyser of TestNG
 * @author Chaitra M
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count = 0;
	int retryCount = 3; //Manual analysis
	
	public boolean retry(ITestResult result) {
		
		//0<3 - 1<3 - 2<3 - 3<3NO
		if(count<retryCount)
		{
			count++; //1 2 3
			return true; //retry retry retry
		}
		
		return false; // Stop / not retry
	}

}
