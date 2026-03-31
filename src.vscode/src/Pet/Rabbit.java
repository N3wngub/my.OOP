package Pet;

public class Rabbit extends Pet {
    public Rabbit(String name, Double weight) {
        super(name, weight);
    }

    @Override
    public String speak() {
        return "someting";
    }

    @Override
    public double foodCostPerDay() {
        return getWeight() * 8;
    }

    public String toString() {
        return super.toString() + speak();
    }
}
