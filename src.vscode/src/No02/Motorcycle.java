package No02;

public class Motorcycle extends Vehicle implements Insurable{
    private int engineCC;
    private int days;

    public Motorcycle(String id, String brand, double baseRate) {
        super(id, brand, baseRate);
    }

    public Motorcycle(String id, String brand, double baseRate, int engineCC) {
        super(id, brand, baseRate);
        this.engineCC = engineCC;
    }

    double upperPrice = getBaseRate()*0.1;//10%

    @Override
    double calculateRent(int days) {
        if (engineCC > 150){
            return days*(getBaseRate()+upperPrice);
        }
        return getBaseRate();
    }

    public double calculateInsurance() {
        return (getBaseRate()+upperPrice)*0.3;
    }

    @Override
    double getTotalCost(int days) {
        return calculateRent(days)+calculateInsurance();
    }
}
