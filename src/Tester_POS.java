import java.util.Scanner;

import Project_101.Beverage;
import Project_101.Food;
import Project_101.Order;
import Project_101.Payment;

public class Tester_POS {
    public static void main(String[] args) {
        Beverage b1 = new Beverage("100","Matcha",100,100,true);
        Beverage b2 = new Beverage("101","Mocca",80,50,true);

        Food f1 = new Food("200","Steak",150,50,false);
        Food f2 = new Food("201","Potato",90,50,false);

        Order o1 = new Order("001");
        o1.addItem(f1);
        o1.addItem(f2);

        System.out.println(o1.itemCount);
        Scanner kb = new Scanner(System.in);
        System.out.print("Cash : ");
        int cash = kb.nextInt();
        Payment p1 = new Payment(o1,0.07);
        p1.processPayment(cash);

        o1.calculateTotal();

    }
}
