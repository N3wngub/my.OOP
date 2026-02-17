package Employee;

public class Manager extends Employee{
    String parkingNo;

    public Manager (){
        super();
        parkingNo = "unknown";
    }
    public Manager(String name , double salary ,String parkingNo){
        super(name,salary);
        this.parkingNo = parkingNo;
    }
    public double calSalary() {
        return super.calSalary();
    }

    public String toString(){
        return "My name is " + getName() + "\nI am a manager." + "\nMy salary is " + calSalary();
    }

}
