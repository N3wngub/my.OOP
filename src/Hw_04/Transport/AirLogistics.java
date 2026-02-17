package Transport;

public class AirLogistics extends Logistics{
    public Transport createTransport(){
        return new Plane();
    }
}
