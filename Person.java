import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Represents a Person with first name, last name, title, ID, and year of birth.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    // Constructor
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    // Methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return getAge(year);
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    public String toJSON() {
        return "{ \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName +
                "\", \"ID\": \"" + ID + "\", \"title\": \"" + title + "\", \"YOB\": " + YOB + " }";
    }

    public String toXML() {
        return "<Person>\n" +
                "  <FirstName>" + firstName + "</FirstName>\n" +
                "  <LastName>" + lastName + "</LastName>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <Title>" + title + "</Title>\n" +
                "  <YOB>" + YOB + "</YOB>\n" +
                "</Person>";
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public int getYOB() { return YOB; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setTitle(String title) { this.title = title; }
    public void setYOB(int YOB) { this.YOB = YOB; }

    /** Main method to test Person class */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        System.out.println("Enter 2 people for testing:");

        for (int i = 0; i < 2; i++) {
            System.out.print("First Name: ");
            String f = sc.nextLine();
            System.out.print("Last Name: ");
            String l = sc.nextLine();
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Title: ");
            String t = sc.nextLine();
            System.out.print("Year of Birth: ");
            int yob = sc.nextInt();
            sc.nextLine(); // consume newline

            Person p = new Person(f, l, id, t, yob);
            people.add(p);
        }

        System.out.println("\n--- People Info ---");
        for (Person p : people) {
            System.out.println(p.formalName() + ", Age: " + p.getAge());
            System.out.println("CSV: " + p.toCSV());
            System.out.println("JSON: " + p.toJSON());
            System.out.println("XML:\n" + p.toXML());
            System.out.println("-------------------");
        }
        sc.close();
    }
}
