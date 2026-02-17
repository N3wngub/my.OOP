package MixedNumber;

import java.util.Scanner;

public class Main_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. รับค่าจำนวนคละตัวที่ 1
        int w1 = scan.nextInt();
        int n1 = scan.nextInt();
        int d1 = scan.nextInt();
        MixedNumber m1 = new MixedNumber();
        m1.setValue(w1, new Fraction(n1, d1));

        // 2. รับค่าจำนวนคละตัวที่ 2
        int w2 = scan.nextInt();
        int n2 = scan.nextInt();
        int d2 = scan.nextInt();
        MixedNumber m2 = new MixedNumber();
        m2.setValue(w2, new Fraction(n2, d2));

        // 3. บวกกัน
        MixedNumber result = m1.add(m2);

        // 4. แสดงผล
        result.print();
    }
}

