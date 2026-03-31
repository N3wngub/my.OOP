package No03;

public class ExpressParcel extends Parcel implements Trackable{
    private int statusCode;
    public ExpressParcel(String trackingNo, String senderName, double weightKg, double distanceKm)
            throws InvalidWeightException, InvalidDistanceException {
        super(trackingNo, senderName, weightKg, distanceKm);
    }

    @Override
    double calculateFee() throws InvalidWeightException {
        return (getWeightKg()*14)+(getDistanceKm()*2.25+20);
    }

    @Override
    String getType() {
        return "Express Parcel";
    }

    @Override
    public void updateStatus(int code) {
        this.statusCode = code;
    }

    @Override
    public String getStatus() {
        switch(statusCode) {
            case 0: return "CREATED";
            case 1: return "IN_TRANSIT";
            case 2: return "DELIVERED";
            default: return "UNKNOWN";
        }
    }
}
