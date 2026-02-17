package MixedNumber;

import java.util.Scanner;

public class Main_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. รับข้อมูลนำเข้า 3 จำนวน (จำนวนเต็ม, เศษ, ส่วน)
        int whole = scan.nextInt();
        int numerator = scan.nextInt();
        int denominator = scan.nextInt();

        // 2. สร้างอ็อบเจกต์จากคลาส Fraction
        Fraction f = new Fraction(numerator, denominator);

        // 3. สร้างอ็อบเจกต์จากคลาส MixedNumber
        MixedNumber m = new MixedNumber();

        // 4. กำหนดค่าผ่านเมธอด setValue
        m.setValue(whole, f);

        // 5. แสดงค่าผ่านเมธอด print
        m.print();
    }
}
