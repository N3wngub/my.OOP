package WorkParttime;

public class Tester {
    public static void main(String[] args) {
        Employee em1 = new Employee();
        em1.setFirstname("Phimpattra");
        em1.setLastname("Sriprach");
        em1.setSalary(1000000);
        System.out.println(em1.toString());
        em1.pay();

        System.out.println();
        ParttimeEmployee pm1 = new ParttimeEmployee();
        pm1.setFirstname("thanatcha");
        pm1.setLastname("jomsanga");
        pm1.setHour(8);
        pm1.setRate(120);
        System.out.println(pm1.toString());
        pm1.pay();
    }
}
