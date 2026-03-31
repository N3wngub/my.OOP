package No03;

public class RegularParcel extends Parcel implements Trackable{
    private int statusCode;
    public RegularParcel(String trackingNo, String senderName, double weightKg, double distanceKm)
            throws InvalidWeightException, InvalidDistanceException {
        super(trackingNo, senderName, weightKg, distanceKm);
    }

    @Override
    double calculateFee() throws InvalidWeightException {
        return (getWeightKg()*10)+(getDistanceKm()*1.50);
    }

    @Override
    String getType() {
        return "Regular Parcel";
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
