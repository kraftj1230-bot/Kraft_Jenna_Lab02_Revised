public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate) {
        super(firstName, lastName, ID, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            double regularPay = 40 * hourlyPayRate;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * (hourlyPayRate * 1.5);
            return regularPay + overtimePay;
        }
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * (hourlyPayRate * 1.5);

        System.out.println("--- Weekly Pay Breakdown ---");
        System.out.printf("Regular:  %5.1f hrs @ $%.2f/hr = $%.2f%n", regularHours, hourlyPayRate, regularPay);
        System.out.printf("Overtime: %5.1f hrs @ $%.2f/hr = $%.2f%n", overtimeHours, (hourlyPayRate * 1.5), overtimePay);
        System.out.printf("Total:    $%.2f%n", (regularPay + overtimePay));
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    @Override
    public String toJSON() {
        // Removes the closing bracket from Person JSON to add the new field
        String personJson = super.toJSON();
        return personJson.substring(0, personJson.length() - 1) + ", \"hourlyPayRate\":" + hourlyPayRate + "}";
    }

    @Override
    public String toXML() {
        return super.toXML() + "<hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate></Person>";
    }
}
