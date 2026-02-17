package Transport;

public abstract class Logistics {
    private Transport trans;
    private double distance = 0 ;

    public double planDelivery(double distance){
        this.trans = createTransport();
        this.distance = distance;
        Transport t = createTransport();
        return distance*trans.getRate();
    }
    public abstract Transport createTransport();

    public void deliver(){
        trans.deliver();
    }
}
