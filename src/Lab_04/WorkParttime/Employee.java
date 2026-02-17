package WorkParttime;

public class Employee extends Person {
    int salary;

    public Employee() {
        super();

    }

    public Employee(Person firstname, Person lastname) {
        super(firstname.getFirstname(), lastname.getLastname());
    }

    public void setSalary(int salary){
        this.salary =salary;
    }

    public int getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public void pay(){
        System.out.println("Have salary : " +salary);
    }
}
