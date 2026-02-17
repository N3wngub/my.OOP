package MixedNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int w1 = scan.nextInt();
        int n1 = scan.nextInt();
        int d1 = scan.nextInt();
        MixedNumber m1 = new MixedNumber();
        m1.setValue(w1, new Fraction(n1, d1));

        int w2 = scan.nextInt();
        int n2 = scan.nextInt();
        int d2 = scan.nextInt();
        MixedNumber m2 = new MixedNumber();
        m2.setValue(w2, new Fraction(n2, d2));

        MixedNumber result = m1.add(m2);

        result.print();
    }
}

