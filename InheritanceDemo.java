import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        // 1. Create the ArrayList of Workers
        ArrayList<Worker> payroll = new ArrayList<>();

        // 2. Create 3 Workers (Hourly)
        payroll.add(new Worker("James", "Logan", "W001", "Mr.", 1985, 25.00));
        payroll.add(new Worker("Ororo", "Munroe", "W002", "Ms.", 1990, 35.50));
        payroll.add(new Worker("Scott", "Summers", "W003", "Mr.", 1988, 28.00));

        // 3. Create 3 SalaryWorkers (Annual)
        // Note: Hourly rate is passed as 0 or a nominal value as it's not used for salary math
        payroll.add(new SalaryWorker("Jean", "Grey", "S001", "Dr.", 1992, 0, 95000.00));
        payroll.add(new SalaryWorker("Charles", "Xavier", "S002", "Prof.", 1965, 0, 150000.00));
        payroll.add(new SalaryWorker("Hank", "McCoy", "S003", "Dr.", 1980, 0, 115000.00));

        // 4. Define the pay periods (Week 1: 40h, Week 2: 50h, Week 3: 40h)
        double[] weeklyHours = {40.0, 50.0, 40.0};

        // 5. Loop through the weeks
        for (int week = 0; week < weeklyHours.length; week++) {
            double currentHours = weeklyHours[week];

            System.out.println("\n========================================================");
            System.out.println("         PAY PERIOD WEEK " + (week + 1) + " (" + currentHours + " Hours)");
            System.out.println("========================================================");
            System.out.printf("%-15s %-10s %-15s%n", "Name", "ID", "Weekly Pay");
            System.out.println("--------------------------------------------------------");

            for (Worker w : payroll) {
                double pay = w.calculateWeeklyPay(currentHours);
                System.out.printf("%-15s %-10s $%,14.2f%n", w.fullName(), w.getID(), pay);
            }
        }
    }
}
