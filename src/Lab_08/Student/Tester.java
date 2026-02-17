package Student;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. รับจำนวนนักเรียน
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // สร้าง Array ไว้เก็บข้อมูล object Student ตามจำนวน n
        Student[] students = new Student[n];

        // 2. วนรับข้อมูลนักเรียนแต่ละคนจนครบ
        for (int i = 0; i < n; i++) {
            System.out.println("\nData for student " + (i + 1));

            System.out.print("Enter ID (8 digits): ");
            String id = scanner.next();

            System.out.print("Enter Name: ");
            String name = scanner.next();

            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();

            // ส่งข้อมูลไปสร้าง Object Student แล้วเก็บลง Array
            students[i] = new Student(id, name, gpa);
        }

        System.out.println("\n---------------- Result ----------------");

        // 3. ทำการตรวจสอบและแสดงผล (ชื่อ ประเภท และ สถานะ)
        for (int i = 0; i < n; i++) {
            Student s = students[i];

            // เรียกใช้ Method จาก Class Student
            System.out.println(s.getName() + " (" + s.getType() + ") และ " + s.checkStatus());
        }

        scanner.close();
    }
}