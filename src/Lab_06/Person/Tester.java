package Person;

public class Tester {
    public static void main(String[] args) {

        Person p1 = new Person("Jame", 1988);
        Person p2 = new Sheriff("Bank", 2000, "Mueang");
        Person p3 = new Police("Bell", 2001, "Chonburi");


        System.out.println("-------------------------");
        p1.introduce();

        System.out.println("-------------------------");
        p2.introduce();

        System.out.println("-------------------------");
        p3.introduce();
        System.out.println("-------------------------");
    }
}
