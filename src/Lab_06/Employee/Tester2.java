package Employee;

import java.util.Scanner;
public class Tester2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter number of person : ");
        int n = kb.nextInt();
        Employee[] employees = new Employee[n];

        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter information of person (" + (i + 1)+") :");
            System.out.print("Enter type of person : ");
            int type = kb.nextInt();


            if (type == 1) {
                System.out.print("Enter Employee information (" + (i + 1) + ")[name salary] : ");
                employees[i] = new Employee(kb.next(), kb.nextDouble());
            } else if (type == 2) {
                System.out.print("Enter Sales information (" + (i + 1) + ")[name salary commission] : ");
                employees[i] = new Sales(kb.next(), kb.nextDouble(), kb.nextDouble());
            } else if (type == 3) {
                System.out.print("Enter Manager information (" + (i + 1) + ")[name salary parkingNo] : ");
                employees[i] = new Manager(kb.next(), kb.nextDouble(), kb.next());
            } else if (type == 4) {
                System.out.print("Enter programmer information (" + (i + 1) + ")[name salary OT] : ");
                String name = kb.next();
                double salary = kb.nextDouble();
                int OT = kb.nextInt();

                System.out.print("Enter number of programing languages : ");
                int numSkills = kb.nextInt();
                String[] skills = new String[numSkills];

                for (int j = 0; j < numSkills; j++) {
                    System.out.print("Enter name of lang (" + (j + 1) + ") : ");
                    skills[j] = kb.next();
                }
                employees[i] = new Programmer(name, salary, skills, OT);
            }


        }

        System.out.println("\nk=== The detail of each person ===>");
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.toString());

            }
        }
    }
}