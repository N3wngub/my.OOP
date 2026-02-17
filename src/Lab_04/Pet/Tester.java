package Pet;

public class Tester {
    public static void main(String[] args) {
        Dog dog1 = new Dog();


        dog1.setName("shiba");
        dog1.setWeight(200);

        System.out.println(dog1.toString());
        dog1.makeSound();

        System.out.println();

        Cat cat1 = new Cat();
        cat1.setName("sater");
        cat1.setWeight(200);

        System.out.println(cat1.toString());
        cat1.makeSound();

    }
}
