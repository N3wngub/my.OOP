package RectangleAndBox;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        Rectangle R1 = new Rectangle();
        System.out.print("Enter length of R1 : ");
        R1.setLength(kb.nextDouble());
        System.out.print("Enter width of R1 : ");
        R1.setWidth(kb.nextDouble());


        Rectangle R2 = new Rectangle();
        System.out.print("Enter length of R2 : ");
        R2.setLength(kb.nextDouble());
        System.out.print("Enter width of R2 : ");
        R2.setWidth(kb.nextDouble());

        System.out.println(R1.toString());
        System.out.println(R2.toString());

        System.out.println("Area of R1 = " + R1.getArea() + " Area of R2 = " + R2.getArea());

        if (R1.getArea() == R2.getArea()) {
            System.out.println("R1 is equal to R2!");
        } else if (R1.getArea() > R2.getArea()) {
            System.out.println("R1 is bigger than R2!");
        }else {
            System.out.println("R1 is smaller than R2!");
        }

        Box B1 = new Box();
        System.out.print("Enter [width, length, depth] of B1 : ");
        B1.setWidth(kb.nextDouble());
        B1.setLength(kb.nextDouble());
        B1.setDepth(kb.nextDouble());

        Box B2 = new Box();
        System.out.print("Enter [width, length, depth] of B2 : ");
        B2.setWidth(kb.nextDouble());
        B2.setLength(kb.nextDouble());
        B2.setDepth(kb.nextDouble());

        System.out.println(B1.toString());
        System.out.println(B2.toString());

        System.out.println("Volumn of B1 = " + B1.volumn() + " Volumn of B2 = " + B2.volumn());

        if (B1.surface() == B2.surface()) {
            System.out.println("B1 is equal to B2!");
        } else if (B1.surface() > B2.surface()) {
            System.out.println("B1 is more space than B2!");
        }else {
            System.out.println("B1 is little space than B2!");
        }


    }
}
