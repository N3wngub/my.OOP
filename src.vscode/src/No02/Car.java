package No02;

public class Car extends Vehicle implements Insurable {
    private int seat;

    public Car(String id, String brand, double baseRate, int seat)  {
        super(id, brand, baseRate);
        this.seat = seat;
    }

    @Override
    public   double calculateRent(int days) throws InvalidDayException {
        if (days <= 0) {
            throw new InvalidDayException(days); // ข้อ 4
        }

        double rent = getBaseRate() * days;
        if (seat > 5) {
            rent += (rent * 0.20); // เพิ่ม 20%
        }

        if (days > 30) {
            rent -= (rent * 0.15);
        }
        return rent;
    }

    @Override
    public double calculateInsurance() {
        return getBaseRate() * 0.05;
    }

    @Override
    public double getTotalCost(int days) throws InvalidDayException {
        return calculateRent(days) + (calculateInsurance() * days);
    }

    public boolean isLuxury() {
        return seat > 5;
    }
}