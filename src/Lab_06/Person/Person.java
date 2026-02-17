package Person;
public class Person {
    protected String name;
    protected int bornYear;

    public Person(String name, int bornYear) {
        this.name = name;
        this.bornYear = bornYear;
    }

    public void introduce() {
        System.out.println("My name is " + name + ".");
        System.out.println("I was born in " + bornYear + ".");
    }
}