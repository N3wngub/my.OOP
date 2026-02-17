import java.util.Scanner;

public class Employee extends Person {
    protected int salary;
    protected String position;

    public Employee() {
        super();
        salary = 0;
        position = "unknown";
    }

    public Employee(String firstname, String lastname, int salary, String position) {
        super(firstname, lastname);
        this.salary = salary;
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int calculatePay() {
        return salary;
    }

    public void upSalary(int percentage) {
        salary += (salary * percentage) / 100;
    }

    public String toString() {
        return "Employee : " + getFirstname() + " " + getLastname() + " " + position + " " + calculatePay();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        Employee[] employee = new Employee[n];
        for (int i = 0; i < employee.length; i++) {
            String firstname = kb.next();
            String lastname = kb.next();
            int salary = kb.nextInt();
            String position = kb.next();


            employee[i] = new Employee(firstname, lastname, salary, position);

        }
        int percentage = kb.nextInt();
        for (int i = 0; i < employee.length; i++) {
            System.out.println(employee[i].toString());

        }
        System.out.println("After update salary");

        for (int i = 0; i < employee.length; i++) {
            employee[i].upSalary(percentage);
            System.out.println(employee[i].toString());
        }

    }

}
