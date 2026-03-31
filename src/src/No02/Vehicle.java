package No02;

public abstract class Vehicle {
    private String id;
    private String brand;
    private double baseRate;

    public Vehicle(String id, String brand, double baseRate) {
        this.id = id;
        this.brand = brand;
        this.baseRate = baseRate;
    }

    public Vehicle() {

    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getBaseRate() {
        return baseRate;
    }

    abstract double calculateRent(int days) throws InvalidDayException;
    abstract double calculateInsurance();
    abstract double getTotalCost(int days) throws InvalidDayException;
}
