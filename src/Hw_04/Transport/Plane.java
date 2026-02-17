package Transport;

public class Plane implements Transport {
    private double rate = 10;
    public void deliver(){
        System.out.println("Deliver By Plane");
    }

    public double getRate(){
        return rate;
    }
}
