package Employee;

public class Sales extends Employee {
    double commission;

    public Sales (){
        super();
        commission = 0;
    }

    public Sales (String name , double salary , double commission){
        super(name,salary);
        this.commission = commission;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public double calSalary() {
        return super.calSalary() + getCommission() ;
    }

    public String toString(){
        return "My name is " + getName() + "\nI am a sales." + "\nMy salary is " + calSalary();
    }
}
