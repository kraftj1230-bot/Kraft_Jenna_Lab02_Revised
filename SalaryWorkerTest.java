public class SalaryWorkerTest {
    public static void main(String[] args) {

        // ✅ MUST pass 7 arguments (hourly rate still required by constructor)
        SalaryWorker sw = new SalaryWorker(
                "Dana",
                "White",
                "S001",
                "Dr.",
                1982,
                0,          // hourly rate not used but required
                52000       // annual salary
        );

        // Test weekly pay
        double weeklyPay = sw.calculateWeeklyPay(40);
        TestRunner.assertEquals(1000.0, weeklyPay, 0.001, "calculateWeeklyPay()");

        // Test data formats
        TestRunner.assertTrue(sw.toCSV().contains("52000"), "toCSV()");
        TestRunner.assertTrue(sw.toJSON().contains("annualSalary"), "toJSON()");
        TestRunner.assertTrue(sw.toXML().contains("<AnnualSalary>52000.0</AnnualSalary>"), "toXML()");

        System.out.println("SalaryWorker tests complete.");
    }
}



