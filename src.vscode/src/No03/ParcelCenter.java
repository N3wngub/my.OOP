package No03;

import java.util.ArrayList;

public class ParcelCenter {
    private ArrayList<Parcel> parcels = new ArrayList<Parcel>();

    public void addParcel(Parcel p){
        parcels.add(p);
    }

    public Parcel findByTracking(String id) {
        for (int j = 0; j < parcels.size(); j++) {
            Parcel p = parcels.get(j);
            if (id.equalsIgnoreCase(p.getTrackingNo())){
                return p;
            }
        }
        return null;
    }


    public int countByType (String type){
        int count = 0;
        for (int i = 0; i < parcels.size(); i++) {
            Parcel p = parcels.get(i);
            if (type.equalsIgnoreCase(p.getType())){
                count++;
            }
        }
        return count;
    }

    public double totalFee() throws InvalidWeightException {
        double totalFee = 0;
        for (int j = 0; j < parcels.size(); j++) {
            Parcel c = parcels.get(j);
            totalFee += c.calculateFee();
        }
        return totalFee;
    }

    public Parcel maxFeeParcel() throws InvalidWeightException {
        double max = 0;
        Parcel maxParcel = null;
        for (int j = 0; j < parcels.size(); j++) {
            Parcel c = parcels.get(j);
            if (c.calculateFee() > max){
                max = c.calculateFee();
                maxParcel = c;
            }
        }
        return maxParcel;
    }

}
