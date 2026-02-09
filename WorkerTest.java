public class WorkerTest {
    public static void main(String[] args) {

        Worker w = new Worker("Alice", "Smith", "W001", "Ms.", 1985, 20);

        // Test weekly pay
        TestRunner.assertEquals(800.0, w.calculateWeeklyPay(40), 0.001, "calculateWeeklyPay(40)");
        TestRunner.assertEquals(950.0, w.calculateWeeklyPay(45), 0.001, "calculateWeeklyPay(45 overtime)");

        // Test CSV/JSON/XML
        TestRunner.assertEquals("Alice,Smith,W001,Ms.,1985,20.0", w.toCSV(), "toCSV()");
        TestRunner.assertTrue(w.toJSON().contains("hourlyPayRate"), "toJSON()");
        TestRunner.assertTrue(w.toXML().contains("<HourlyPayRate>20.0</HourlyPayRate>"), "toXML()");

        System.out.println("Worker tests complete.");
    }
}




