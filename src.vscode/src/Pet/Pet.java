package Pet;

public class Pet {
    private String name;
    private Double weight;

    public Pet(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double w) {
        this.weight = w;
    }

    public String speak() {
        return " ";
    }

    public double foodCostPerDay() {
        return weight;
    }

    @Override
    public String toString() {
        return "name : " + name + "\n" + "weight : " + weight + "\n" + "Sound : ";
    }
}
