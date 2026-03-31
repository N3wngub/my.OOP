package Pet;

public class Cat extends Pet {
    public Cat(String name, Double weight) {
        super(name, weight);
    }

    @Override
    public String speak() {
        return "Meaw Meaw";
    }

    @Override
    public double foodCostPerDay() {
        return getWeight() * 10;
    }

    @Override
    public String toString() {
        return super.toString() + speak();
    }
}
