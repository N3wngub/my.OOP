package Dog;

public class Tester {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        System.out.println("=== Information my dog === ");
        System.out.println("Dog name : " + myDog.getName());
        System.out.println("Dog breed : " + myDog.getBreed());
        System.out.println("=== call method setName and setBreed ===");
        myDog.setName("Gold");
        myDog.setBreed("Golden Retriever");
        System.out.println("=== Information my dog === ");
        System.out.println("Dog name : " + myDog.getName());
        System.out.println("Dog breed : " + myDog.getBreed());
        myDog.makeSound();

        System.out.println();
        Dog yourDog = new Dog("German", "German Shepherd");
        System.out.println("=== Information your dog === ");
        System.out.println("Dog name : " + yourDog.getName());
        System.out.println("Dog breed : " + yourDog.getBreed());
        yourDog.makeSound();
    }
}

