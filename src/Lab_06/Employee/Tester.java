package Employee;

public class Tester {
    public static void main(String[] args) {
        Employee[] emp = new Employee[5];
        Sales s1 = new Sales("Jame" , 15000 , 5000);
        Sales s2 = new Sales("Bell", 20000,8000);
        emp[0] = s1;
        emp[1] = s2;

        Manager m1 = new Manager("Peter",40000,"40-19");
        emp[2] = m1;

        String[] st = {"Java","C"};
        String[] st2 = {"Java","PHP","Python"};
        Programmer p1 = new Programmer("Ann",30000,st,0);
        Programmer p2 = new Programmer("Bank",40000,st2,0 );
        emp[3] = p1;
        emp[4] = p2;

        for (int i = 0; i < emp.length; i++) {
            System.out.println(emp[i].toString());

        }
    }
}
