package MixedNumber;

import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. รับค่า
        int w = scan.nextInt();
        int n = scan.nextInt();
        int d = scan.nextInt();

        // 2. สร้าง Object
        MixedNumber m = new MixedNumber();
        m.setValue(w, new Fraction(n, d));

        // 3. แปลงเป็นเศษเกิน (จะได้เศษส่วนดิบๆ เช่น 54/10)
        Fraction improper = m.convertToFraction();

        // 4. สั่งจัดรูปแบบให้เป็นอย่างต่ำ (เพื่อให้ได้ 27/5 ตาม Example 3)
        Fraction result = improper.makeNewFormat();

        // 5. แสดงผล
        result.print();
    }
}