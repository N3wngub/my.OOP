package No03;

public abstract class Parcel {
    private String trackingNo;
    private String senderName;
    private double weightKg;
    private double distanceKm;

    public Parcel(String trackingNo, String senderName, double weightKg, double distanceKm) throws InvalidWeightException , InvalidDistanceException{
        this.trackingNo = trackingNo;
        this.senderName = senderName;
        if (weightKg <= 0){
            throw new InvalidWeightException();
        }
        this.weightKg = weightKg;
        if (distanceKm <= 0){
            throw new InvalidDistanceException();
        }
        this.distanceKm = distanceKm;
    }

    public String getSenderName() {
        return senderName;
    }

    public double getWeightKg() throws InvalidWeightException{
        return weightKg;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    abstract double calculateFee() throws InvalidWeightException;
    abstract String getType();

    public String summary() throws InvalidWeightException {
        System.out.println("==== Summary ====");
        System.out.print( "Type => " + getType() + "\n" +
                            "Tracking No. => " + trackingNo + "\n"+
                            "Sender Name => "+ senderName +"\n"+
                            "Fee => ") ;
        System.out.printf("%.2f",calculateFee());
        System.out.println();
        System.out.println("=================");
        return "";
    }
}
