package Lab_09.Name;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String name = kb.next();
        String age = kb.next();
        Person p1 = new Person(name, age);
        System.out.println(p1.toString());

        String name1 = kb.next();
        String howtoUse = kb.next();
        Things t1 = new Things(name1, howtoUse);
        System.out.println(t1.toString());

        String name2 = kb.next();
        String type = kb.next();
        Animal a1 = new Animal(name2, type);
        System.out.println(a1.toString());
    }
}
