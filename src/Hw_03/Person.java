import java.util.Scanner;

public class Person {
    String firstname;
    String lastname;

    public Person() {
        firstname = "Unknown";
        lastname = "Unknown";
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String toString() {
        return "Person : " + firstname + " " + lastname;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        Person[] person = new Person[n];
        for (int i = 0; i < person.length; i++) {
            person[i] = new Person(kb.next(), kb.next());
        }
        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].toString());
        }
    }
}
