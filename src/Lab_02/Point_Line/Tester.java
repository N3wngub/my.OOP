package Point_Line;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        // 1) สร้าง p1, p2
        Point p1 = new Point(1, 1);
        Point p2 = new Point(5, 5);

        // 2) แสดง p1, p2
        System.out.println(p1);   // เรียก toString อัตโนมัติ
        System.out.println(p2);

        // 3) สร้าง lineA จาก p1, p2
        Line lineA = new Line(p1, p2);

        // 4) แสดง lineA + distance
        System.out.println(lineA);
        System.out.printf("Distance lineA : %.2f%n", lineA.distance());

        // 5) เปลี่ยนตำแหน่ง p1 -> (2,2) แล้วแสดงใหม่
        p1.setLocation(2, 2);
        System.out.println(lineA);
        System.out.printf("Distance lineA (after move p1) : %.2f%n", lineA.distance());

        // 6) สร้าง lineB จากจุด (2,3) และ (2,5)
        Line lineB = new Line(2, 3, 2, 5);
        System.out.println(lineB);
        System.out.printf("Distance lineB : %.2f%n", lineB.distance());

        // 7) รับข้อมูลจากผู้ใช้เพื่อสร้าง lineC
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter xStart yStart xEnd yEnd for lineC: ");
        int xStart = sc.nextInt();
        int yStart = sc.nextInt();
        int xEnd   = sc.nextInt();
        int yEnd   = sc.nextInt();

        Line lineC = new Line(xStart, yStart, xEnd, yEnd);

        // 8) แสดง lineC + distance
        System.out.println(lineC);
        System.out.printf("Distance lineC : %.2f%n", lineC.distance());

        // 9) หาเส้นที่ยาวที่สุด
        double dA = lineA.distance();
        double dB = lineB.distance();
        double dC = lineC.distance();

        String longestName = "lineA";
        double longest = dA;

        if (dB > longest) {
            longest = dB;
            longestName = "lineB";
        }
        if (dC > longest) {
            longest = dC;
            longestName = "lineC";
        }

        System.out.printf("The longest line is %s (length = %.2f)%n", longestName, longest);

        sc.close();
    }
}
