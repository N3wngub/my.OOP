package Transport;

import java.util.Scanner;

/*public class Tester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int rate = kb.nextInt();

        Logistics L1 = new Logistics();
        Truck T1 = new Truck();

        double total = L1.planDelivery(T1,rate);
        System.out.printf("%.2f",total);
        System.out.println();
        L1.deliver();
    }
}*/

public class Tester {
    public static void main(String[] args) {

            Scanner kb = new Scanner(System.in);

            int distance = kb.nextInt();

            String type = kb.next();

            Logistics log;

            if (type.equalsIgnoreCase("Road")) {

                log = new RoadLogistics();

                double price = log.planDelivery(distance);

                System.out.printf("%.2f\n", price);

                log.deliver();

            } else if (type.equalsIgnoreCase("Sea")) {

                log = new SeaLogistics();

                double price = log.planDelivery(distance);

                System.out.printf("%.2f\n", price);

                log.deliver();

            } else if (type.equalsIgnoreCase("Air")) {

                log = new AirLogistics();

                double price = log.planDelivery(distance);

                System.out.printf("%.2f\n", price);

                log.deliver();

            }

        }

    }





