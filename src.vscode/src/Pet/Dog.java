package Pet;

public class Dog extends Pet {
    public Dog(String name, Double weight) {
        super(name, weight);
    }

    @Override
    public String speak() {
        return "Boc Boc";
    }

    @Override
    public double foodCostPerDay() {
        return getWeight() * 12;
    }

    public String toString() {
        return super.toString() + speak();
    }
}
