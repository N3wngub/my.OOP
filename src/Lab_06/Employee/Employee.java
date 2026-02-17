package Employee;

public class Employee {
    String name;
    double salary;

    public Employee(){
        name = "unknown";
        salary = 0;

    }
    public Employee (String name , double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calSalary (){
        return salary;
    }

    public String toString(){
        return "My name is " + getName() + "\nI am an employee." + "\nMy salary is " + calSalary();
    }


}
