package myZoo;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {


        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Animal[] animal = new Animal[n];


        for (int i = 0; i < animal.length; i++) {
            String type = kb.next();
            String name = kb.next();

            if (type.equals("Duck") ) {
                animal[i] = new Duck(name);
                Poultry.count++;
            } else if (type.equals("Chicken")) {
                animal[i] = new Chicken(name);
                Poultry.count++;
            } else if (type.equals("Parrot")) {
                animal[i] = new Parrot(name);
                Poultry.count++;
            } else if (type.equals("Shark")){
                animal[i] = new Shark(name);
                Fish.count++;
            }else if (type.equals("Dolphin")){
                animal[i] = new Dolphin(name);
                Fish.count++;
            }else if (type.equals("Ray")) {
                animal[i] = new Ray(name);
                Fish.count++;
            }
        }

        System.out.println();

        for (int i = 0; i < animal.length; i++) {
            System.out.println(animal[i]);
        }

        System.out.println();

        System.out.println("Count Poultry = " + Poultry.count);
        System.out.println("Fish Poultry = " + Fish.count);


    }
}

