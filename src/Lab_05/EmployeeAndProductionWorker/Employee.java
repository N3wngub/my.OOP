package EmployeeAndProductionWorker;

public class Employee {
    String empName;
    String empNumber;
    String hireDate;

    public Employee(){
        empName = "Unknown";
        empNumber = "Unknown";
        hireDate = "Unknown";
    }

    public Employee (String empName ,String empNumber, String hireDate){
        this.empName = empName;
        this.empNumber = empNumber;
        this.hireDate = hireDate;
    }
    public String getEmpName() {
        return empName;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
    public String toString(){
        return "Name : " + empName + "\nNumber : " + empNumber + "\nDate : " +hireDate;
    }
}
