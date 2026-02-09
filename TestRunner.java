public class TestRunner {

    // For objects (Strings, etc.)
    public static void assertEquals(Object expected, Object actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName + " | expected=" + expected + " actual=" + actual);
        }
    }

    // For doubles with delta
    public static void assertEquals(double expected, double actual, double delta, String testName) {
        if (Math.abs(expected - actual) < delta) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName + " | expected=" + expected + " actual=" + actual);
        }
    }

    // For boolean conditions
    public static void assertTrue(boolean condition, String testName) {
        if (condition) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
        }
    }
}


