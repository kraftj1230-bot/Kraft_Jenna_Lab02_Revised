/**
 * Represents a Worker paid a fixed annual salary.
 * Inherits from Worker.
 */
public class SalaryWorker extends Worker {
    private double annualSalary;

    // Constructor using super() to call the Worker constructor
    public SalaryWorker(String firstName, String lastName, String ID, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(firstName, lastName, ID, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        // hoursWorked is ignored here but kept for polymorphism
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println("--- Weekly Salary Pay ---");
        System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        System.out.printf("Weekly Pay: $%.2f (1/52 of annual)%n", weeklyPay);
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toJSON() {
        String base = super.toJSON();
        // Remove trailing ' }' and add salary
        return base.substring(0, base.length() - 2) + ", \"annualSalary\": " + annualSalary + " }";
    }

    @Override
    public String toXML() {
        String base = super.toXML();
        // Insert salary before the final </Person> or </Worker> closing tag
        int insertPos = base.lastIndexOf("</Person>");
        return base.substring(0, insertPos) + "  <AnnualSalary>" + annualSalary + "</AnnualSalary>\n</Person>";
    }
}
