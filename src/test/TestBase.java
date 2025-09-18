package test;

import java.util.logging.Logger;

public abstract class TestBase {
	protected Logger logger = Logger.getLogger(this.getClass().getName());

	protected static int totalTests = 0;
    protected static int testsPassed = 0;
    protected static int testsFailed = 0;
    
    protected void assertEquals(Object expected, Object result, String testName) {
        if ((expected != null && expected.equals(result)) || (expected == null && result == null)) {
            logger.info(testName + " PASSED");
            testsPassed++;
        } else {
            logger.severe(testName + " FAILED | Expected: " + expected + " | Got: " + result);
            testsFailed++;
        }
        totalTests++;
    }

    
    protected void assertThrows(Runnable r, Class<? extends Exception> expectedException, String testName) {
    	try {
    		r.run();
            logger.info(testName + " FAILED");
            testsFailed++;
    	} catch (Exception e) {
    		if (expectedException.isInstance(e)) {
                logger.info(testName + " PASSED " + e.getMessage());
                testsPassed++;
    		} else {
                logger.severe(testName + " FAILED | Expected: " 
    		+ expectedException.getSimpleName() + " | Got: " + e.getClass().getSimpleName());
                testsFailed++;
    		}
    	}
    	
    	totalTests++;
    }

    protected void printResult() {
        String summary = String.format(
            "===== TEST SUMMARY =====%n" +
            "Total Tests  : %d%n" +
            "Tests Passed : %d%n" +
            "Tests Failed : %d%n" +
            "========================",
            totalTests, testsPassed, testsFailed
        );
        logger.info(summary);
    }


}
