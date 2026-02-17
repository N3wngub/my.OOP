package EmployeeAndProductionWorker;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        Employee p1 = new Employee();
        p1.setEmpName("jame");
        p1.setEmpNumber("123-A");
        p1.setHireDate("1-1-2561");

        ProductionWorker pw1 = new ProductionWorker();
        pw1.setShift("Day");
        pw1.setHourlyPerRate(50);

        System.out.println(p1.toString());
        System.out.println(pw1.showinfo());
        System.out.println();

        ProductionWorker pw2 = new ProductionWorker();
        pw2.setEmpName("Bell");
        pw2.setEmpNumber("222-A");
        pw2.setHireDate("2-2-2561");
        pw2.setShift("Night");
        pw2.setHourlyPerRate(100);

        System.out.println(pw2.toString());
        System.out.println(pw2.showinfo());

        System.out.println();

        System.out.print("Enter the number of working hours for " + p1.empName +": ");
        int hour = kb.nextInt();
        double saraly = hour * pw1.getHourlyPerRate();
        System.out.println("Saraly of " + p1.empName + " = " + saraly);

        System.out.print("Enter the number of working hours for " + pw2.empName +": ");
        int hour2 = kb.nextInt();
        double saraly2 = hour2 * pw2.getHourlyPerRate();
        System.out.println("Saraly of " + pw2.empName + " = " + saraly2);

        if (saraly > saraly2) {
            System.out.println(p1.empName + " has more salary than "
                    + pw2.empName + " = " + (int)(saraly-saraly2));

        }else if (saraly2 > saraly){
            System.out.println(pw2.empName + " has more salary than "
                + p1.empName + " = " + (int)(saraly2-saraly));

        }else {
            System.out.println(p1.empName + " and " + pw2.empName + " get the same saraly." );
        }
    }
}
