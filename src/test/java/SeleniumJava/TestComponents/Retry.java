package SeleniumJava.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
//retries if a test case fails 
	
	int count=0;
	int maxTry=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (count<maxTry)
		{
			count++;
			return  true;
		}
		return false;
	}

}
