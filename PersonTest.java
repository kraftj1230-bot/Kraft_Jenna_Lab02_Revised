public class PersonTest {
    public static void main(String[] args) {

        Person p = new Person("John", "Doe", "12345", "Mr.", 1980);

        TestRunner.assertEquals("John Doe", p.fullName(), "fullName()");
        TestRunner.assertEquals("Mr. John Doe", p.formalName(), "formalName()");
        TestRunner.assertTrue(p.getAge() > 0, "getAge()");
        TestRunner.assertEquals("John,Doe,12345,Mr.,1980", p.toCSV(), "toCSV()");
        TestRunner.assertTrue(p.toJSON().contains("John"), "toJSON()");
        TestRunner.assertTrue(p.toXML().contains("<Person>"), "toXML()");

        System.out.println("Person tests complete.");
    }
}
