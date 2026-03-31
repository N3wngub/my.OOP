package No01;

import java.io.IOException;
import java.util.ArrayList;

public class Tester{
    public static void main(String[] args){
        ArrayList<Drink> CM = new ArrayList<Drink>();
        try {
            Drink c = new Coffee("Nong cha", 20);
            Drink t = new Tea("Nong Pim", 25, 3);
            Drink tnS = new Tea("Nong New", 25, 0);
            CM.add(c);
            CM.add(t);
            CM.add(tnS);
        }catch (InvalidPriceException p){
            System.out.println(p.getMessage());
        }catch (InvalidSweet s){
            System.out.println(s.getMessage());
        }catch (Exception e){
            System.out.println("Error!!");
        }

        for (int i = 0; i < CM.size(); i++) {
            Drink A = CM.get(i);
            System.out.println("Name : " + A.getName()+" -> "+"Price : " + A.calculatePrie());
        }
        System.out.println("====== Discount Price ======");
        for (int i = 0; i < CM.size(); i++) {
            Drink D = CM.get(i);
            System.out.println("Name : " + D.getName()+" -> "+"Price : " + D.getFinalPrice());
        }
    }
}
