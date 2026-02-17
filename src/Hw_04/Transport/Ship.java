package Transport;

public class Ship implements Transport {
    private double rate = 2;
    public void deliver(){
        System.out.println("Deliver By Ship");
    }

    public double getRate(){
        return rate;
    }
}
