package MixedNumber;

import java.util.Scanner;

public class Main_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. รับค่า 3 จำนวน
        int w = scan.nextInt();
        int n = scan.nextInt();
        int d = scan.nextInt();

        // 2. สร้าง Object และกำหนดค่า
        MixedNumber m = new MixedNumber();
        m.setValue(w, new Fraction(n, d));

        // 3. เรียกเมธอด makeNewFormat เพื่อจัดรูปแบบ (ตามโจทย์สั่ง)
        // เมธอดนี้จะคืนค่ากลับมาเป็น Object ใหม่ที่เป็นระเบียบแล้ว
        MixedNumber result = m.makeNewFormat();

        // 4. แสดงผล
        result.print();
    }
}