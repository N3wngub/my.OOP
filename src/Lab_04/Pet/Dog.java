package Pet;

public class Dog extends Pet{

    public  Dog(){
        super();
    }

    public Dog(Pet name,Pet weight){
        super(name.getName(),weight.getWeight());

    }
    public void makeSound(){
        System.out.println("Boc Boc");
    }
}
