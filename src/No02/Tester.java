package No02;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws InvalidDayException {
        ArrayList<Vehicle> park = new ArrayList<Vehicle>();
        Scanner kb = new Scanner(System.in);
        System.out.print("How many Car u want to create => ");
        int n = kb.nextInt();


        int days = 0;
        while (true) {
            System.out.print("How many Day u parking => ");
            days = kb.nextInt();
            try {
                if (days <= 0) throw new InvalidDayException(days);
                break;
            } catch (InvalidDayException it) {
                System.out.println(it.getMessage() + " Please try again.");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Parking No." + (i + 1));
            System.out.println("===== type =====" + "\n" + "Car prss 1" + "\n" + "Moto press 2");
            System.out.print("What Type u want => ");
            int type = kb.nextInt();
            switch (type) {
                case 1:
                    System.out.print("Input your ID => ");
                    String id = kb.next();
                    System.out.print("Input your Brand => ");
                    String brand = kb.next();
                    int baseRate = 100;
                    System.out.print("Input your Seat => ");
                    int seat = kb.nextInt();
                    Vehicle c = new Car(id, brand, baseRate, seat);
                    park.add(c);
                    break;
                case 2:
                    System.out.print("Input your ID => ");
                    String idMoto = kb.next();
                    System.out.print("Input your Brand => ");
                    String brandMoto = kb.next();
                    int baseRateMoto = 100;
                    System.out.print("Input your EngineCC => ");
                    int engineCC = kb.nextInt();
                    Vehicle m = new Motorcycle(idMoto, brandMoto, baseRateMoto, engineCC);
                    park.add(m);
            }
        }

        for (int i = 0; i < park.size(); i++) {
            Vehicle C = park.get(i);
            System.out.println("===================");
            System.out.println("Parking No." + (i + 1));
            System.out.println(C.calculateRent(days));
            System.out.println("==== insurance ====");
            System.out.println(C.getTotalCost(days));
        }
        System.out.println("===== average =====");
        double total = 0;
        for (int i = 0; i < park.size(); i++) {
            total += park.get(i).getTotalCost(days);
        }
        if (!park.isEmpty()) {
            double av = total / park.size();
            System.out.println("Average cost: " + av);
        } else {
            System.out.println("No cars in park.");
        }


    }
}
