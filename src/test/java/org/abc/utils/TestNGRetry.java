package org.abc.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNGRetry implements IRetryAnalyzer {
   // private int retryCount = 0;
    private static final int maxRetryCount = 1;

    ThreadLocal<Integer> count = ThreadLocal.withInitial(()->0);
    @Override
    public boolean retry(ITestResult result) {
        if(!result.isSuccess()){
            if (count.get() < maxRetryCount) {
                count.set(count.get()+1);
                return true;
            }
        }

        return false;
    }
}
