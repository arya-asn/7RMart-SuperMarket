package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//test case has to run due to network issues time limit. So we can add in the retryanlyzer

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
