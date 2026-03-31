package No03;

import java.util.Scanner;

public class Tester{
    public static void main(String[] args) throws InvalidWeightException {
        Scanner kb = new Scanner(System.in);
        ParcelCenter parcel = new ParcelCenter();
        System.out.print("How many Pass sa du => ");
        int n = kb.nextInt();
        int validCount = 0;
        for (int i = 0; i < n; i++) {
            String currentTracking = "";
            try {
            System.out.println("==== Type ====" + "\n" +
                    "Press R to Regular" + "\n" +
                    "Press E to Express"+"\n"+
                    "==============");
            System.out.print("Enter your Type => ");
            String type = kb.next();

            switch (type){
                case "R" :
                        System.out.print("Enter your Tracking : ");
                        currentTracking = kb.next();
                        System.out.print("Enter your Name (No Space) : ");
                        String senderName = kb.next();
                        System.out.print("Enter Weight : ");
                        double weightKg = kb.nextDouble();
                        System.out.print("Enter Distance : ");
                        double distanceKm = kb.nextDouble();

                        RegularParcel r = new RegularParcel(currentTracking, senderName, weightKg, distanceKm);
                        parcel.addParcel(r);
                        validCount++;
                        System.out.println("\nTracking Status (0=CREATED, 1=IN_TRANSIT, 2=DELIVERED): ");
                        int statusCode = kb.nextInt();
                    break;
                case "E" :
                    System.out.print("Enter your Tracking : ");
                    String trackingE_No = kb.next();
                    System.out.print("Enter your Name (No Space) : ");
                    String senderE_Name = kb.next();
                    System.out.print("Enter Weight : ");
                    double weightE_Kg = kb.nextDouble();
                    System.out.print("Enter Distance : ");
                    double distanceE_Km = kb.nextDouble();

                    ExpressParcel e = new ExpressParcel(trackingE_No, senderE_Name, weightE_Kg, distanceE_Km);
                    parcel.addParcel(e);
                    validCount++;
                    System.out.println("\nTracking Status (0=CREATED, 1=IN_TRANSIT, 2=DELIVERED): ");
                    int statusCodeE = kb.nextInt();
                    break;
            }
            }catch (InvalidWeightException iw){
                System.out.println("ERROR " + currentTracking + " " + iw.getMessage());
            }catch (InvalidDistanceException id){
                System.out.println("ERROR " + currentTracking + " " + id.getMessage());
            }
        }
        System.out.println("REGULAR " + parcel.countByType("Regular Parcel"));
        System.out.println("Express     " + parcel.countByType("Express Parcel"));
        System.out.printf("MAX %s %.2f\n",parcel.maxFeeParcel().getTrackingNo(),parcel.maxFeeParcel().calculateFee());
        System.out.printf("%.2f",parcel.totalFee());
    }
}
